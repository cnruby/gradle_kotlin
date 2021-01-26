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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_221.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_221)


---


Unit 221: Hello @Configuration and @Bean!
<h1>Unit 221: Hello @Configuration and @Bean!</h1>

- How to Understand An Annotation @Configuration and @PropertySouBeanrce
- How to Add A New Service


---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the application property file)](#do-edit-the-application-property-file)
  - [DO (edit the hello property file)](#do-edit-the-hello-property-file)
  - [DO (edit the hello property class file)](#do-edit-the-hello-property-class-file)
  - [DO (check the project)](#do-check-the-project)
- [Implement the Annotation `@Configuration` and `@Bean` in the Web App](#implement-the-annotation-configuration-and-bean-in-the-web-app)
  - [DO (add a new kotlin interface file)](#do-add-a-new-kotlin-interface-file)
  - [DO (add a new kotlin implementation file)](#do-add-a-new-kotlin-implementation-file)
  - [DO (add a new kotlin class configuration file)](#do-add-a-new-kotlin-class-configuration-file)
  - [DO (check the project)](#do-check-the-project-1)
- [Apply the Annotation `@Configuration` and `@Bean` in the Web App](#apply-the-annotation-configuration-and-bean-in-the-web-app)
  - [DO (edit the kotlin class rest controller file)](#do-edit-the-kotlin-class-rest-controller-file)
  - [DO (check the project)](#do-check-the-project-2)
- [View The Result for the web app](#view-the-result-for-the-web-app)
  - [DO (run The Application with Gradle)](#do-run-the-application-with-gradle)
  - [DO (access the web rest api with url `/api`)](#do-access-the-web-rest-api-with-url-api)
  - [DO (access the web rest api with url `/`)](#do-access-the-web-rest-api-with-url-)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Annotation `@Configuration` `@Bean` `Spring Service`
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Kotlin REPL Ubuntu Gradle jabba JDK Java JVM `@Value` `Property File`




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Kotlin Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=220 && NEW_APP_ID=221 \
&& git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin \
&& cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (edit the application property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (hello.properties)
...
web.app.name=Hello @Configuration and @Bean in the file application.properties
...
```

### DO (edit the hello property file)
```bash
nano ./src/main/resources/hello.properties
```
```bash
# FILE (hello.properties)
...
web.app.name = Hello @Configuration and @Bean in the file hello.properties
...
```

### DO (edit the hello property class file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloPropertyValues.kt
```
```bash
# FILE (HelloPropertyValues.kt)
...
    const val WEB_APP_NAME = "\${web.app.name}"
}
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Implement the Annotation `@Configuration` and `@Bean` in the Web App

### DO (add a new kotlin interface file)
```bash
mkdir -p ./src/main/kotlin/de/iotoi/impl
```
```bash
touch ./src/main/kotlin/de/iotoi/impl/HelloServiceable.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/impl/HelloServiceable.kt
```
```kotlin
# FILE (HelloServiceable.kt)
package de.iotoi.impl

interface HelloServiceable {
    val hello: String?
}
```

### DO (add a new kotlin implementation file)
```bash
touch ./src/main/kotlin/de/iotoi/impl/HelloService.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/impl/HelloService.kt
```
```kotlin
# FILE (HelloService.kt)
package de.iotoi.impl

import de.iotoi.HelloPropertyValues
import de.iotoi.PropertyValues
import org.springframework.beans.factory.annotation.Value

class HelloService : HelloServiceable {
    @Value(HelloPropertyValues.WEB_APP_NAME)
    private val webAppName: String? = null

    override val hello: String
        get() = "$webAppName!\n"
}
```

### DO (add a new kotlin class configuration file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloConfiguration.kt
```
```kotlin
# FILE (HelloConfiguration.kt)
import de.iotoi.impl.HelloService
import org.springframework.context.annotation.Bean
...
    @Bean()
    fun getHelloServiceObject(): HelloService? {
        return HelloService()
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




## Apply the Annotation `@Configuration` and `@Bean` in the Web App

### DO (edit the kotlin class rest controller file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```kotlin
# FILE (HelloRestController.kt)
import de.iotoi.impl.HelloServiceable
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
...
    @GetMapping("/")
    fun helloServiceKotlin(): String? {
        val context: ApplicationContext = AnnotationConfigApplicationContext(HelloConfiguration::class.java)
        val objHelloService = context.getBean(HelloServiceable::class.java)
        return objHelloService.hello
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




## View The Result for the web app

### DO (run The Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    Hello @Configuration and @Bean in the file application.properties from init()!
    Hello @Configuration and @Bean in the file application.properties from init()!!
    <==========---> 83% EXECUTING [13s]
    > :bootRun
```

### DO (access the web rest api with url `/api`)
```bash
curl http://localhost:8080/api
```
```bash
    # >> Result
    Hello @Configuration and @Bean in the file application.properties!
```

### DO (access the web rest api with url `/`)
```bash
curl http://localhost:8080/
```
```bash
    # >> Result
    Hello @Configuration and @Bean in the file hello.properties!
```




## References
- https://agilecoach2016.wordpress.com/2017/12/31/kotlin-spring-5-dependency-injection-part-3-qualifer/
- https://zetcode.com/springboot/applicationcontext/
- https://www.baeldung.com/spring-application-context
- https://blog.frankel.ch/flavors-spring-application-context-configuration/
- 



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)