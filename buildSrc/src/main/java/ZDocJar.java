import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;

import groovy.lang.Closure;

import org.gradle.api.NonNullApi;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.plugins.ExtraPropertiesExtension;
import org.gradle.jvm.tasks.Jar;
import org.gradle.util.GUtil;

@NonNullApi
public class ZDocJar extends Jar {

	private static final String GAME_VERSION_PROPERTY = "mod.pzversion";
	private final Project project = this.getProject();

	public ZDocJar() {

		getArchiveFileName().set(project.provider(() -> {
			ExtraPropertiesExtension ext = project.getExtensions().getExtraProperties();
			if (ext.has(GAME_VERSION_PROPERTY))
			{
				String name = GUtil.elvis(getArchiveBaseName().getOrNull(), "");
				name = name + maybe(name, getArchiveAppendix().getOrNull());

				Object pGameVersion = Objects.requireNonNull(ext.get(GAME_VERSION_PROPERTY));
				name = name + maybe(name, pGameVersion.toString().trim());
				name = name + maybe(name, getArchiveClassifier().getOrNull());

				String extension = this.getArchiveExtension().getOrNull();
				return name + (GUtil.isTrue(extension) ? "." + extension : "");
			}
			return getArchiveFileName().get();
		}));
	}

	private static String maybe(@Nullable String prefix, @Nullable String value) {
		return GUtil.isTrue(value) ? GUtil.isTrue(prefix) ? "-".concat(value) : value : "";
	}

	@Override
	public Task configure(Closure closure) {
		Task configure = super.configure(closure);
		/*
		 * additional configuration actions
		 */
		setGroup("zomboid");
		dependsOn(project.getTasks().named("zomboidVersion"));
		getTaskByName("jar").dependsOn(this);
		return configure;
	}

	/**
	 * Returns single {@code Task} with the given name
	 *
	 * @throws NoSuchElementException when the requested task was not found
	 */
	private Task getTaskByName(String name) {
		try {
			return project.getTasksByName(name, false).iterator().next();
		}
		catch (NoSuchElementException e) {
			throw new NoSuchElementException("Unable to find " + name + " gradle task");
		}
	}
}
