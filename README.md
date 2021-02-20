# ZomboidMod

ZomboidMod is a compact mod development environment for [Project Zomboid](https://projectzomboid.com/blog/).

It is essentially a wrapper for you mod that enables powerful [IDE](https://en.wikipedia.org/wiki/Integrated_development_environment) features and improves your modding workflow. With a collection of [Gradle](https://gradle.org/) scripts it helps automate the process of setting up, assembling and deploying your project.

## Introduction

Whether you are a creating textures, models, maps or writing code you are working with often large and complex collections of files. These files need to be interpreted, and (in case of mod files) version controlled. Since we are human beings, we are not nearly as good at interpreting and storing raw data as machines are. This is why we need their help through advanced tools such as [Git](https://git-scm.com/) and IDE's. Git helps manage our mod versions, while an IDE provides powerful features to increase efficiency, offer code assistance, and make development more enjoyable.

- Increased efficiency means an overall higher mod quality.  
- Code analysis helps spot bugs and avoid lengthy debugging sessions. 
- Code navigation helps quickly find what we are looking for saving us time and energy.
- More enjoyable workflow brings more motivation used to create amazing mods.

ZomboidMod serves as an umbrella for these tools, connecting everything you need in one system.

## Features

- Decompiles and packages game classes to expose game engine code.
- Uses [ZomboidDoc](https://github.com/yooksi/pz-zdoc/) to compile a readable and always up-to-date modding Lua library.
- Compact workspace that can be used straight out of the box.
- Easy installation steps for enabling advanced features.
- Comes pre-configured for use with Git. 
- Fully integrates with IntelliJ IDEA.

