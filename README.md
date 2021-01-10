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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_209.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_209)


---

Unit 209: Hello @Entity!
<h1>Unit 209: Hello @Entity!</h1>

- How to Understand the Annotation @Entity!

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (check the project)](#do-check-the-project)
- [Develop the Kotlin Project](#develop-the-kotlin-project)
  - [DO (create and edit the spring model file)](#do-create-and-edit-the-spring-model-file)
  - [DO (create and edit the spring model repository file)](#do-create-and-edit-the-spring-model-repository-file)
  - [DO (create and edit the spring model repository file)](#do-create-and-edit-the-spring-model-repository-file-1)
- [Run The Web Application on the Project](#run-the-web-application-on-the-project)
  - [DO (run The Web Application with Gradle)](#do-run-the-web-application-with-gradle)
  - [DO (show all records)](#do-show-all-records)
  - [DO (insert a new record)](#do-insert-a-new-record)
  - [DO (update the record by id)](#do-update-the-record-by-id)
  - [DO (show a record by id)](#do-show-a-record-by-id)
  - [DO (show a record by title)](#do-show-a-record-by-title)
  - [DO (delete a record by id)](#do-delete-a-record-by-id)
  - [DO (show all records)](#do-show-all-records-1)
- [References](#references)
- [References for tools](#references-for-tools)



## Keywords
- Annotation @Entity `Spring Boot` `Web Application` h2 REST API
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
NEW_APP_ID=209 && \
mkdir ${NEW_APP_ID}_gradle_kotlin && cd ${NEW_APP_ID}_gradle_kotlin && \
curl https://start.spring.io/starter.zip -d language=kotlin \
  -d dependencies=web,devtools,jpa,h2 \
  -d packageName=de.iotoi \
  -d groupId=de.iotoi \
  -d artifactId=_gradle_kotlin \
  -d name=kotlin -d type=gradle-project -o basic_${NEW_APP_ID}.zip && \
unzip basic_${NEW_APP_ID}.zip
```

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
spring.main.banner-mode=off
spring.main.log-startup-info=off
web.app.name=Hello @Entity
logging.level.root=WARN
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
    2021-01-10 19:01:10.303  INFO 13534 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
    2021-01-10 19:01:10.304  INFO 13534 --- [extShutdownHook] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
    2021-01-10 19:01:10.305  INFO 13534 --- [extShutdownHook] .SchemaDropperImpl$DelayedDropActionImpl : HHH000477: Starting delayed evictData of schema as part of SessionFactory shut-down'
    2021-01-10 19:01:10.346  INFO 13534 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
    2021-01-10 19:01:10.363  INFO 13534 --- [extShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
```



## Develop the Kotlin Project


### DO (create and edit the spring model file)
```bash
mkdir -p src/main/kotlin/de/iotoi/model
```
```bash
touch ./src/main/kotlin/de/iotoi/model/Book.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/model/Book.kt
```
```bash
# FILE (Book.kt)
package de.iotoi.model

import javax.persistence.*

@Entity
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(nullable = false, unique = true)
    var title: String? = null

    @Column(nullable = false)
    var author: String? = null

    constructor() : super()
    constructor(title: String?, author: String?) : super() {
        this.title = title
        this.author = author
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (author == null) 0 else author.hashCode()
        result = prime * result + (id xor (id ushr 32)).toInt()
        result = prime * result + if (title == null) 0 else title.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Book
        if (author == null) {
            if (other.author != null) return false
        } else if (author != other.author) return false
        if (id != other.id) return false
        if (title == null) {
            if (other.title != null) return false
        } else if (title != other.title) return false
        return true
    }

    override fun toString(): String {
        return "Book [id=$id, title=$title, author=$author]"
    }
}
```

### DO (create and edit the spring model repository file)
```bash
touch ./src/main/kotlin/de/iotoi/model/BookRepository.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/model/BookRepository.kt
```
```bash
# FILE (BookRepository.kt)
package de.iotoi.model

import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book?, Long?> {
    fun findByTitle(title: String?): List<Book?>?
}
```

### DO (create and edit the spring model repository file)
```bash
touch ./src/main/kotlin/de/iotoi/BookRestController.kt
```
```bash
nano ./src/main/kotlin/de/iotoi/BookRestController.kt
```
```bash
# FILE (BookRestController.kt)
package de.iotoi

import de.iotoi.model.Book
import de.iotoi.model.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.function.Supplier

@RestController
@RequestMapping("/api/books")
class BookRestController {
    @Autowired
    private val bookRepository: BookRepository? = null

    @GetMapping
    fun findAll(): Iterable<*>? {
        return bookRepository!!.findAll()
    }

    @GetMapping("/title/{bookTitle}")
    fun findByTitle(@PathVariable bookTitle: String?): List<Book?>? {
        return bookRepository!!.findByTitle(bookTitle)
    }

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Long?): Book? {
        return bookRepository!!.findById(id!!)
            .orElseThrow(Supplier<RuntimeException> { BookNotFoundException() })
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody book: Book?): Book? {
        return bookRepository!!.save(book!!)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long?) {
        bookRepository!!.findById(id!!)
            .orElseThrow(Supplier<RuntimeException> { BookNotFoundException() })
        bookRepository.deleteById(id)
    }

    @PutMapping("/{id}")
    fun updateBook(@RequestBody requestBook: Book, @PathVariable id: Long?): Book? {
        val book: Book = bookRepository!!.findById(id!!)
            .orElseThrow(Supplier<RuntimeException> { BookNotFoundException() }) as Book
        book.title = requestBook.title
        book.author = requestBook.author
        return bookRepository.save(book)
    }
}
```



## Run The Web Application on the Project

### DO (run The Web Application with Gradle)
```bash
./gradlew -q bootRun
```
```bash
    # Result
    2021-01-10 21:10:43.674  WARN 5296 --- [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
    <==========---> 83% EXECUTING [2m 35s]
    > :bootRun   
```

### DO (show all records)
```bash
curl --no-progress-meter localhost:8080/api/books | json_pp
```
```bash
    # Result
    []
```

### DO (insert a new record)
```bash
curl --no-progress-meter \
    -H "Content-Type: application/json" \
    -X POST -d '{"title":"Java","author":"Joe"}' \
    localhost:8080/api/books | json_pp
```
```bash
    # Result
    {
        "author" : "Joe",
        "id" : 1,
        "title" : "Java"
    }
```

### DO (update the record by id)
```bash
curl --no-progress-meter \
    -H "Content-Type: application/json" \
    -X PUT -d '{"title":"Rust","author":"Leo"}' \
    localhost:8080/api/books/1 | json_pp
```
```bash
    # Result
    {
        "author" : "Leo",
        "id" : 1,
        "title" : "Rust"
    }
```

### DO (show a record by id)
```bash
curl --no-progress-meter localhost:8080/api/books/1 | json_pp
```
```bash
    # Result
    {
        "author" : "Leo",
        "id" : 1,
        "title" : "Rust"
    }
```

### DO (show a record by title)
```bash
curl --no-progress-meter localhost:8080/api/books/title/Rust | json_pp
```
```bash
    # Result
    {
        "author" : "Leo",
        "id" : 1,
        "title" : "Rust"
    }
```

### DO (delete a record by id)
```bash
curl --no-progress-meter -X DELETE localhost:8080/api/books/1
```
```bash
    # Result: nothing
```

### DO (show all records)
```bash
curl --no-progress-meter localhost:8080/api/books | json_pp
```
```bash
    # Result
    []
```



## References
- https://www.baeldung.com/kotlin/kotlin-jpa



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)