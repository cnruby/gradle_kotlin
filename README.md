<a href = "https://kotlinlang.org/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Kotlin-Programming%20Language%20with%20Gradle-black?style=flat&logo=kotlin" alt = "The Java Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![kotlin lang)](https://img.shields.io/github/v/release/JetBrains/kotlin?label=kotlin&logo=kotlin)](https://github.com/JetBrains/kotlin)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_105.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_105)



---

basic_105 Hello Own Library!
<h1>Unit 105: Hello Own Library!</h1>

---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A Kotlin Application with Gradle](#create-a-kotlin-application-with-gradle)
  - [DO (create a kotlin project)](#do-create-a-kotlin-project)
  - [DO (check the project)](#do-check-the-project)
- [Add A Kotlin Library Sub-Project](#add-a-kotlin-library-sub-project)
  - [DO (edit the gradle settings file)](#do-edit-the-gradle-settings-file)
  - [DO (create a library build file of gradle)](#do-create-a-library-build-file-of-gradle)
  - [DO (show all projects)](#do-show-all-projects)
  - [DO (create a kotlin file folder)](#do-create-a-kotlin-file-folder)
- [Version 1: Kotlin Library Sub-Project](#version-1-kotlin-library-sub-project)
  - [DO (create and edit the kotlin library file)](#do-create-and-edit-the-kotlin-library-file)
- [Use The Sub-Project `lib` in the Sub-Project `app`](#use-the-sub-project-lib-in-the-sub-project-app)
  - [DO (edit the build file of gradle)](#do-edit-the-build-file-of-gradle)
- [Version 1: The Sub-Project `app`](#version-1-the-sub-project-app)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file)
  - [Run the Project with Gradle](#run-the-project-with-gradle)
- [Version 2: Kotlin Library Sub-Project `lib`](#version-2-kotlin-library-sub-project-lib)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file-1)
- [Version 2: The Sub-Project `app`](#version-2-the-sub-project-app)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file-2)
  - [DO (run the Project with Gradle)](#do-run-the-project-with-gradle)
- [Version 3: Kotlin Library Sub-Project `lib`](#version-3-kotlin-library-sub-project-lib)
  - [DO (create and edit the kotlin file)](#do-create-and-edit-the-kotlin-file)
- [Version 3: The Sub-Project `app`](#version-3-the-sub-project-app)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file-3)
  - [DO (run the Project with Gradle)](#do-run-the-project-with-gradle-1)
- [Version 4: Kotlin Library Sub-Project `lib`](#version-4-kotlin-library-sub-project-lib)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file-4)
- [Version 4: The Sub-Project `app`](#version-4-the-sub-project-app)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file-5)
  - [DO (run the Project with Gradle)](#do-run-the-project-with-gradle-2)
- [References for tools](#references-for-tools)



## Keywords
- Kotlin Project `One Application`
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Kotlin REPL Ubuntu Gradle jabba JDK Java JVM



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- install `git`, `wget` and `curl` on Ubuntu 20.04
- install [jabba](https://github.com/shyiko/jabba) and Java JDK [Hello jabba!](https://github.com/cnruby/gradle_java/tree/basic_101)
- [install Command Line Kotlin Compiler (REPL)](https://kotlinlang.org/docs/tutorials/command-line.html) 
- [install IntelliJ CE / IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/#section=linux)



## Create A Kotlin Application with Gradle

### DO (create a kotlin project)
```bash
EXISTING_APP_ID=104 && NEW_APP_ID=105 && \
git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin && \
cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Add A Kotlin Library Sub-Project

### DO (edit the gradle settings file)
```bash
nano ./settings.gradle.kts
```
```bash
# FILE (settings.gradle.kts)
rootProject.name = "_gradle_kotlin"
include("app", "lib")
```

### DO (create a library build file of gradle)
```bash
mkdir ./lib
```
```bash
touch ./lib/build.gradle.kts
```
```bash
nano ./lib/build.gradle.kts
```
```bash
# FILE (lib/build.gradle.kts)
plugins { id("org.jetbrains.kotlin.jvm") version "1.3.72" }
repositories { jcenter() }
dependencies { implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") }
```

### DO (show all projects)
```bash
./gradlew -q projects
    # >> Result
    ------------------------------------------------------------
    Root project
    ------------------------------------------------------------

    Root project '_gradle_kotlin'
    +--- Project ':app'
    \--- Project ':lib'

    To see a list of the tasks of a project, run gradlew <project-path>:tasks
    For example, try running gradlew :app:tasks
```

### DO (create a kotlin file folder)
```bash
mkdir -p ./lib/src/main/kotlin/de/iotoi
```



## Version 1: Kotlin Library Sub-Project
- Use Only Readable Property of Class

### DO (create and edit the kotlin library file)
```bash
touch ./lib/src/main/kotlin/de/iotoi/HelloLib.kt
```
```bash
nano ./lib/src/main/kotlin/de/iotoi/HelloLib.kt
```
```kotlin
// FILE (HelloLib.kt)
class HelloLib {
    val greeting: String
        get() {
            return "Hello World!"
        }
}
```



## Use The Sub-Project `lib` in the Sub-Project `app`

### DO (edit the build file of gradle)
```bash
nano ./app/build.gradle.kts
```
```bash
# FILE (./app/build.gradle.kts)
...
dependencies {
    implementation(project(":lib"))
...
```



## Version 1: The Sub-Project `app`

### DO (edit the kotlin file)
```bash
nano ./app/src/main/kotlin/de/iotoi/App.kt
```
```kotlin
// FILE (App.kt)
package de.iotoi

fun main() {
    println(HelloLib().greeting)
}
```

### Run the Project with Gradle
```bash
./gradlew -q app:run
```
```bash
    # >> Result
    Hello World!
```



## Version 2: Kotlin Library Sub-Project `lib`
- Use Readable and Writable Property of normal `class`

### DO (edit the kotlin file)
```bash
nano ./lib/src/main/kotlin/de/iotoi/HelloLib.kt
```
```kotlin
// FILE (HelloLib.kt)
// !!! Attention: The follow word `field` of Kotlin
package de.iotoi

class App {
    var greeting: String = "Hello World!"
        get() {
            return field
        }
        set(value) {
            field = value
        }
}
```


## Version 2: The Sub-Project `app`

### DO (edit the kotlin file)
```bash
nano ./app/src/main/kotlin/de/iotoi/App.kt
```
```kotlin
// FILE (App.kt)
package de.iotoi

fun main() {
    // Use the normal `class HelloLib`
    println(HelloLib().greeting)

    var helloLib = HelloLib()
    helloLib.greeting = "Hallo Welt!"
    println(helloLib.greeting)
}
```

### DO (run the Project with Gradle)
```bash
./gradlew -q app:run
```
```bash
    # >> Result
    Hello World!
    Hallo Welt!
```



## Version 3: Kotlin Library Sub-Project `lib`
- Use Readable and Writable Property of `data class`

### DO (create and edit the kotlin file)
```bash
touch ./lib/src/main/kotlin/de/iotoi/DataHelloLib.kt
```
```bash
nano ./lib/src/main/kotlin/de/iotoi/DataHelloLib.kt
```
```kotlin
// FILE (DataHelloLib.kt)
package de.iotoi

data class DataHelloLib (var greeting: String = "Hello!")
```



## Version 3: The Sub-Project `app`

### DO (edit the kotlin file)
```bash
nano ./app/src/main/kotlin/de/iotoi/App.kt
```
```kotlin
// FILE (App.kt)
...
    // Use the special `data class DataHelloLib`
    println(DataHelloLib().greeting)

    var dataHelloLib = DataHelloLib()
    dataHelloLib.greeting = "Hallo"
    println(dataHelloLib.greeting)
}
```

### DO (run the Project with Gradle)
```bash
./gradlew -q app:run
```
```bash
    # >> Result
    Hello World!
    Hallo Welt!
    Hello!
    Hallo
```



## Version 4: Kotlin Library Sub-Project `lib`
- Use Different Readable Styles of Property in normal `class`

### DO (edit the kotlin file)
```bash
nano ./lib/src/main/kotlin/de/iotoi/HelloLib.kt
```
```kotlin
// FILE (HelloLib.kt)
...
    var greeting2: String = "Hallo Welt!"
        get() = field
        set(value) {
            field = value
        }

    var greeting3: String = "世界，你好!"
        get(): String = field
        set(value) {
            field = value
        }
}
```



## Version 4: The Sub-Project `app`

### DO (edit the kotlin file)
```bash
nano ./app/src/main/kotlin/de/iotoi/App.kt
```
```kotlin
// FILE (App.kt)
...
    // Use different styles
    println(helloLib.greeting2)
    println(helloLib.greeting3)
}
```

### DO (run the Project with Gradle)
```bash
./gradlew -q app:run
```
```bash
    # >> Result
    Hello World!
    Hallo Welt!
    Hello!
    Hallo
    Hallo Welt!
    世界，你好!
```



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
