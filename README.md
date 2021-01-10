<a href = "https://kotlinlang.org/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Kotlin-Programming%20Language%20with%20Gradle-black?style=flat&logo=kotlin" alt = "The Java Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![kotlin lang)](https://img.shields.io/github/v/release/JetBrains/kotlin?label=kotlin&logo=kotlin)](https://github.com/JetBrains/kotlin)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![Docker-(2019.03.13)](https://img.shields.io/badge/Docker-%2019.03.13-brightgreen)](https://www.docker.com/)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_207.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_207)


---

Unit 207: Hello @Component
<h1>Unit 207: Hello @Component!</h1>

- How to Understand the Annotation @Component
- How to Compare the Annotation @Component and @Service
- @Component is a generic stereotype for any Spring-managed component
- @Repository annotates classes at the persistence layer, which will act as a database repository
- @Service annotates classes at the service layer
- @Service and @Repository are special cases of @Component
- @Repository, @Service, @Configuration and @Controller are all meta-annotations of @Component,


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop the Project](#develop-the-project)
  - [DO (create and edit the spring file with annotation @Component)](#do-create-and-edit-the-spring-file-with-annotation-component)
  - [DO (edit the spring service file)](#do-edit-the-spring-service-file)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file)
  - [DO (edit the spring application file)](#do-edit-the-spring-application-file)
  - [DO (check the project)](#do-check-the-project-1)
- [Run The Web Application on the Project](#run-the-web-application-on-the-project)
  - [DO (run The Web Application with Gradle)](#do-run-the-web-application-with-gradle)
  - [DO (open a new terminal to browse the website)](#do-open-a-new-terminal-to-browse-the-website)
- [Run The Web Application on Docker](#run-the-web-application-on-docker)
  - [DO (build an OCI image of the application)](#do-build-an-oci-image-of-the-application)
  - [DO (run the application on Docker)](#do-run-the-application-on-docker)
  - [DO (browse the web application on Docker)](#do-browse-the-web-application-on-docker)
- [References](#references)
- [References for tools](#references-for-tools)



## Keywords
- `Spring Boot` Annotation `@Component`
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
EXISTING_APP_ID=205 && NEW_APP_ID=207 && \
git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin && \
cd ${NEW_APP_ID}_gradle_kotlin && \
git checkout -b basic_${NEW_APP_ID}
```

### DO (edit the spring property file)
```
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
web.app.name=Hello @Component
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Develop the Project

### DO (create and edit the spring file with annotation @Component)
```bash
touch ./src/main/kotlin/de/iotoi/HelloComponent.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/HelloComponent.kt
```
```bash
# FILE (HelloComponent.kt)
package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component()
class HelloComponent {
    @Value("\${web.app.name}") val webAppName: String? = null

    fun getHello(): String {
        return "$webAppName!\n"
    }
}
```

### DO (edit the spring service file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloService.kt
```
```bash
# FILE (HelloService.kt)
...
@Service()
class HelloService {
    fun getHello(): String {
        return "Hello @Service!\n"
    }
}
```

### DO (edit the spring rest controller file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```bash
# FILE (HelloRestController.kt)
...
class HelloRestController(val helloService: HelloService, val helloComponent: HelloComponent) {
    @GetMapping("/api/service")
    fun helloService(): String {
        return helloService.getHello()
    }

    @GetMapping("/api/component")
    fun helloComponent(): String {
        return helloComponent.getHello()
    }
}
```

### DO (edit the spring application file)
```bash
nano ./src/main/kotlin/de/iotoi/KotlinApplication.kt
```
```bash
# FILE (KotlinApplication.kt)
...
fun main(args: Array<String>) {
	var applicationContext = runApplication<KotlinApplication>(*args)

	var helloComponent = applicationContext.getBean("helloComponent") as HelloComponent
	println(helloComponent.getHello())

	var helloService = applicationContext.getBean("helloService") as HelloService
	println(helloService.getHello())
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```


## Run The Web Application on the Project

### DO (run The Web Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    Hello @Component!

    Hello @Service!

    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (open a new terminal to browse the website)
```bash
curl http://localhost:8080/api/service
```
```bash
    # >> Result
    Hello @Service!
```
```bash
curl http://localhost:8080/api/component
```
```bash
    # >> Result
    Hello @Component!
```



## Run The Web Application on Docker

### DO (build an OCI image of the application)
```bash
./gradlew -q bootBuildImage --imageName=gradle_kotlin/basic_207
```
```bash
    # >> Result
    > Task :bootBuildImage
    Building image 'docker.io/gradle_kotlin/basic_207:latest'

     > Pulling builder image 'docker.io/paketobuildpacks/builder:base' ..................................................
     ...
     ...
        [creator]           docker.io/gradle_kotlin/basic_207:latest

    Successfully built image 'docker.io/gradle_kotlin/basic_207:latest'

    BUILD SUCCESSFUL in 3m 3s
    5 actionable tasks: 3 executed, 2 up-to-date     
```

### DO (run the application on Docker)
```bash
docker run -p 80:8080 gradle_kotlin/basic_207
```
```bash
    # >> Result
    Setting Active Processor Count to 4
    Calculating JVM memory based on 1017684K available memory
    Calculated JVM Memory Configuration: -XX:MaxDirectMemorySize=10M -Xmx418084K -XX:MaxMetaspaceSize=87599K -XX:ReservedCodeCacheSize=240M -Xss1M (Total Memory: 1017684K, Thread Count: 250, Loaded Class Count: 13052, Headroom: 0%)
    Adding 138 container CA certificates to JVM truststore
    Spring Cloud Bindings Enabled
    Picked up JAVA_TOOL_OPTIONS: -Djava.security.properties=/layers/paketo-buildpacks_bellsoft-liberica/java-security-properties/java-security.properties -agentpath:/layers/paketo-buildpacks_bellsoft-liberica/jvmkill/jvmkill-1.16.0-RELEASE.so=printHeapHistogram=1 -XX:ActiveProcessorCount=4 -XX:MaxDirectMemorySize=10M -Xmx418084K -XX:MaxMetaspaceSize=87599K -XX:ReservedCodeCacheSize=240M -Xss1M -Dorg.springframework.cloud.bindings.boot.enable=true
```

### DO (browse the web application on Docker)
```bash
curl http://localhost:80/api/service
```
```bash
    # >> Result
    Hello @Service!
```
```bash
curl http://localhost:80/api/component
```
```bash
    # >> Result
    Hello @Component!
```



## References
- https://kotlinlang.org/docs/reference/interfaces.html
- https://www.baeldung.com/kotlin/kotlin-interfaces
- https://www.baeldung.com/spring-component-repository-service
- https://www.javaguides.net/2018/11/spring-component-annotation-example.html
- https://www.baeldung.com/spring-bean-annotations



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
