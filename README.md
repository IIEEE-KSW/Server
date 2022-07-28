# Server

# Table of contents

<!--ts-->

- [Introduction](#introduction)
- [Technologies](#technologies)
- [Setting](#setting)
- [Installation & Run](#installation--run)

<!--te-->

# Introduction
This is Application Server for `Happy Farmer`.

# Technologies
Project is created with
|Tech|Content|Version|
|---|---|---|
|SDK|Java|correto-17|
|Framework|Spring Boot|2.7.0|
|Build|gradle|7.4.1|

# Setting
Some of files which environment variables are declared are not included in git because of safety.  
You should set environment variables as follows:  

`server/src/main/resources/application-cors.yml` declare about CORS. 
```yml
cors:
  allowed-origins: {URL of Web Server}
  allowed-methods: {methods you want to allow}
  allowed-headers: {headers you want to allow}
  max-age: {max-age}
```

`server/src/main/resources/application-database.yml` declare about database.
```yml
spring:
  jpa:
    hibernate:
      ddl-auto: validate
    properties:
      format_sql : true
  datasource:
    url: {URL of the datasource}
    username: {username to access datasource}
    password: {password to access datasource}
    driver-class-name: com.mysql.cj.jdbc.Driver
```

# Installation & Run
To run the application, run the following command in a terminal window
```
./gradlew bootRun
```