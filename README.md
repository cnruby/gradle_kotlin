<a href = "https://kotlinlang.org/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Kotlin-Programming%20Language%20with%20Gradle-black?style=flat&logo=kotlin" alt = "The Kotlin Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![kotlin lang)](https://img.shields.io/github/v/release/JetBrains/kotlin?label=kotlin&logo=kotlin)](https://github.com/JetBrains/kotlin)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_204.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_204)


---


Unit 204: Hello @Value!
<h1>Unit 204: Hello @Value!</h1>

- Hot to Understand An Annotation @Value for function
- Hot to Understand An Annotation @Value for class
- Hot to Understand An Annotation @Value for project


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [`@Value` for function](#value-for-function)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file)
  - [DO (check the project)](#do-check-the-project-1)
  - [DO (run The Application with Gradle)](#do-run-the-application-with-gradle)
- [`@Value` for class](#value-for-class)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file-1)
  - [DO (run The Application with Gradle)](#do-run-the-application-with-gradle-1)
- [`@Value` for project](#value-for-project)
  - [DO (create the spring property file)](#do-create-the-spring-property-file)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file-1)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file)
- [References](#references)
- [References for tools](#references-for-tools)



## Keywords
- Annotation `@Value`
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Kotlin REPL Ubuntu Gradle jabba JDK Java JVM



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Kotlin Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=203 && NEW_APP_ID=204 \
&& git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin \
&& cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (edit the spring property file)
```bash
touch ./src/main/resources/application.properties
```
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
spring.main.banner-mode=off
spring.main.log-startup-info=off
web.app.name=Hello @Value
logging.level.root=WARN
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## `@Value` for function

### DO (edit the kotlin file)
```bash
nano ./src/main/kotlin/de/iotoi/KotlinApplication.kt
```
```bash
# FILE (KotlinApplication.kt)
...
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Value

@SpringBootApplication
class KotlinApplication {
	@Bean
	fun init(@Value("\${web.app.name}") appName: String) = CommandLineRunner {
		println("$appName from init()!")
	}
}
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```

### DO (run The Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    Hello @Value from init()!
    <==========---> 83% EXECUTING [13s]
    > :bootRun
```



## `@Value` for class

### DO (edit the kotlin file)
```bash
nano ./src/main/kotlin/de/iotoi/KotlinApplication.kt
```
```bash
# FILE (KotlinApplication.kt)
...
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Value

@SpringBootApplication
class KotlinApplication {
	@Value("\${web.app.name}") val webAppName: String? = null

	@Bean
	fun init(@Value("\${web.app.name}") appName: String) = CommandLineRunner {
		println("$appName from init()!")
		println("$webAppName from init()!!")
	}
}
...
```

### DO (run The Application with Gradle)
```bash
./gradlew -q bootRun
    # >> Result
    Hello @Value from init()!
    Hello @Value from init()!!
    <==========---> 83% EXECUTING [8s]
    > :bootRun
```



## `@Value` for project

### DO (create the spring property file)
```bash
touch ./src/main/kotlin/de/iotoi/PropertyValues.kt
```

### DO (edit the spring property file)
```bash
nano ./src/main/kotlin/de/iotoi/PropertyValues.kt
```
```bash
# FILE (PropertyValues.kt)
package de.iotoi

object PropertyValues {
    const val WEB_APP_NAME = "\${web.app.name}"
}
```

### DO (edit the spring rest controller file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```bash
# FILE (HelloRestController.kt)
...
import org.springframework.beans.factory.annotation.Value

@RestController
class HelloRestController {
    @Value(PropertyValues.WEB_APP_NAME)
    private val webAppName: String? = null

    @GetMapping("/api")
    fun helloKotlin(): String {
        return "$webAppName!!!\n"
...
```

```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    Hello @Value from init()!
    Hello @Value from init()!!
    <==========---> 83% EXECUTING [39s]
    > :bootRun
```

```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello @Value!!!
```



## References
- https://stackoverflow.com/questions/54937518/visual-studio-code-spring-boot-reload-static-content/55370810
- https://mkyong.com/spring-boot/intellij-idea-spring-boot-template-reload-is-not-working/
- https://gist.github.com/IMRFeng/eed589de6a6362ef23bc189fb135fdea
- https://www.vojtechruzicka.com/spring-boot-devtools/
- https://stackoverflow.com/questions/33349456/how-to-make-auto-reload-with-spring-boot-on-idea-intellij
- https://stackoverflow.com/questions/54556072/hot-to-hotswap-code-in-intellij-in-a-spring-boot-project
- https://www.nexsoftsys.com/articles/hot-swapping-in-spring-boot-applications.html
- https://stackoverflow.com/questions/57408522/spring-boot-maven-not-printing-logs-on-console



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)