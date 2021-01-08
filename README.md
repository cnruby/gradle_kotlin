<a href = "https://kotlinlang.org/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Kotlin-Programming%20Language%20with%20Gradle-black?style=flat&logo=kotlin" alt = "The Java Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![kotlin lang)](https://img.shields.io/github/v/release/JetBrains/kotlin?label=kotlin&logo=kotlin)](https://github.com/JetBrains/kotlin)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_103.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_103)



---

basic_103 Hello Kotlin with Gradle!
<h1>Unit 103: Hello Kotlin with Gradle!</h1>

---


- [Keywords](#keywords)
- [Kotlin and Java Language](#kotlin-and-java-language)
- [iOS and Android OS](#ios-and-android-os)
- [Kotlin Language](#kotlin-language)
- [References](#references)
- [References for comment](#references-for-comment)
- [References for tutorials](#references-for-tutorials)
- [Other References](#other-references)



## Keywords
- install Kotlin REPL Ubuntu Gradle jabba JDK Java JVM
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example


## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- install `git`, `wget` and `curl` on Ubuntu 20.04
- install [jabba](https://github.com/shyiko/jabba) and Java JDK [Hello jabba!](https://github.com/cnruby/gradle_java/tree/basic_101)
- [install Command Line Kotlin Compiler (REPL)](https://kotlinlang.org/docs/tutorials/command-line.html) 
- [install IntelliJ CE / IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/#section=linux)



## Create a kotlin project with gradle

### DO (create and edit the gradle setting file)
```bash
touch ./settings.gradle.kts
```
```bash
nano ./settings.gradle.kts
```
```bash
# FILE (settings.gradle.kts)
rootProject.name = "_gradle_kotlin"
```

### DO (create and edit the gradle build file)
```bash
touch ./build.gradle.kts
```
```bash
nano ./build.gradle.kts
```
```bash
# FILE (build.gradle.kts)
plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.72"
    application
}
repositories { jcenter() }
dependencies { implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") }
application { mainClass.set("de.iotoi.HelloKt") }
```

### DO (generate Gradle wrapper files)
```bash
gradle wrapper
```
```bash
    # >> Result
    BUILD SUCCESSFUL in 6s
    1 actionable task: 1 executed
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Develop the Kotlin Application Project

### DO (make the code folder)
```bash
mkdir -p ./src/main/kotlin/de/iotoi
```

### DO (create and edit the kotlin file)
```bash
touch ./src/main/kotlin/de/iotoi/Hello.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/Hello.kt
```
```kotlin
// FILE (App.kt)
package de.iotoi

fun main(args: Array<String>) {
    for(arg in args) {
        print("$arg ")
    }
    println()
    println("Hello World!")
}
```

### DO (run the application)
```bash
./gradlew -q run --args="Hallo Welt!"
```
```bash
    # Result
    Hallo Welt!
    Hello World!
```



## Run The Kotlin Application as a distribution

### DO (assemble and tests this project)
```bash
./gradlew -q clean build
```
```bash
    # >> Result: nothing
```

### DO (unzip the distribution)
```bash
unzip ./build/distributions/_gradle_kotlin.zip
```

### DO (run the application on OS)
```bash
_gradle_kotlin/bin/_gradle_kotlin Hallo Welt!
```
```bash
    # >> Result
    Hallo Welt!
    Hello World!
```



## Run The Kotlin Application as a distribution as-is

### DO (install the project as a distribution as-is)
```bash
./gradlew clean installDist
```

### DO (run the application on OS)
```bash
./build/install/_gradle_kotlin/bin/_gradle_kotlin Hallo Welt!
```
```bash
    # >> Result
    Hallo Welt!
    Hello World!
```



## Understanding Code

### keyword `package`

### keyword `:`

### keyword `String`

### keyword `Array<String>`

### keyword `for in`

### method `print`