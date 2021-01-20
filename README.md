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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_225.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_225)


---

Unit 225: Hello @RequestMapping and @RequestParam!
<h1>Unit 225: Hello @RequestMapping and @RequestParam!</h1>

- How to Understand the Annotation @RequestMapping and @RequestParam!

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop the Project for url `/api/test_download`](#develop-the-project-for-url-apitest_download)
  - [DO (add a new download file for server folder)](#do-add-a-new-download-file-for-server-folder)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access the web api with url `/api/test_download`)](#do-access-the-web-api-with-url-apitest_download)
  - [DO (stop the web application with gradle)](#do-stop-the-web-application-with-gradle)
- [Develop the Project for url `/api/download`](#develop-the-project-for-url-apidownload)
  - [DO (edit the spring rest controller file)](#do-edit-the-spring-rest-controller-file-1)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle-1)
  - [DO (access the web api with url `/api/download`)](#do-access-the-web-api-with-url-apidownload)
  - [DO (view the downloaded file)](#do-view-the-downloaded-file)
  - [DO (stop the web application with gradle)](#do-stop-the-web-application-with-gradle-1)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- Annotation `@RequestMapping` `@RequestParam` `Spring Boot` GET download file `Spring Boot`
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
EXISTING_APP_ID=224 && NEW_APP_ID=225 && \
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
web.app.name=Hello @RequestMapping and @RequestParam
...
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Develop the Project for url `/api/test_download`

### DO (add a new download file for server folder)
```bash
mkdir ./server_download
```
```bash
wget  -O ./server_download/server_kotlin.png
```

### DO (edit the spring rest controller file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```kotlin
// FILE (HelloRestController.kt)
...
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import java.io.IOException
...
    @RequestMapping(path = ["/api/test_download"], method = [RequestMethod.GET])
    @Throws(IOException::class)
    fun testDownload(@RequestParam("imageX") imageName: String): String? {
        val strPath: String = "./server_download" + File.separator.toString() + imageName
        val file = File(strPath)
        val jsonObj = JSONObject()
        jsonObj.put("path", strPath
        jsonObj.put("fileSize", file.length())
        return jsonObj.toString()
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

### DO (access the web api with url `/api/test_download`)
```bash
curl --no-progress-meter http://localhost:8080/api/test_download?imageX=server_kotlin.png | json_pp
```
```json5
    // >> Result
    {
      "fileSize" : 21493,
      "path" : "./server_download/server_kotlin.png"
    }
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## Develop the Project for url `/api/download`

### DO (edit the spring rest controller file)
```bash
nano ./src/main/kotlin/de/iotoi/HelloRestController.kt
```
```kotlin
// FILE (HelloRestController.kt)
...
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
...
    @RequestMapping(path = ["/api/download"], method = [RequestMethod.GET])
    @Throws(IOException::class)
    fun parseDownloadFile(@RequestParam("image") imageName: String): ResponseEntity<Resource?>? {
        val file = File("./server_download" + File.separator.toString() + imageName )
        val header = HttpHeaders()
        // header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=server_kotlin.svg")
        header.add("Cache-Control", "no-cache, no-store, must-revalidate")
        header.add("Pragma", "no-cache")
        header.add("Expires", "0")
        val path: Path = Paths.get(file.absolutePath)
        val resource = ByteArrayResource(Files.readAllBytes(path))
        return ResponseEntity.ok()
            .headers(header)
            .contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/octet-stream"))
            .body(resource)
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

### DO (access the web api with url `/api/download`)
```bash
curl http://localhost:8080/api/download?imageX=server_kotlin.png --output local_kotlin.png
```bash
    # >> Result
      % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                    Dload  Upload   Total   Spent    Left  Speed
    100 21493  100 21493    0     0  97695      0 --:--:-- --:--:-- --:--:-- 97253    
```

### DO (view the downloaded file)
```bash
ls -al local_kotlin.png
```
```bash
    # >> Result:
    -rw-rw-r-- 1 gudao gudao 21493 Jan 20 04:48 local_kotlin.png
```

### DO (stop the web application with gradle)
```bash
# !!! Ctrl+C
```




## References
- https://stackoverflow.com/questions/35680932/download-a-file-from-spring-boot-rest-service
- https://www.baeldung.com/curl-rest
- http://www.mastertheboss.com/jboss-frameworks/resteasy/using-rest-services-to-manage-download-and-upload-of-files
- https://dzone.com/articles/java-springboot-rest-api-to-uploaddownload-file-on
- https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
- 


## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)

