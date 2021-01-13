<a href = "https://kotlinlang.org/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Kotlin-Programming%20Language%20with%20Gradle-black?style=flat&logo=kotlin" alt = "The Kotlin Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![kotlin lang)](https://img.shields.io/github/v/release/JetBrains/kotlin?label=kotlin&logo=kotlin)](https://github.com/JetBrains/kotlin)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_104.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_104)

---

basic_104 Hello One Application!
<h1>Unit 104: Hello One Application!</h1>

---


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A Kotlin Application with Gradle](#create-a-kotlin-application-with-gradle)
  - [DO (create a kotlin project)](#do-create-a-kotlin-project)
  - [DO (check the project)](#do-check-the-project)
- [Run the Project with Gradle](#run-the-project-with-gradle)
- [Develop the Testing Code](#develop-the-testing-code)
  - [DO (Test the project)](#do-test-the-project)
  - [DO (edit the test file)](#do-edit-the-test-file)
  - [DO (Test the project again)](#do-test-the-project-again)
- [Understand the Kotlin Code in the Project](#understand-the-kotlin-code-in-the-project)
  - [keyword `class` and `.`](#keyword-class-and-)
  - [keyword `val`](#keyword-val)
  - [function `get()` and pure function `f(x) = y`](#function-get-and-pure-function-fx--y)
  - [keyword `import`](#keyword-import)
  - [keyword `@Test`](#keyword-test)
  - [keyword `val` and `=`](#keyword-val-and-)
- [Question: How to get name of any class?](#question-how-to-get-name-of-any-class)
- [References](#references)



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
gradle init
```
```bash
Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Scala
  6: Swift
Enter selection (default: Java) [1..6] 4

Split functionality across multiple subprojects?:
  1: no - only one application project
  2: yes - application and library projects
Enter selection (default: no - only one application project) [1..2] 1

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Kotlin) [1..2] 2

Project name (default: 104_gradle_kotlin): 
Source package (default: _gradle_kotlin): de.iotoi

> Task :init
Get more help with your project: https://docs.gradle.org/6.7.1/samples/sample_building_kotlin_applications_multi_project.html

BUILD SUCCESSFUL in 33s
2 actionable tasks: 2 executed
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Run the Project with Gradle
```bash
./gradlew -q run
```
```bash
    # >> Result
    Hello World!
```


## Develop the Testing Code

### DO (Test the project)
```bash
./gradlew -q test
```
```bash
    # >> Result: nothing
```

### DO (edit the test file)
```bash
nano app/src/test/kotlin/de/iotoi/AppTest.kt
```
```kotlin
# FILE (AppTest.kt)
//...
import kotlin.test.assertNotNull
import kotlin.test.assertEquals

class AppTest {
//...
//...
    @Test fun testType(){
        val greeting = App().greeting
        assertEquals(greeting.javaClass.name, "java.lang.String");
        assertEquals(greeting.javaClass.kotlin.qualifiedName, "kotlin.String");

        assertEquals(greeting::class.simpleName, "String");
        assertEquals(greeting::class.qualifiedName, "kotlin.String");
    }
//...
```

### DO (Test the project again)
```bash
./gradlew -q test
```
```bash
    # >> Result: nothing
```



## Understand the Kotlin Code in the Project

### keyword `class` and `.`
- declare a class and use a class
- use function of a class

### keyword `val`
- Declare immutable variables: val

### function `get()` and pure function `f(x) = y`
```kotlin
    // !!! VERSION 1: variable-styled
    val greeting: String = "Hello World!"
```

```kotlin
    // !!! VERSION 2: method-styled
    val greeting: String
        get() {
            return "Hello World!"
        }
```

```kotlin
    // !!! VERSION 3: function-styled
    val greeting: String
        get() = "Hello World!"
```

### keyword `import`

### keyword `@Test`

### keyword `val` and `=`
- declare an immutable variable



## Question: How to get name of any class?
- https://stackoverflow.com/questions/53359407/how-to-get-name-of-any-class
- https://stackoverflow.com/questions/32684739/kotlin-get-type-as-string

```kotlin
val obj: Double = 5.0

System.out.println(obj.javaClass.name)                 // double
System.out.println(obj.javaClass.kotlin)               // class kotlin.Double
System.out.println(obj.javaClass.kotlin.qualifiedName) // kotlin.Double
```



## References
- https://developer.ibm.com/tutorials/learn-kotlin-3/
- https://developer.ibm.com/tutorials/learn-kotlin-4/
- https://kotlinlang.org/docs/reference/properties.html
- https://www.programiz.com/kotlin-programming/getters-setters