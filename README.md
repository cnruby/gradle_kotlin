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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_301.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_301)


---

Unit 301: Hello Console App!
<h1>Unit 301: Hello Console App!</h1>

- How to Develop Spring Console Kotlin Application with Gradle

---

<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Project](#create-a-new-kotlin-project)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring boot configuration file)](#do-edit-the-spring-boot-configuration-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop The Project](#develop-the-project)
  - [DO (edit the kotlin file)](#do-edit-the-kotlin-file)
  - [DO (check the project)](#do-check-the-project-1)
- [DO (run The Application with Gradle)](#do-run-the-application-with-gradle)
- [Do (Run The Application as Jar file)](#do-run-the-application-as-jar-file)
  - [DO (Assembles an executable jar archive)](#do-assembles-an-executable-jar-archive)
  - [DO (run this project with Java Command)](#do-run-this-project-with-java-command)
  - [DO (run this project with Kotlin Command)](#do-run-this-project-with-kotlin-command)
- [Run The Application on Docker](#run-the-application-on-docker)
  - [DO (create a docker build file "./Dockerfile")](#do-create-a-docker-build-file-dockerfile)
  - [DO (edit a docker build file "./Dockerfile")](#do-edit-a-docker-build-file-dockerfile)
  - [DO (Assembles an executable jar archive)](#do-assembles-an-executable-jar-archive-1)
  - [DO (create a docker image)](#do-create-a-docker-image)
  - [DO (run the container)](#do-run-the-container)
- [References](#references)


## Keywords
- Spring Console Kotlin Application Command Line
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Kotlin Project

### DO (create a new project)

```bash
NEW_APP_ID=301 && mkdir ${NEW_APP_ID}_gradle_kotlin && cd ${NEW_APP_ID}_gradle_kotlin && \
curl https://start.spring.io/starter.zip -d language=kotlin \
  -d packageName=de.iotoi \
  -d groupId=de.iotoi \
  -d artifactId=_gradle_kotlin \
  -d name=kotlin -d type=gradle-project -o basic_${NEW_APP_ID}.zip && \
unzip basic_${NEW_APP_ID}.zip
```

### DO (edit the spring boot configuration file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
spring.main.banner-mode=off
spring.main.log-startup-info=off
spring.main.web-environment=off
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Develop The Project

### DO (edit the kotlin file)
```bash
nano ./src/main/kotlin/de/iotoi/KotlinApplication.kt
```

```bash
    # FILE (KotlinApplication.kt)
    ...
    import org.springframework.boot.CommandLineRunner

    @SpringBootApplication
    class KotlinApplication : CommandLineRunner {
        override fun run(vararg args: String?) {
            for (arg in args) {
                println(arg)
            }
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

## DO (run The Application with Gradle)
```bash
./gradlew -q bootRun --args='apple banana grape'
```
```bash
    # >> Result
    apple
    banana
    grape
```

## Do (Run The Application as Jar file)

### DO (Assembles an executable jar archive)
```bash
./gradlew -q bootJar
```
```bash
    # >> Result: nothing
```

### DO (run this project with Java Command)
```bash
java -jar ./build/libs/_gradle_kotlin-0.0.1-SNAPSHOT.jar apple banana grape
```
```bash
    # >> Result
    apple
    banana
    grape
```
### DO (run this project with Kotlin Command)
```bash
kotlin ./build/libs/_gradle_kotlin-0.0.1-SNAPSHOT.jar apple banana grape
```
```bash
    # >> Result
    apple
    banana
    grape
```

## Run The Application on Docker

### DO (create a docker build file "./Dockerfile")
```bash
touch ./Dockerfile
```

### DO (edit a docker build file "./Dockerfile")
```bash
nano ./Dockerfile
```
```bash
# FILE (./Dockerfile)
FROM azul/zulu-openjdk-alpine:11.0.6-jre
RUN apk update && apk add bash
WORKDIR /app
COPY /build/libs/ /app/
CMD ["java", "-jar", "_gradle_kotlin-0.0.1-SNAPSHOT.jar", "apple banana grape"]
```

### DO (Assembles an executable jar archive)
```bash
./gradlew bootJar
```

### DO (create a docker image)
```bash
docker build --tag=301_gradle_kotlin .
```
### DO (run the container)
```bash
docker run 301_gradle_kotlin
```
```bash
    # >> Result                                                                                                                                                                                                                                                                             
    apple banana grape
```



## References
- https://qiita.com/shima23/items/b201e53ceb8eb246e124
- https://reasonable-code.com/command-line-runner/
- https://www.javaguides.net/2020/02/spring-boot-commandlinerunner-example.html
- http://www.jasondl.ee/posts/2020/writing-clis-with-spring-boot-and-jcommander.html
- https://www.baeldung.com/spring-boot-console-app
- http://zetcode.com/springboot/commandlinerunner/
- https://qiita.com/tag1216/items/898348a7fc3465148bc8#comments
- https://qiita.com/salkun/items/721125f0deec0a082504
- https://stackoverflow.com/questions/27604283/gradle-task-pass-arguments-to-java-application
- https://www.baeldung.com/gradle-command-line-arguments
- 