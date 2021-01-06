<a href = "https://kotlinlang.org/">
<img width = "90%" height = "auto" src = "https://img.shields.io/badge/Kotlin-Programming%20Language%20with%20Gradle-black?style=flat&logo=kotlin" alt = "The Java Programming Language">
</a>



[![Ubuntu-(20.04LTS)](https://img.shields.io/badge/Ubuntu-%2020.04LTS-brightgreen)](https://ubuntu.com/)
[![jabba)](https://img.shields.io/github/v/release/shyiko/jabba?label=jabba&logo=jabba)](https://github.com/shyiko/jabba)
[![Gradle-v6.7.1](https://img.shields.io/badge/Gradle-v6.7.1-black?style=flat&logo=gradle)](https://gradle.org/)
[![Java zulu-openjdk:11](https://img.shields.io/badge/Java-zulu%20openjdk:11-brightgreen?style=flat&logo=java)](https://www.azul.com/downloads/zulu-community/?package=jdk)
[![kotlin lang)](https://img.shields.io/github/v/release/JetBrains/kotlin?label=kotlin&logo=kotlin)](https://github.com/JetBrains/kotlin)
[![IntelliJ IDEA Community Edition](https://img.shields.io/badge/IntelliJ%20IDEA%20Community%20Edition-blue?style=flat)](https://www.jetbrains.com/idea/download/#section=linux)
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_301.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_301)


---

Unit 301: Hello Console App!
<h1>Unit 301: Hello Console App!</h1>

- How to Develop Spring Console Kotlin Application with Gradle

---

<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Create A New Project](#create-a-new-project)
- [Develop The Project](#develop-the-project)
- [Run The Project](#run-the-project)
  - [Run The Application with Gradle](#run-the-application-with-gradle)
  - [Run The Application as Jar file](#run-the-application-as-jar-file)
  - [Run The Application on Docker](#run-the-application-on-docker)
- [References](#references)


## Keywords
- Spring Console Kotlin Application Command Line
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Ubuntu Gradle jabba JDK Java JVM


## Create A New Project

```bash
# DO (create a new project)
NEW_APP_ID=301 && mkdir ${NEW_APP_ID}_gradle_kotlin && cd ${NEW_APP_ID}_gradle_kotlin && \
curl https://start.spring.io/starter.zip -d language=kotlin \
  -d packageName=de.iotoi \
  -d groupId=de.iotoi \
  -d artifactId=_gradle_kotlin \
  -d name=kotlin -d type=gradle-project -o basic_${NEW_APP_ID}.zip \
unzip basic_${NEW_APP_ID}.zip

# DO (edit the spring boot configuration file)
nano ./src/main/resources/application.properties
    # FILE (application.properties)
    spring.main.banner-mode=off
    spring.main.log-startup-info=off
    spring.main.web-environment=off

# DO (check)
./gradlew -q check
    # >> Result: nothing
```



## Develop The Project

```bash
nano ./src/main/kotlin/de/iotoi/KotlinApplication.kt
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

# DO (check)
./gradlew -q check
    # >> Result: nothing
```

## Run The Project

### Run The Application with Gradle
```bash
# DO (run this project as a Spring Boot application)
./gradlew -q bootRun --args='apple banana grape'
    # >> Result
    apple
    banana
    grape
```

### Run The Application as Jar file
```bash
# DO (Assembles an executable jar archive)
./gradlew bootJar

# DO (run this project with Java Command)
java -jar ./build/libs/_gradle_kotlin-0.0.1-SNAPSHOT.jar apple banana grape
    # >> Result
    apple
    banana
    grape

# DO (run this project with Kotlin Command)
kotlin ./build/libs/_gradle_kotlin-0.0.1-SNAPSHOT.jar apple banana grape
    # >> Result
    apple
    banana
    grape
```

### Run The Application on Docker
```bash
# DO (create a docker build file "./Dockerfile")
touch ./Dockerfile
# DO (edit a docker build file "./Dockerfile")
nano ./Dockerfile
    # FILE (./Dockerfile)
    FROM azul/zulu-openjdk-alpine:11.0.6-jre
    RUN apk update && apk add bash
    WORKDIR /app
    COPY /build/libs/ /app/
    CMD ["java", "-jar", "_gradle_kotlin-0.0.1-SNAPSHOT.jar", "apple banana grape"]

# DO (Assembles an executable jar archive)
./gradlew bootJar

# DO (create a docker image)
docker build --tag=301_gradle_kotlin .
# DO (run the container)
docker run 301_gradle_kotlin
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