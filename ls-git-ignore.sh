#!/bin/bash
# Create a list of all file-paths ignored by git
find . -path ./.git -prune -o -print | git check-ignore --no-index --stdin > .gitignored