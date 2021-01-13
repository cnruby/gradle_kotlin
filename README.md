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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_211.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_211)


---

Unit 211: Hello Seed Data!
<h1>Unit 211: Hello Seed Data!</h1>

- How to Understand Database h2 with JPA/Hibernate/DataSource
- How to Understand Seed Data Import as Developmet Phase

---


<h1>Table of Contents</h1>


- [Keywords](#keywords)
- [Prerequisites](#prerequisites)
- [Create A New Kotlin Web App](#create-a-new-kotlin-web-app)
  - [DO (create a new project)](#do-create-a-new-project)
  - [DO (check the project)](#do-check-the-project)
- [Use Hibernate as Seed Data Import](#use-hibernate-as-seed-data-import)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file)
  - [DO (add a seed data file)](#do-add-a-seed-data-file)
  - [DO (check the project)](#do-check-the-project-1)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle)
  - [DO (access the web application api)](#do-access-the-web-application-api)
  - [DO (delete h2 database)](#do-delete-h2-database)
- [Use DataSource as Seed Data Import](#use-datasource-as-seed-data-import)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file-1)
  - [DO (add a seed data file)](#do-add-a-seed-data-file-1)
  - [DO (check the project)](#do-check-the-project-2)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle-1)
  - [DO (access the web application api)](#do-access-the-web-application-api-1)
  - [DO (delete h2 database)](#do-delete-h2-database-1)
- [Use DataSource and Hibernate as Seed Data Import](#use-datasource-and-hibernate-as-seed-data-import)
  - [DO (edit the spring property file)](#do-edit-the-spring-property-file-2)
  - [DO (check the project)](#do-check-the-project-3)
  - [DO (run the web application with gradle)](#do-run-the-web-application-with-gradle-2)
  - [DO (access the web application api)](#do-access-the-web-application-api-2)
  - [DO (delete h2 database)](#do-delete-h2-database-2)
- [References](#references)
- [References for tools](#references-for-tools)



## Keywords
- `Spring Boot` `Web Application` REST API h2 JPA Hibernate DataSource
- `Java JDK` `Command Line Kotlin Compiler` `IntelliJ CE` CircleCI CI
- tutorial example Kotlin REPL Ubuntu Gradle jabba JDK Java JVM
- database h2 Console 



## Prerequisites
- [install JDK on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_101/README.md)
- [install Gradle on Ubuntu 20.04](https://github.com/cnruby/gradle_java/blob/basic_102/README.md)
- [IntelliJ IDEA Community](https://www.jetbrains.com/de-de/idea/download/#section=linux)
- [install Docker on Ubuntu](https://docs.docker.com/engine/install/ubuntu/) OR [Using Docker](https://github.com/cnruby/gradle_java/tree/basic_002)
- [CircleCI Account](https://circleci.com/vcs-authorize/)



## Create A New Kotlin Web App

### DO (create a new project)
```bash
EXISTING_APP_ID=210 && NEW_APP_ID=211 && \
git clone -b basic_${EXISTING_APP_ID} https://github.com/cnruby/gradle_kotlin.git ${NEW_APP_ID}_gradle_kotlin && \
cd ${NEW_APP_ID}_gradle_kotlin
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```



## Use Hibernate as Seed Data Import

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
# JPA (JpaBaseConfiguration)
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
spring.jpa.open-in-view = true

# JPA (HibernateJpaAutoConfiguration)
spring.jpa.hibernate.ddl-auto = create-drop
spring.jpa.properties.hibernate.hbm2ddl.import_files = ./seed/data_211a.sql
```

### DO (add a seed data file)
```bash
mkdir ./src/main/resources/seed
```
```bash
touch ./src/main/resources/seed/data_211a.sql
```
```bash
nano ./src/main/resources/seed/data_211a.sql
```
```bash
# FILE (data_211a.sql)
INSERT INTO book(id, title, author) VALUES (1, 'Kotlin 211A', 'Jeo');
INSERT INTO book(id, title, author) VALUES (2, 'Rust 211A', 'Leo');
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```

### DO (run the web application with gradle)
- All records will be deleted after every spring boot start.

```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # Result
    [
       {
          "author" : "Jeo",
          "id" : 1,
          "title" : "Kotlin 211A"
       },
       {
          "author" : "Leo",
          "id" : 2,
          "title" : "Rust 211A"
       }
    ]
```

### DO (delete h2 database)
```bash
rm database/development.*
```



## Use DataSource as Seed Data Import

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
spring.datasource.initialization-mode=always
spring.datasource.data=classpath*:seed/data_211b.sql

# JPA (JpaBaseConfiguration)
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
spring.jpa.open-in-view = true

# JPA (HibernateJpaAutoConfiguration)
spring.jpa.hibernate.ddl-auto = create-drop
#spring.jpa.properties.hibernate.hbm2ddl.import_files = ./seed/data_211a.sql
```

### DO (add a seed data file)
```bash
touch ./src/main/resources/seed/data_211b.sql
```
```bash
nano ./src/main/resources/seed/data_211b.sql
```
```bash
# FILE (data_211b.sql)
INSERT INTO book(id, title, author) VALUES (3, 'Java 211B', 'Jeo');
INSERT INTO book(id, title, author) VALUES (4, 'Ruby 211B', 'Leo');
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```

### DO (run the web application with gradle)
- All records will be deleted after every spring boot start.

```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # Result
    [
       {
          "author" : "Jeo",
          "id" : 3,
          "title" : "Kotlin 211B"
       },
       {
          "author" : "Leo",
          "id" : 4,
          "title" : "Rust 211B"
       }
    ]
```

### DO (delete h2 database)
```bash
rm database/development.*
```



## Use DataSource and Hibernate as Seed Data Import

### DO (edit the spring property file)
```bash
nano ./src/main/resources/application.properties
```
```bash
# FILE (application.properties)
...
spring.datasource.initialization-mode=always
spring.datasource.data=classpath*:seed/data_211b.sql

# JPA (JpaBaseConfiguration)
spring.jpa.database-platform = org.hibernate.dialect.H2Dialect
spring.jpa.open-in-view = true

# JPA (HibernateJpaAutoConfiguration)
spring.jpa.hibernate.ddl-auto = create-drop
spring.jpa.properties.hibernate.hbm2ddl.import_files = ./seed/data_211a.sql
```

### DO (check the project)
```bash
./gradlew -q check
```
```bash
    # >> Result: nothing
```

### DO (run the web application with gradle)
- All records will be deleted after every spring boot start.

```bash
./gradlew -q bootRun
```
```bash
    # Result
    <==========---> 83% EXECUTING [35s]
    > :bootRun   
```

### DO (access the web application api)
```bash
curl --no-progress-meter http://localhost:8080/api/books | json_pp
```
```bash
    # Result
    [
       {
          "author" : "Jeo",
          "id" : 1,
          "title" : "Kotlin 211A"
       },
       {
          "author" : "Leo",
          "id" : 2,
          "title" : "Rust 211A"
       },
       {
          "author" : "Jeo",
          "id" : 3,
          "title" : "Java 211B"
       },
       {
          "author" : "Leo",
          "id" : 4,
          "title" : "Ruby 211B"
       }
    ]
```

### DO (delete h2 database)
```bash
rm database/development.*
```



## References
- https://www.baeldung.com/kotlin/kotlin-jpa
- https://gist.github.com/memory-lovers/4132241df38456642ad888634caee5c6
- https://github.com/DeadLion/spring-boot-samples/blob/master/application.properties.md
- https://dzone.com/articles/run-the-rest-version-of-spring-petclinic-with-angu
- https://dimitr.im/loading-initial-data-with-spring
- https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/howto-database-initialization.html
- https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
- https://stackoverflow.com/questions/38040572/spring-boot-loading-initial-data
- https://docs.microsoft.com/de-de/azure/developer/java/spring-framework/configure-spring-data-jpa-with-azure-mysql
- https://www.xspdf.com/resolution/20463098.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html
- https://javabydeveloper.com/spring-boot-loading-initial-data/
- https://stackoverflow.com/questions/53464632/application-properties-to-application-yml-spring-boot
- https://github.com/cesarsicas/spring-blog
- https://github.com/spring-projects/spring-boot/issues/20920



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)
