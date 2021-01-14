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
[![CircleCI](https://circleci.com/gh/cnruby/gradle_kotlin/tree/basic_001.svg?style=svg)](https://app.circleci.com/pipelines/github/cnruby/gradle_kotlin?branch=basic_001)


---

Unit 001: Hello Database postgreSQL!
<h1>Unit 001: Hello Database postgreSQL!</h1>

- How to Install/Configure/Use the Database postgreSQL

---


<h1>Table of Contents</h1>

- [Keywords](#keywords)
- [Install PostgreSQL on Ubuntu 20.04](#install-postgresql-on-ubuntu-2004)
  - [Install PostgreSQL](#install-postgresql)
  - [check the status of the database with postgresql status command](#check-the-status-of-the-database-with-postgresql-status-command)
  - [search PostgreSQL command location](#search-postgresql-command-location)
  - [check PostgreSQL Version](#check-postgresql-version)
- [Configure PostgreSQL on Ubuntu 20.04](#configure-postgresql-on-ubuntu-2004)
  - [need to set a password for user name: postgres](#need-to-set-a-password-for-user-name-postgres)
  - [create a new database user: gudao](#create-a-new-database-user-gudao)
- [Use PostgreSQL on Ubuntu 20.04](#use-postgresql-on-ubuntu-2004)
  - [create a new database name: `testdb`, which is going to be owned by user name: `gudao`](#create-a-new-database-name-testdb-which-is-going-to-be-owned-by-user-name-gudao)
  - [edit the pg_hba.conf file, In order to be able to run a Spring Boot application with a local PostgreSQL installation](#edit-the-pg_hbaconf-file-in-order-to-be-able-to-run-a-spring-boot-application-with-a-local-postgresql-installation)
  - [restart PostgreSQL to enable the changes](#restart-postgresql-to-enable-the-changes)
  - [use the psql tool to connect to the database.](#use-the-psql-tool-to-connect-to-the-database)
  - [remove a database name: `testdb`](#remove-a-database-name-testdb)
- [References](#references)
- [References for tools](#references-for-tools)



## Keywords
- install PostgreSQL Ubuntu
 


## Install PostgreSQL on Ubuntu 20.04

### Install PostgreSQL
```bash
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
```
```bash
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
```
```bash
sudo apt-get update
```
```bash
sudo apt-get -y install postgresql postgresql-contrib
```

### check the status of the database with postgresql status command
```bash
service postgresql status
```
OR
```bash
/etc/init.d/postgresql status
```
```bash
    # >> Result
    ● postgresql.service - PostgreSQL RDBMS
        Loaded: loaded (/lib/systemd/system/postgresql.service; enabled; vendor preset: enabled)
        Active: active (exited) since Thu 2021-01-14 14:40:23 CET; 5h 33min ago
        Process: 53625 ExecStart=/bin/true (code=exited, status=0/SUCCESS)
    Main PID: 53625 (code=exited, status=0/SUCCESS)

    Jan 14 14:40:23 dms systemd[1]: Starting PostgreSQL RDBMS...
    Jan 14 14:40:23 dms systemd[1]: Finished PostgreSQL RDBMS.
```

### search PostgreSQL command location
-  install [Rust](https://www.rust-lang.org/learn/get-started) and tool [fd](https://github.com/sharkdp/fd)

```bash
fd -t x postgre / | grep "bin/postgres"
```
```bash
    # >> Result
    /usr/lib/postgresql/12/bin/postgres
```

### check PostgreSQL Version
```bash
/usr/lib/postgresql/12/bin/postgres -V
```
```bash
    # >> Result
    postgres (PostgreSQL) 12.5 (Ubuntu 12.5-0ubuntu0.20.04.1)
```



## Configure PostgreSQL on Ubuntu 20.04

### need to set a password for user name: postgres
```bash
sudo -u postgres psql postgres
```
```bash
    # >> Result
    psql (12.5 (Ubuntu 12.5-0ubuntu0.20.04.1))
    Type "help" for help.
    
    postgres=# \password postgres
    Enter new password: <your_password>
    Enter it again: <your_password>
    postgres=# \q
```

### create a new database user: gudao
```bash
sudo -u postgres createuser --interactive --password gudao
```
```bash
    # >> Result
    Shall the new role be a superuser? (y/n) n
    Shall the new role be allowed to create databases? (y/n) y
    Shall the new role be allowed to create more new roles? (y/n) n
    Password: <your_password>
```



## Use PostgreSQL on Ubuntu 20.04

### create a new database name: `testdb`, which is going to be owned by user name: `gudao`
```bash
sudo -u postgres createdb testdb -O gudao
```
```bash
    # >> Result: nothing
``` 

### edit the pg_hba.conf file, In order to be able to run a Spring Boot application with a local PostgreSQL installation
```bash
sudo nano /etc/postgresql/9.5/main/pg_hba.conf
```

```bash
    # FILE (pg_hba.conf)
    ...
    # "local" is for Unix domain socket connections only
    local   all             all                                     trust
    # IPv4 local connections:
    host    all             all             127.0.0.1/32            trust
    ...
    # DO (CTRL+O to save)
    # DO (CTRL+X to exit)
```

### restart PostgreSQL to enable the changes
```bash
service postgresql restart
```
```bash
    # >> Result: nothing
```

### use the psql tool to connect to the database.
```bash
psql -U gudao -d testdb -W
```
```bash
    # >> Result: nothing
    Password: <your_password>
        # >> Result: nothing
        psql (12.5 (Ubuntu 12.5-0ubuntu0.20.04.1))
        Type "help" for help.
        testdb=> \l
            Name    |  Owner   | Encoding |   Collate   |    Ctype    |   Access privileges   
            -----------+----------+----------+-------------+-------------+-----------------------
            postgres  | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
            template0 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
                    |          |          |             |             | postgres=CTc/postgres
            template1 | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
                    |          |          |             |             | postgres=CTc/postgres
            testdb    | gudao    | UTF8     | en_US.UTF-8 | en_US.UTF-8 | 
            (4 rows)
        testdb=> \q
``` 

### remove a database name: `testdb`
```bash
sudo -u postgres dropdb testdb
``` 
```bash
    # >> Result: nothing
```



## References
- https://www.postgresql.org/download/linux/ubuntu/
- https://www.digitalocean.com/community/tutorials/how-to-install-postgresql-on-ubuntu-20-04-quickstart-de
- https://phoenixnap.com/kb/check-postgresql-version
- https://stackoverflow.com/questions/13733719/which-version-of-postgresql-am-i-running



## References for tools
- [Add a copy to clipboard button in a GitHub](https://github.com/zenorocha/codecopy#install)