<a href = "https://kotlinlang.org/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Kotlin-Programming%20Language%20with%20Gradle-black?style=flat&logo=kotlin" alt = "The Java Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![kotlin lang)](https://img.shields.io/github/v/release/JetBrains/kotlin?label=kotlin&logo=kotlin)](https://github.com/JetBrains/kotlin)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_102.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_102)


---


basic_102 Hello Kotlin Compiler!
<h1>Unit 102: Hello Kotlin Compiler!</h1>

- Use Command Line Kotlin Compiler


---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Kotlin Version](#kotlin-version)
  - [Use Java 8](#use-java-8)
  - [Use Java 11](#use-java-11)
  - [References 1](#references-1)
- [Kotlin REPL](#kotlin-repl)
  - [Use Kotlin REPL](#use-kotlin-repl)
  - [References 2](#references-2)
- [Run Kotlin Application as Jar file](#run-kotlin-application-as-jar-file)
- [Run Kotlin Application](#run-kotlin-application)
- [Understand Code](#understand-code)
  - [keyword `fun`](#keyword-fun)
  - [keyword `main`](#keyword-main)
  - [function `println`](#function-println)
- [References](#references)



## Keywords
- Using Kotlin REPL
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE`
- tutorial example Ubuntu Gradle jabba JDK Java JVM



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- install `git`, `wget` and `curl` on Ubuntu 20.04
- install [jabba](https://github.com/shyiko/jabba) and Java JDK [Hello jabba!](https://github.com/cnruby/gradle_java/tree/basic_101)
- [install Command Line Kotlin Compiler (REPL)](https://kotlinlang.org/docs/tutorials/command-line.html) 
- [install IntelliJ CE / IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/#section=linux)



## Kotlin Version

### Use Java 8
```bash
# DO (check kotlin)
kotlin -version
    # >> Result
    Kotlin version 1.4.20-release-308 (JRE 1.8.0_272-b17)

# DO (check kotlin REPL version)
kotlinc -version
    # >> Result
    info: kotlinc-jvm 1.4.20 (JRE 1.8.0_272-b17)
```

### Use Java 11
```bash
# DO (check kotlin)
kotlin -version
    # >> Result
    Kotlin version 1.4.20-release-308 (JRE 11.0.9+11-LTS)

# DO (check kotlin REPL version)
kotlinc -version
    # >> Result
    info: kotlinc-jvm 1.4.20 (JRE 11.0.9+11-LTS)
    WARNING: An illegal reflective access operation has occurred
    WARNING: Illegal reflective access by com.intellij.util.ReflectionUtil to method java.util.ResourceBundle.setParent(java.util.ResourceBundle)
    WARNING: Please consider reporting this to the maintainers of com.intellij.util.ReflectionUtil
    WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
    WARNING: All illegal access operations will be denied in a future release

# DO ()
export _JAVA_OPTIONS=--illegal-access=warn
kotlinc -version
    # >> Result
    Picked up _JAVA_OPTIONS: --illegal-access=warn
    info: kotlinc-jvm 1.4.20 (JRE 11.0.9+11-LTS)
    WARNING: Illegal reflective access by com.intellij.util.ReflectionUtil to method java.util.ResourceBundle.setParent(java.util.ResourceBundle)
```

### References 1
- https://backstage.forgerock.com/knowledge/kb/article/a15048811
- https://stackoverflow.com/questions/50251798/what-is-an-illegal-reflective-access
- https://youtrack.jetbrains.com/issue/KT-43704
- https://stackoverflow.com/questions/53790182/get-the-current-value-of-illegal-access-setting-in-java



## Kotlin REPL

### Use Kotlin REPL
```bash
# DO (start Kotlin REPL)
kotlin
# DO (or)
kotlinc
    # >> Result
    Welcome to Kotlin version 1.4.20 (JRE 1.8.0_272-b17)
    Type :help for help, :quit for quit
    # DO (enter `:help`)
    >>> :help
    Available commands:
    :help                   show this help
    :quit                   exit the interpreter
    :dump bytecode          dump classes to terminal
    :load <file>            load script from specified file
    # DO (enter `println("Hello, Kotlin!")`)
    >>> println("Hello, Kotlin!")
    Hello, Kotlin!
    >>> :quit
```

### References 2
- https://developer.ibm.com/languages/java/tutorials/learn-kotlin-2/
- https://kotlinlang.org/docs/tutorials/command-line.html




## Run Kotlin Application as Jar file

```bash
# DO (create a folder for Kotlin code)
mkdir build

# DO (create a new kotlin file)
touch hello.kt

# DO (edit the new file)
nano hello.kt
    # FILE (./hello.kt)
    fun main() {
        println("Hello, World!")
    }

# DO (Compile the application using the Kotlin compiler)
kotlinc hello.kt -include-runtime -d ./build/hello.jar
```

```bash
# IF (want to see all available options)
    kotlinc -help
# ENDIF

# DO (use java command to run the application)
java -jar ./build/hello.jar
    # >> Result
    Hello, World!

# DO (use kotlin command to run the application)
kotlin ./build/hello.jar
    # >> Result
    Hello, World!
```



## Run Kotlin Application

```bash
# DO (create a Kotlin file)
touch ./hallo.kt

# DO (edit a Kotlin file)
kotlinc ./hallo.kt -d ./build

# DO (run Kotlin application)
kotlin -classpath ./build HalloKt
```



## Understand Code

### keyword `fun`

### keyword `main`

### function `println`



## References
- https://kotlinlang.org/
- https://github.com/saschpe/docker-kotlin/blob/master/Dockerfile