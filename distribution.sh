#!/bin/bash
echo Listing files ignored by git...
find . -path ./.git -prune -o -print | git check-ignore --no-index --stdin > .gitignored

echo Assembling distribution...
./gradlew assembleDist

read -p "Press enter to continue"
