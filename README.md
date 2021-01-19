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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_222.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_222)


---

Unit 222: Hello JSONObject!
<h1>Unit 222: Hello JSONObject!</h1>

- How to Understand the Library JSONObject

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Add A Library JSONObject to the Project](#add-a-library-jsonobject-to-the-project)
  - [DO (edit the gradle build file)](#do-edit-the-gradle-build-file)
  - [DO (check the project)](#do-check-the-project-1)
- [Develop the Project for class `String`](#develop-the-project-for-class-string)
  - [DO (edit the spring service file)](#do-edit-the-spring-service-file)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access the web api `/api/str`)](#do-access-the-web-api-apistr)
  - [DO (stop the web application with gradle)](#do-stop-the-web-application-with-gradle)
- [Develop the Project for class `ResponseEntity`](#develop-the-project-for-class-responseentity)
  - [DO (edit the spring service file)](#do-edit-the-spring-service-file-1)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file-1)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle-1)
  - [DO (access the web api `/api/resp`)](#do-access-the-web-api-apiresp)
  - [DO (stop the web application with gradle)](#do-stop-the-web-application-with-gradle-1)
- [Develop the Project for class `Map`](#develop-the-project-for-class-map)
  - [DO (edit the spring service file)](#do-edit-the-spring-service-file-2)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file-2)
  - [DO (access the web api `/api/map`)](#do-access-the-web-api-apimap)
  - [DO (stop the web application with gradle)](#do-stop-the-web-application-with-gradle-2)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Liberary JSONObject json
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Kotlin REPL Ubuntu Gradle jabba JDK Java JVM `Spring Boot` 




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Kotlin Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=205 && NEW_APP_ID=222 && \
git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin && \
cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
web.app.name=Hello JSONObject
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Add A Library JSONObject to the Project

### DO (edit the gradle build file)
```bash
nano ./build.gradle.kts
```
```bash
# FILE (build.gradle.kts)
dependencies {
	implementation("org.json:json:20201115")
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Develop the Project for class `String`

### DO (edit the spring service file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloService.kt
```
```bash
# FILE (HelloService.kt)
...
import org.json.JSONObject
...
    fun getStringHello(): String {
        val jsonObj = JSONObject()
        jsonObj.put("String", "$webAppName")
        return jsonObj.toString()
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
    @GetMapping("/api/str")
    fun helloString(): String {
        return helloService.getStringHello()
    }
}
```

### DO (run the web application with gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web api `/api/str`)
```bash
curl --no-progress-meter http://localhost:8080/api/str | json_pp
```
```json5
    # >> Result
    {
        "String" : "Hello JSONObject"
    }
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## Develop the Project for class `ResponseEntity`

### DO (edit the spring service file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloService.kt
```
```bash
# FILE (HelloService.kt)
...
    fun getJSONObjectHello(): JSONObject {
        val jsonEntity = JSONObject()
        jsonEntity.put("ResponseEntity", "$webAppName")
        return jsonEntity
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
import org.json.JSONObject
import org.springframework.http.MediaType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
...
    @GetMapping(path= ["/api/resp"], produces= [MediaType.APPLICATION_JSON_VALUE])
    fun helloResponseEntity(): ResponseEntity<String> {
        val jsonResp = helloService.getResponseEntityHello()
        return ResponseEntity(jsonResp.toString(), HttpStatus.OK)
    }
}
```

### DO (run the web application with gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web api `/api/resp`)
```bash
curl --no-progress-meter http://localhost:8080/api/resp | json_pp
```
```json5
    # >> Result
    {
        "ResponseEntity" : "Hello JSONObject"
    }
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## Develop the Project for class `Map`

### DO (edit the spring service file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloService.kt
```
```bash
# FILE (HelloService.kt)
...
import java.util.HashMap
...
    fun getMapHello(): MutableMap<String, String> {
        val map: MutableMap<String, String> = HashMap()
        map["Map"] = "$webAppName"
        return map
    }
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
import java.util.HashMap
...
    @GetMapping("/api/map")
    fun helloMap(): ResponseEntity<String> {
        val jsonMap = JSONObject()

        val map: MutableMap<String, String> = helloService.getMapHello()
        map.entries.stream().forEach {
            (key, value) -> jsonMap.put( "$key", "$value" )
        }

        return ResponseEntity(jsonMap.toString(), HttpStatus.OK)
    }
}```

### DO (run the web application with gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [21s]
    > :bootRun
```

### DO (access the web api `/api/map`)
```bash
curl --no-progress-meter http://localhost:8080/api/map| json_pp
```
```json5
    # >> Result
    {
        "Map" : "Hello JSONObject"
    }
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## References
- https://github.com/Baeldung/kotlin-tutorials/tree/master/spring-boot-kotlin/src/main/kotlin/com/baeldung/springbootkotlin
- https://www.baeldung.com/spring-boot-kotlin
- https://www.journaldev.com/21435/spring-service-annotation#spring-service-example
- https://stackoverflow.com/questions/47204146/how-to-iterate-over-hashmap-in-kotlin




## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)

