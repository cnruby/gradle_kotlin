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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_216.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_216)


---

Unit 216: Hello @ControllerAdvice!
<h1>Unit 216: Hello @ControllerAdvice!</h1>

- How to Understand The Annotation @ControllerAdvice 
- @ControllerAdvice allows handling exceptions across the whole application
- @ControllerAdvice is a specialization of the @Component annotation
- @ControllerAdvice is a global handling component @ExceptionHandler  

---


<h1>Table of Contents</h1>


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit a spring model file)](#do-edit-a-spring-model-file)
  - [DO (edit a schema file for spring datasource)](#do-edit-a-schema-file-for-spring-datasource)
  - [DO (edit a data file for spring datasource)](#do-edit-a-data-file-for-spring-datasource)
  - [DO (check the project)](#do-check-the-project)
- [Check The Web App](#check-the-web-app)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access all book's records in the web application api)](#do-access-all-books-records-in-the-web-application-api)
  - [DO (access the first book's record in the web application api)](#do-access-the-first-books-record-in-the-web-application-api)
  - [DO (access the web app api if a record exists not)](#do-access-the-web-app-api-if-a-record-exists-not)
  - [DO (stop the web server)](#do-stop-the-web-server)
- [Add The ExceptionHandler @ControllerAdvice annotation](#add-the-exceptionhandler-controlleradvice-annotation)
  - [DO (make a new folder for exception handler)](#do-make-a-new-folder-for-exception-handler)
  - [DO (add a new book's exception file)](#do-add-a-new-books-exception-file)
  - [DO (add a new rest's exception handler file)](#do-add-a-new-rests-exception-handler-file)
  - [DO (edit the rest controller file)](#do-edit-the-rest-controller-file)
  - [DO (run the web application with gradle again)](#do-run-the-web-application-with-gradle-again)
  - [DO (access in the web app api if a record exists not)](#do-access-in-the-web-app-api-if-a-record-exists-not)
- [References](#references)
- [References for tools](#references-for-tools)



## Keywords
- @ControllerAdvice `Web Application` REST API h2 Exception Handler
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Kotlin REPL Ubuntu Gradle jabba JDK Java JVM
- database h2 Console `Spring Boot` `Spring DataSource` JPA Hibernate Classpath



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Kotlin Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=213 && NEW_APP_ID=216 && \
git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin && \
cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (edit a spring model file)
```bash
nano ./src/main/kotlin/de/iotoi/model/Book.kt
```
```Kotlin
// FILE (Book.kt)
...
@Entity
@Table(name="books")
class Book {
...
```

### DO (edit a schema file for spring datasource)
```bash
nano ./src/main/resources/schema.sql
```
```sql
-- FILE (schema.sql)
DROP TABLE IF EXISTS books;

CREATE TABLE books (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250),
  created TIMESTAMP(9) DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO books(title, author) VALUES ('Ruby', 'Leo');
```

### DO (edit a data file for spring datasource)
```bash
nano ./src/main/resources/data.sql
```
```sql
-- FILE (data.sql)
INSERT INTO books(title, author) VALUES ('Java', 'Thomas');
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```




## Check The Web App

### DO (run the web application with gradle)

```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access all book's records in the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # >> Result
    [
        {
            "author" : "Leo",
            "id" : 1,
            "title" : "Ruby"
        },
        {
            "author" : "Thomas",
            "id" : 2,
            "title" : "Java"
        }
    ]
```

### DO (access the first book's record in the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books/1 | json_pp
```
```bash
    # >> Result
    {
      "author" : "Leo",
      "id" : 1,
      "title" : "Ruby"
    }
```

### DO (access the web app api if a record exists not)
```bash
curl --no-progress-meter http://localhost:8080/api/books/3 | json_pp
```
```bash
    # >> Result
    {
        "error" : "Internal Server Error",
        "message" : "No message available",
        "path" : "/api/books/3",
        "status" : 500,
        "timestamp" : "2021-01-15T12:45:55.075+00:00",
        "trace" : "java.lang.RuntimeException\n\tat de.iotoi.BookRestController$findOne$1.get(BookRestController.kt:37)\n\tat
        .......
    }
```

### DO (stop the web server)
```bash
# DO (Ctrl+C)
```




## Add The ExceptionHandler @ControllerAdvice annotation

### DO (make a new folder for exception handler)
```bash
mkdir ./src/main/kotlin/de/iotoi/exception
```

### DO (add a new book's exception file)
```bash
touch ./src/main/kotlin/de/iotoi/exception/BookNotFoundException.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/exception/BookNotFoundException.kt
```
```Kotlin
# FILE (BookNotFoundException.kt)
package de.iotoi.exception

class BookNotFoundException : RuntimeException()
```

### DO (add a new rest's exception handler file)
```bash
touch ./src/main/kotlin/de/iotoi/exception/RestExceptionHandler.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/exception/RestExceptionHandler.kt
```
```Kotlin
# FILE (RestExceptionHandler.kt)
package de.iotoi.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(BookNotFoundException::class)
    protected fun handleNotFound(
        exception: Exception?, request: WebRequest?
    ): ResponseEntity<Any> {
        return handleExceptionInternal(
            exception!!,
            "{\"status\": \"${HttpStatus.NOT_FOUND}\", \"message\": \"Book not found\", \"class\": \"${RestExceptionHandler::class.java.name}\"}",
            HttpHeaders(),
            HttpStatus.NOT_FOUND,
            request!!
        )
    }
}
```

### DO (edit the rest controller file)
```bash
nano ./src/main/kotlin/de/iotoi/model/BookRestController.kt
```
```bash
# FILE (BookRestController.kt)
...kotlin
...
import de.iotoi.exception.BookNotFoundException
...
    @GetMapping("/{id}")
    open fun findOne(@PathVariable id: Long?): Book? {
        return bookRepository!!.findById(id!!)
            .orElseThrow { BookNotFoundException() }
    }
...
```

### DO (run the web application with gradle again)

```bash
./gradlew -q bootRun
```
```bash
    # >> Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access in the web app api if a record exists not)
```bash
 curl --no-progress-meter http://localhost:8080/api/books/3 | json_pp
```
```bash
    {
        "class" : "de.iotoi.exception.RestExceptionHandler",
        "message" : "Book not found",
        "status" : "404 NOT_FOUND"
    }
```




## References
- https://www.baeldung.com/spring-boot-start
- https://www.sourcecodeexamples.net/2019/10/putmapping-spring-boot-example.html
- https://www.concretepage.com/spring-boot/spring-boot-rest-example
- https://www.baeldung.com/curl-rest
- https://www.baeldung.com/rest-assured-tutorial
- https://rest-assured.io/
- https://www.baeldung.com/exception-handling-for-rest-with-spring
- https://zetcode.com/springboot/controlleradvice/


## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
