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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_203.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_203)


---

Unit 203: Hello devtools!
<h1>Unit 203: Hello devtools!</h1>

- Hot to HotSwap code without IDE in a Spring-Boot project
- Hot to HotSwap code in Intellij in a Spring-Boot project

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (check the project)](#do-check-the-project)
- [Develop The Project](#develop-the-project)
  - [DO (create and edit the kotlin file)](#do-create-and-edit-the-kotlin-file)
  - [DO (check the project)](#do-check-the-project-1)
  - [DO (run The Application with Gradle)](#do-run-the-application-with-gradle)
  - [DO (open a new terminal to browse the website)](#do-open-a-new-terminal-to-browse-the-website)
- [HotCode without IDE](#hotcode-without-ide)
  - [DO (open a new terminal to assemble an executable jar archive)](#do-open-a-new-terminal-to-assemble-an-executable-jar-archive)
  - [DO (open a new terminal to run this project)](#do-open-a-new-terminal-to-run-this-project)
  - [DO (open a new terminal to browse the website)](#do-open-a-new-terminal-to-browse-the-website-1)
  - [DO (change the kotlin file)](#do-change-the-kotlin-file)
  - [DO (waiting until the command `./gradlew -q bootJar --continuous` comes)](#do-waiting-until-the-command-gradlew--q-bootjar---continuous-comes)
  - [DO (browse the website again)](#do-browse-the-website-again)
- [HotCode in IntelliJ](#hotcode-in-intellij)
  - [DO (change the code)](#do-change-the-code)
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
NEW_APP_ID=203 && \
mkdir ${NEW_APP_ID}_gradle_kotlin && cd ${NEW_APP_ID}_gradle_kotlin 
curl https://start.spring.io/starter.zip -d language=kotlin \
  -d dependencies=web,devtools \
  -d packageName=de.iotoi \
  -d artifactId=_gradle_kotlin \
  -d groupId=de.iotoi \
  -d name=kotlin -d type=gradle-project -o basic_${NEW_APP_ID}.zip && \
unzip basic_${NEW_APP_ID}.zip
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
        return "Hello devtools!\n"
    }
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result
    2021-01-07 20:31:05.568  INFO 10606 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
```

### DO (run The Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    2021-01-07 20:32:34.894  INFO 11790 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
    2021-01-07 20:32:34.899  INFO 11790 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
    2021-01-07 20:32:36.449  INFO 11790 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    2021-01-07 20:32:36.470  INFO 11790 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2021-01-07 20:32:36.471  INFO 11790 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
    2021-01-07 20:32:36.615  INFO 11790 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2021-01-07 20:32:36.615  INFO 11790 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1715 ms
    2021-01-07 20:32:36.966  INFO 11790 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
    2021-01-07 20:32:37.326  INFO 11790 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
    2021-01-07 20:32:37.379  INFO 11790 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    <==========---> 83% EXECUTING [36s]
    > :bootRun
```

### DO (open a new terminal to browse the website)
```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello devtools!
```



## HotCode without IDE

### DO (open a new terminal to assemble an executable jar archive)
```bash
./gradlew -q bootJar --continuous
```
```bash
    # >> Result
    Waiting for changes to input files of tasks... (ctrl-d to exit)
    <-------------> 0% WAITING
    > IDLE
```

### DO (open a new terminal to run this project)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    2021-01-07 10:09:27.194  INFO 17482 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
    2021-01-07 10:09:27.470  INFO 17482 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
    <==========---> 83% EXECUTING [32s]
    > :bootRun
```

### DO (open a new terminal to browse the website)
```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello devtools!
```

### DO (change the kotlin file)
```bash
nano src/main/kotlin/de/iotoi/HelloRestController.kt
```
```bash
    # FILE (HelloRestController.kt)
    ...
    return "Hello devtools!!!\n"
    ...
```

### DO (waiting until the command `./gradlew -q bootJar --continuous` comes)
```bash
    Waiting for changes to input files of tasks... (ctrl-d to exit)
    <-------------> 0% WAITING
    > IDLE
```

### DO (browse the website again)
```bash
curl http://localhost:8080/api
```
```bash
    # DO (waiting)
    # >> Result
    Hello devtools!!!
```



## HotCode in IntelliJ
```bash
# DO (Change the IntelliJ)
# !!! In Menu File >> Setting >> Build, Execution, Deployment >> Compiler >> [x] Build project automatically
# !!! Ctrl+Shift+A >> Enter "Registry" >> Click "Registry..." >> [x] complier.automake.allow.when.app.running
```

```bash
./gradlew -q bootRun
```

```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello devtools!!!
```

### DO (change the code)
```bash
nano ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```bash
    # FILE (HelloRestController.kt)
    ...
    return "Hello devtools!\n"
    ...
```
```bash
### DO (Click the Menu Item)
# !!! In Menu >> Build >> Build Project (CTRL + F9)
```

```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello devtools!
```



## References
- https://stackoverflow.com/questions/54937518/visual-studio-code-spring-boot-reload-static-content/55370810
- https://mkyong.com/spring-boot/intellij-idea-spring-boot-template-reload-is-not-working/
- https://gist.github.com/IMRFeng/eed589de6a6362ef23bc189fb135fdea
- https://www.vojtechruzicka.com/spring-boot-devtools/
- https://stackoverflow.com/questions/33349456/how-to-make-auto-reload-with-spring-boot-on-idea-intellij
- https://stackoverflow.com/questions/54556072/hot-to-hotswap-code-in-intellij-in-a-spring-boot-project
- https://www.nexsoftsys.com/articles/hot-swapping-in-spring-boot-applications.html
- 



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)