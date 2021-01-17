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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_218.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_218)


---

Unit 218: Hello REST Assured!
<h1>Unit 218: Hello REST Assured!</h1>

- How to Understand The REST Assured 
- REST Assured is a Java DSL
- REST Assured simplify testing of REST based services built on top of HTTP Builder


---


<h1>Table of Contents</h1>


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (check the project)](#do-check-the-project)
- [Develop the gradle build file](#develop-the-gradle-build-file)
  - [DO (add the package `rest-assured` to the gradle build file)](#do-add-the-package-rest-assured-to-the-gradle-build-file)
  - [DO (check the project to get the error)](#do-check-the-project-to-get-the-error)
  - [DO (edit a gradle build file for spring boot)](#do-edit-a-gradle-build-file-for-spring-boot)
  - [DO (check the project again to get many warnings)](#do-check-the-project-again-to-get-many-warnings)
  - [DO (edit a gradle build file for spring boot again)](#do-edit-a-gradle-build-file-for-spring-boot-again)
  - [DO (check the project noch again)](#do-check-the-project-noch-again)
- [DO (Upgrade the gradle version to 6.8)](#do-upgrade-the-gradle-version-to-68)
- [Develop REST Assured Testing for The Web App](#develop-rest-assured-testing-for-the-web-app)
  - [DO (add a new book controller testing file)](#do-add-a-new-book-controller-testing-file)
  - [DO (start the web app)](#do-start-the-web-app)
  - [DO (run the testing in the project with gradle)](#do-run-the-testing-in-the-project-with-gradle)
  - [DO (see the testing report)](#do-see-the-testing-report)
- [References](#references)
- [References for tools](#references-for-tools)




## Keywords
- `Rest Assured` `Web Application` REST API Testing
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Kotlin REPL Ubuntu Gradle jabba JDK Java JVM
- database h2 Console `Spring Boot` `Spring DataSource` JPA Hibernate Classpath h2




## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)




## Create A New Kotlin Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=216 && NEW_APP_ID=218 && \
git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin && \
cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (check the project)
```bash
./gradlew -q clean check
```
```bash
    # >> Result:nothing
```




## Develop the gradle build file

### DO (add the package `rest-assured` to the gradle build file)
```bash
nano ./build.gradle.kts
```
```sql
-- FILE (build.gradle.kts)
...
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.rest-assured:rest-assured")
}
```

### DO (check the project to get the error)
```bash
./gradlew -q clean check
```
```bash
    # >> Result
    Errors occurred while build effective model from /home/gudao/.gradle/caches/modules-2/files-2.1/com.sun.xml.bind/jaxb-osgi/2.2.10/c926a537af564ec047ec6308df1d0d2a03364a86/jaxb-osgi-2.2.10.pom:
    'dependencyManagement.dependencies.dependency.systemPath' for com.sun:tools:jar must specify an absolute path but is ${tools.jar} in com.sun.xml.bind:jaxb-osgi:2.2.10    
```

### DO (edit a gradle build file for spring boot)
```bash
nano ./build.gradle.kts
```
```sql
-- FILE (build.gradle.kts)
...
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.rest-assured:rest-assured"){
		exclude("com.sun.xml.bind", "jaxb-osgi")
	}
}
...
```

### DO (check the project again to get many warnings)

```bash
./gradlew -q check
```
```bash
    # >> Result
    WARNING: An illegal reflective access operation has occurred
    WARNING: Illegal reflective access by org.codehaus.groovy.reflection.CachedClass (file:/home/gudao/.gradle/caches/modules-2/files-2.1/org.codehaus.groovy/groovy/2.5.14/f0a005fb21e7bd9b7ebf04cd2ecda0fc8f3be59d/groovy-2.5.14.jar) to method java.lang.Object.finalize()
    WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.reflection.CachedClass
    WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
    WARNING: All illegal access operations will be denied in a future release
```

### DO (edit a gradle build file for spring boot again)
```bash
nano ./build.gradle.kts
```
```sql
-- FILE (build.gradle.kts)
...
	useJUnitPlatform()
	jvmArgs("--illegal-access=deny")
...
```

### DO (check the project noch again)
```bash
./gradlew -q clean check
```
```bash
    # >> Result: nothing
```




## DO (Upgrade the gradle version to 6.8)
```bash
./gradlew wrapper --gradle-version=6.8
```
```bash
    # >> Result
    Welcome to Gradle 6.8!
    
    Here are the highlights of this release:
     - Faster Kotlin DSL script compilation
     - Vendor selection for Java toolchains
     - Convenient execution of tasks in composite builds
     - Consistent dependency resolution
    
    For more details see https://docs.gradle.org/6.8/release-notes.html
```




## Develop REST Assured Testing for The Web App

### DO (add a new book controller testing file)
```bash
touch ./src/test/kotlin/de/iotoi/RestAssuredBookControllerTests.kt
```
```bash
nano ./src/test/kotlin/de/iotoi/RestAssuredBookControllerTests.kt
```
```kotlin
# FILE (RestAssuredBookControllerTests.kt)
package de.iotoi

import de.iotoi.model.Book
import io.restassured.RestAssured
import io.restassured.response.Response
import org.apache.commons.lang3.RandomStringUtils
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType


class RestAssuredBookControllerTests {
    private fun createRandomBook(): Book {
        val book = Book()
        book.title = RandomStringUtils.randomAlphabetic(10)
        book.author = RandomStringUtils.randomAlphabetic(15)
        return book
    }

    private fun createBookAsUri(book: Book): String {
        val response: Response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(book)
            .post(API_ROOT)
        return API_ROOT + "/" + response.jsonPath().get("id")
    }

    /*******************************************
     *
     * test finding books using variant methods
     *
     */
    @Test
    fun whenGetAllBooks_thenOK() {
        val response = RestAssured.get(API_ROOT)
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
    }

    @Test
    fun whenGetBooksByTitle_thenOK() {
        val book: Book = createRandomBook()
        createBookAsUri(book)
        val response = RestAssured.get(
            API_ROOT + "/title/" + book.title
        )
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
        assertThat(
            response.`as`<List<*>>(MutableList::class.java).isNotEmpty()
        ).isTrue
    }

    @Test
    fun whenGetCreatedBookById_thenOK() {
        val book: Book = createRandomBook()
        val location = createBookAsUri(book)
        val response = RestAssured.get(location)
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
        assertThat(book.title).isEqualTo(response.jsonPath()["title"])
    }

    @Test
    fun whenGetNotExistBookById_thenNotFound() {
        val response = RestAssured.get(API_ROOT + "/" + RandomStringUtils.randomNumeric(4))
        println("response.statusCode = " + response.statusCode)
        assertThat(HttpStatus.NOT_FOUND.value()).isEqualTo(response.statusCode)
    }

    /*************************************
     *
     * test creating a new book
     *
     */
    @Test
    fun whenCreateNewBook_thenCreated() {
        val book: Book = createRandomBook()
        val response: Response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(book)
            .post(API_ROOT)
        assertThat(HttpStatus.CREATED.value()).isEqualTo(response.statusCode)
    }

    /*************************************
     *
     * test updating an existing book
     *
     */
    @Test
    fun whenUpdateCreatedBook_thenUpdated() {
        val book: Book = createRandomBook()
        val location = createBookAsUri(book)
        book.id = location.split("api/books/").toTypedArray()[1].toLong()
        book.author = "newAuthor"
        var response: Response = RestAssured.given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(book)
            .put(location)
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
        response = RestAssured.get(location)
        assertThat(HttpStatus.OK.value()).isEqualTo(response.statusCode)
        assertThat("newAuthor").isEqualTo(response.jsonPath().get("author"))
    }

    companion object {
        private const val API_ROOT = "http://localhost:8080/api/books"
    }
}
```

### DO (start the web app)
```bash
./gradlew -q bootRun
```

### DO (run the testing in the project with gradle)
```bash
./gradlew -q clean test
```
OR
```bash
./gradlew -q clean test --tests de.iotoi.RestAssuredBookControllerTests
```
```bash
    # >> Result: nothing
```

### DO (see the testing report)
```bash
google-chrome ./build/reports/tests/test/index.html
```
![result_testing](doc/image/result_testing.png)




## References
- https://rest-assured.io/
- https://medium.com/@nieldw/exclude-a-transitive-dependency-with-gradles-kotlin-dsl-82fb41da67f
- https://github.com/kucharzyk/spring-kotlin-angular4/blob/master/build.gradle.kts
- https://docs.gradle.org/current/userguide/building_java_projects.html
- https://stackoverflow.com/questions/53790182/get-the-current-value-of-illegal-access-setting-in-java
- https://www.gitmemory.com/issue/spring-projects/spring-boot/22303/656792408
- https://backstage.forgerock.com/knowledge/kb/article/a15048811
- https://github.com/gradle/gradle/releases
 



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
