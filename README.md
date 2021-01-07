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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_202.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=202)


---

Unit 202: Hello @RestController!
<h1>Unit 202: Hello @RestController!</h1>


- How to Create a Kotlin Web App By existing GitHub's Project
- How to Understand An Annotation @RestController By A Simple Example

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web Application](#create-a-new-kotlin-web-application)
	- [DO (create a new project)](#do-create-a-new-project)
	- [DO (check the project)](#do-check-the-project)
- [Develop The Project](#develop-the-project)
	- [DO (create and edit the kotlin file)](#do-create-and-edit-the-kotlin-file)
	- [DO (check the project)](#do-check-the-project-1)
- [Run The Application with Gradle](#run-the-application-with-gradle)
	- [DO (start webserver with web application)](#do-start-webserver-with-web-application)
	- [DO (browse the web application)](#do-browse-the-web-application)
- [Run The Application on Docker](#run-the-application-on-docker)
	- [DO (build an OCI image of the application)](#do-build-an-oci-image-of-the-application)
	- [DO (run the application on Docker)](#do-run-the-application-on-docker)
	- [DO (browse the web application on Docker)](#do-browse-the-web-application-on-docker)
- [References](#references)
- [References for tools](#references-for-tools)



## Keywords
- `@RestController` `Kotlin Web App` webapp web-app `Spring Boot` `Command Line`
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example REPL Ubuntu Gradle jabba JDK Java JVM



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Kotlin Web Application

### DO (create a new project)
```bash
EXISTING_APP_ID=201 && NEW_APP_ID=202 \
&& git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin \
&& cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result
	2021-01-07 08:35:37.013  INFO 7778 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
```



## Develop The Project

### DO (create and edit the kotlin file)
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
class HelloRestController {
    @GetMapping("/api")
    fun helloKotlin(): String {
        return "Hello @RestController!"
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



## Run The Application with Gradle

### DO (start webserver with web application)
```bash
./gradlew -q bootRun
```
```bash
	# DO (Ctrl+C, if stop web server)
    # >> Result
	2021-01-07 08:38:59.534  INFO 9899 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
	2021-01-07 08:38:59.562  INFO 9899 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
	2021-01-07 08:38:59.568  INFO 9899 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
	2021-01-07 08:38:59.791  INFO 9899 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	2021-01-07 08:38:59.792  INFO 9899 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2252 ms
	Hallo Welt!
	2021-01-07 08:39:00.302  INFO 9899 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
	2021-01-07 08:39:00.683  INFO 9899 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
	Hello World!
	<==========---> 83% EXECUTING [1m 17s]
	> :bootRun
```

### DO (browse the web application)
```bash
curl http://localhost:8080 | json_pp
```
```bash
	# >> Result
	  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
									 Dload  Upload   Total   Spent    Left  Speed
	100   102    0   102    0     0    207      0 --:--:-- --:--:-- --:--:--   207
	{
		"error" : "Not Found",
		"message" : "",
		"path" : "/",
		"status" : 404,
		"timestamp" : "2021-01-07T07:54:21.069+00:00"
	}
```
```bash
curl http://localhost:8080/api
```
```bash
	# >> Result
	Hello @RestController!
```



## Run The Application on Docker

### DO (build an OCI image of the application)
```bash
./gradlew bootBuildImage --imageName=gradle_kotlin/basic_202
```
```bash
	# >> Result
	> Task :bootBuildImage
	Building image 'docker.io/gradle_kotlin/basic_202:latest'

	 > Pulling builder image 'docker.io/paketobuildpacks/builder:base' ..................................................
	 ...
	 ...
		[creator]           docker.io/gradle_kotlin/basic_202:latest

	Successfully built image 'docker.io/gradle_kotlin/basic_202:latest'

	BUILD SUCCESSFUL in 3m 3s
	5 actionable tasks: 3 executed, 2 up-to-date	 
```

### DO (run the application on Docker)
```bash
docker run -p 80:8080 gradle_kotlin/basic_202
```
```bash
	# >> Result
	Setting Active Processor Count to 4
	Calculating JVM memory based on 1537064K available memory
	Calculated JVM Memory Configuration: -XX:MaxDirectMemorySize=10M -Xmx937464K -XX:MaxMetaspaceSize=87599K -XX:ReservedCodeCacheSize=240M -Xss1M (Total Memory: 1537064K, Thread Count: 250, Loaded Class Count: 13052, Headroom: 0%)
	Adding 138 container CA certificates to JVM truststore
	Spring Cloud Bindings Enabled
	Picked up JAVA_TOOL_OPTIONS: -Djava.security.properties=/layers/paketo-buildpacks_bellsoft-liberica/java-security-properties/java-security.properties -agentpath:/layers/paketo-buildpacks_bellsoft-liberica/jvmkill/jvmkill-1.16.0-RELEASE.so=printHeapHistogram=1 -XX:ActiveProcessorCount=4 -XX:MaxDirectMemorySize=10M -Xmx937464K -XX:MaxMetaspaceSize=87599K -XX:ReservedCodeCacheSize=240M -Xss1M -Dorg.springframework.cloud.bindings.boot.enable=true
	2021-01-07 07:59:56.033  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
	2021-01-07 07:59:56.063  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
	2021-01-07 07:59:56.064  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
	2021-01-07 07:59:56.207  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	2021-01-07 07:59:56.208  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 2430 ms
	2021-01-07 07:59:56.721  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
	2021-01-07 07:59:57.129  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
	Hello @RestController from @Bean!
```

### DO (browse the web application on Docker)
```bash
curl http://localhost:80 | json_pp
```
```bash
    # >> Result
	  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
									 Dload  Upload   Total   Spent    Left  Speed
	100   102    0   102    0     0    310      0 --:--:-- --:--:-- --:--:--   311
	{
		"error" : "Not Found",
		"message" : "",
		"path" : "/",
		"status" : 404,
		"timestamp" : "2021-01-07T07:57:01.070+00:00"
	}
```
```bash
curl http://localhost:80/api
```
```bash
	# >> Result
	Hello @RestController!
```



## References
- https://github.com/sdeleuze/spring-boot-kotlin-demo/blob/master/src/main/kotlin/hello/Application.kt
- http://zetcode.com/springboot/bean/#:~:text=Spring%20%40Bean%20annotation%20tells%20that,a%20bean%20within%20a%20BeanFactory%20.
- https://spring.io/blog/2021/01/04/ymnnalft-easy-docker-image-creation-with-the-spring-boot-maven-plugin-and-buildpacks
- https://medium.com/@ashoksl/build-docker-image-using-spring-boot-buildimage-gradle-ac5bc1f71303
- https://github.com/ashoksl/java_samples/tree/master/buildimagedemo
- https://reflectoring.io/spring-boot-docker/
- https://github.com/francescopeloi/spring-boot-build-docker-image-demo
- https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1
- https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/
- https://www.baeldung.com/spring-boot-kotlin


## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)