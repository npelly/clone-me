#!/bin/bash

if [ -z "$1" ]
  then
    echo "USAGE: ./clone-me.sh NewProjectName"
    echo " Clones this template project side-by-side"
    exit
fi

export NAME=$1
export NAME_LOWER=$(echo "$NAME" | tr '[:upper:]' '[:lower:]')

cd ..
cp -r CloneMe $NAME
rm -rf $NAME/app/build
rm -rf $NAME/.idea
rm -rf $NAME/.gradle
mv $NAME/app/src/main/java/com/npelly/cloneme $1/app/src/main/java/com/npelly/$NAME_LOWER
mv $NAME/CloneMe.iml $NAME/$Name.iml
find $NAME -type f | LC_ALL=C xargs sed -i '' "s/CloneMe/$NAME/g"
find $NAME -type f | LC_ALL=C xargs sed -i '' "s/cloneme/$NAME_LOWER/g"