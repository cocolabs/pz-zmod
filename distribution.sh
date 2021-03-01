#!/bin/bash

printf 'Staging distribution...\n'
./gradlew stageDistribution

printf '\nListing files ignored by git...\n'

# disable distribution gitignore
mv stage/.gitignore stage/.gitignore_

find . -path ./.git -prune -o -print | git check-ignore --no-index --stdin > .gitignored

# enable distribution gitignore
mv stage/.gitignore_ stage/.gitignore

printf '\nPruning distribution stage...\n'
./gradlew pruneDistributionStage

printf '\nAssembling distribution...\n'
./gradlew assembleDist

printf '\nCleaning distribution stage...\n'
./gradlew cleanDistributionStage

printf '\n'
read -p "Press enter to continue"
