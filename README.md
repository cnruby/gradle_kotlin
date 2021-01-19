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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_224.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_224)


---

Unit 224: Hello @PostMapping and @RequestPart!
<h1>Unit 224: Hello @PostMapping and @RequestPart!</h1>

- How to Understand the Annotation @PostMapping and @RequestPart!

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop the Project](#develop-the-project)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file)
  - [DO (add a new upload file)](#do-add-a-new-upload-file)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access the web api with url `/api/str` or `/`)](#do-access-the-web-api-with-url-apistr-or-)
  - [DO (stop the web application with gradle)](#do-stop-the-web-application-with-gradle)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Annotation `@PosMapping` `@RequestBody` `Spring Boot` POST
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
EXISTING_APP_ID=223 && NEW_APP_ID=224 && \
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
web.app.name=Hello @PostMapping and @RequestPart
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

### DO (edit the spring rest controller file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```bash
# FILE (HelloRestController.kt)
...
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.RequestPart
import java.nio.charset.StandardCharsets
...
    @PostMapping(
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        path = ["/api/upload"]
    )
    fun parseUploadFile(
        @RequestPart(value = "uploadX", required = true) multipartFile: MultipartFile?
    ): String? {
        val jsonObj = JSONObject()
        jsonObj.put("fileName", multipartFile?.originalFilename)
        jsonObj.put("fileContent", String(multipartFile!!.bytes, StandardCharsets.UTF_8))
        jsonObj.put("fileSize", multipartFile.size.toString())
        return jsonObj.toString()
    }
}
```

### DO (add a new upload file)
```bash
mkdir ./upload
```
```bash
touch ./upload/hello.txt
```
```bash
nano ./upload/hello.txt
```
```bash
# FILE (hello.txt)
Hello @PostMapping and @RequestPart!
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

### DO (access the web api with url `/api/str` or `/`)
```bash
curl --no-progress-meter -H "Content-Type: multipart/form-data" -H "accept: application/json" -X POST -F "uploadX=@./upload/hello.txt;type=text/plain" http://localhost:8080/api/upload | json_pp
```
```json5
    // >> Result
    {
      "fileContent" : "Hello @PostMapping and @RequestPart!",
      "fileName" : "hello.txt",
      "fileSize" : "36"
    }
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## References
- https://www.codeflow.site/de/article/java-org-json
- https://www.baeldung.com/java-org-json
- https://mkyong.com/java/how-do-convert-byte-array-to-string-in-java/



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)

