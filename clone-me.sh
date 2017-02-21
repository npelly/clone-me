#!/bin/bash

if [ -z "$1" ]
  then
    echo "USAGE: clone-me/clone-me.sh NewProjectName"
    echo " Clone the template project into new project."
    echo ""
    echo " Must be run from parent directory. New project created in NewProjectName directory."
    exit
fi

export NAME=$1
export NAME_LOWER=$(echo "$NAME" | tr '[:upper:]' '[:lower:]')

cp -r clone-me $NAME
rm -rf $NAME/app/build
rm -rf $NAME/build
rm -rf $NAME/.idea
rm -rf $NAME/.gradle
rm -rf $NAME/.git
rm -rf $NAME/*.iml
rm -rf $NAME/app/*.iml
rm -rf $NAME/.DS_Store
rm -rf $NAME/captures
rm -rf $NAME/README.md
rm -rf $NAME/clone-me.sh

mv $NAME/app/src/main/java/com/npelly/cloneme $1/app/src/main/java/com/npelly/$NAME_LOWER
#mv $NAME/CloneMe.iml $NAME/$Name.iml
find $NAME -type f | LC_ALL=C xargs perl -pi -e "s/CloneMe/$NAME/g"
find $NAME -type f | LC_ALL=C xargs perl -pi -e "s/cloneme/$NAME_LOWER/g"