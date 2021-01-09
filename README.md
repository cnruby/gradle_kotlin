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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_000.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_000)


---

Unit 205: Hello @Service
<h1>Unit 205: Hello `@Service`!</h1>

- How to Understand the Annotation @Service

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop the Project](#develop-the-project)
  - [DO (create and edit the spring rest controller file)](#do-create-and-edit-the-spring-rest-controller-file)
  - [DO (create and edit the spring service file)](#do-create-and-edit-the-spring-service-file)
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
- install Kotlin REPL Ubuntu Gradle jabba JDK Java JVM
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Kotlin Web App

### DO (create a new project)
```bash
ID=205 && mkdir ${ID}_gradle_kotlin && cd ${ID}_gradle_kotlin
curl https://start.spring.io/starter.zip -d language=kotlin \
-d dependencies=web,devtools \
-d packageName=de.iotoi \
-d groupId=de.iotoi \
-d artifactId=_gradle_kotlin \
-d name=kotlin -d type=gradle-project -o basic_${ID}.zip && \
unzip basic_${ID}.zip
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
web.app.name=Hello @Service
logging.level.root=WARN
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Develop the Project

### DO (create and edit the spring rest controller file)
```bash
touch ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```bash
# FILE (HelloRestController.kt)
package de.iotoi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController(val helloService: HelloService) {
    @GetMapping("/api")
    fun helloKotlin(): String {
        return helloService.getHello()
    }
}
```

### DO (create and edit the spring service file)
```bash
touch ./src/main/kotlin/de/iotoi/HelloService.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/HelloService.kt
```
```bash
# FILE (HelloService.kt)
package de.iotoi

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service()
class HelloService {
    @Value("\${web.app.name}") val webAppName: String? = null

    fun getHello(): String {
        return "$webAppName!\n"
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


## Run The Web Application on the Project

### DO (run The Web Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (open a new terminal to browse the website)
```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello @Service!
```



## Run The Web Application on Docker

### DO (build an OCI image of the application)
```bash
./gradlew -q bootBuildImage --imageName=gradle_kotlin/basic_205
```
```bash
	# >> Result
	> Task :bootBuildImage
	Building image 'docker.io/gradle_kotlin/basic_205:latest'

	 > Pulling builder image 'docker.io/paketobuildpacks/builder:base' ..................................................
	 ...
	 ...
		[creator]           docker.io/gradle_kotlin/basic_205:latest

	Successfully built image 'docker.io/gradle_kotlin/basic_205:latest'

	BUILD SUCCESSFUL in 3m 3s
	5 actionable tasks: 3 executed, 2 up-to-date	 
```

### DO (run the application on Docker)
```bash
docker run -p 80:8080 gradle_kotlin/basic_205
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
curl http://localhost:80/api
```
```bash
	# >> Result
	Hello @Service!
```



## References
- https://github.com/Baeldung/kotlin-tutorials/tree/master/spring-boot-kotlin/src/main/kotlin/com/baeldung/springbootkotlin
- https://www.baeldung.com/spring-boot-kotlin
- https://www.journaldev.com/21435/spring-service-annotation#spring-service-example



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)

