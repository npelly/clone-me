# clone-me
Create Android App ready to built or load into Android Studio.

Example:
  clone-me/clone-me.sh foo
  # can optionally import to android studio, or just build...
  ./gradlew build
  ./gradlew installDebug

App is cloned from the template inside this project.

Template Features
- God singleton object (Base.java).
- Main UI shows package name, version, and debug log.