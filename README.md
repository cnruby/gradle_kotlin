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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_217.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_217)


---

Unit 217: Hello JUnit 5!
<h1>Unit 217: Hello JUnit 5!</h1>

- How to Understand the unit testing framework `JUnit` `JUnit 5`
- JUnit is particularly suitable for automated unit tests of individual units (classes or methods)
- Every test method must be annotated by the @Test annotation
- Every test method has only two results: Either the test succeeds (then it is "green"(OK)) or it fails (then it is "red"(ERROR)).
- JUnit is linked as a JAR at compile-time


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
	- [DO (create a new project)](#do-create-a-new-project)
	- [DO (edit the gradle build file)](#do-edit-the-gradle-build-file)
	- [DO (check the gradle build file)](#do-check-the-gradle-build-file)
	- [DO (check the project)](#do-check-the-project)
- [Develop the Project for JUnit 5](#develop-the-project-for-junit-5)
	- [DO (create and edit the spring test file)](#do-create-and-edit-the-spring-test-file)
	- [DO (check the project)](#do-check-the-project-1)
- [Test The Web Application on the Project](#test-the-web-application-on-the-project)
- [References](#references)
- [References for tools](#references-for-tools)



## Keywords
- JUnit `Spring Boot` Annotation `@Test` Testing Test
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Kotlin REPL Ubuntu Gradle jabba JDK Java JVM `@Service`



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Kotlin Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=205 && NEW_APP_ID=217 && \
git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin && \
cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (edit the gradle build file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
spring.main.banner-mode=off
spring.main.log-startup-info=off
web.app.name=Hello @Service
logging.level.root=WARN
```

### DO (check the gradle build file)
```bash
nano ./build.gradle.kts
```
```bash
# FILE (build.gradle.kts)
...
dependencies {
	...
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

...

tasks.withType<Test> {
	useJUnitPlatform()
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Develop the Project for JUnit 5

### DO (create and edit the spring test file)
```bash
touch ./src/test/kotlin/de/iotoi/HelloServiceTests.kt
```
```bash
nano ./src/test/kotlin/de/iotoi/HelloServiceTests.kt
```
```bash
# FILE (HelloServiceTests.kt)
package de.iotoi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HelloServiceTests() {
	@Autowired
	var helloService: HelloService? = null

	@Value("\${web.app.name}")
	val webAppName: String? = null

	@DisplayName("Test Spring @Autowired Integration")
	@Test
	fun testAnnotationGetHello() {
		assertEquals("${webAppName}!", "Hello JUnit 5!")
		assertEquals("${webAppName}!\n", helloService?.getHello())
	}
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Test The Web Application on the Project

```bash
./gradlew -q test
```
```bash
    # >> Result: nothing
```




## References
- https://junit.org/junit5/docs/current/user-guide/
- https://www.baeldung.com/junit-5
- https://www.innoq.com/de/articles/2019/12/junit5-spring-boot-tests/
- https://developer.okta.com/blog/2019/03/28/test-java-spring-boot-junit5
- https://medium.com/@thankgodukachukwu/unit-and-integrated-testing-spring-boot-and-junit-5-99b9745b782a
- https://mkyong.com/spring-boot/spring-boot-junit-5-mockito/
- https://www.trion.de/news/2020/05/26/testcontainers-junit5.html
- https://en.wikipedia.org/wiki/JUnit
- https://de.wikipedia.org/wiki/JUnit


## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
