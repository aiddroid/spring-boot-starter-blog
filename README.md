# Spring Boot Starter Blog

<!-- BADGES/ -->

[![Spring Boot](https://img.shields.io/badge/spring%20boot-%3E%3D2.0-green.svg)](https://spring.io/projects/spring-boot/)
[![Java](https://img.shields.io/badge/java-%3E%3D1.8-green.svg)](https://java.com)
[![Netbeans](https://img.shields.io/badge/netbeans-%3E%3D8-green.svg)](https://netbeans.org)
<!-- /BADGES -->

This is Spring Boot Starter Blog.

It was created and developing as a fast start for building an blog based on Yii2.

It covers typical use cases for a new project, and will help you to save your time doing the same work in every project.

## Before you start
Please, consider helping project via [contributions](https://github.com/aiddroid/spring-boot-starter-blog/issues) .

## TABLE OF CONTENTS
- [Quickstart](#quickstart)
- [Features](#features)
- [Account](#account)
- [Screenshots](#screenshots)
- [How to contribute?](#how-to-contribute)
- [Have any questions?](#have-any-questions)

## Quickstart
### Run war in console
1. Create MySQL database "spring-boot-starter-blog", and load SQL in file src/main/resources/spring-boot-starter-blog.sql.
2. Run
    ```bash
    java -jar target/starter-blog-0.0.1-SNAPSHOT.war --server.port=YOUR-PORT --spring.datasource.username=YOUR-USERNAME --spring.datasource.password=YOUR-PASSWORD
    ```
3. Visit [http://localhost:YOUR-PORT](http://localhost:YOUR-PORT)

### Run in Netbeans IDE
1. Import project to Netbeans IDE.
2. Create MySQL database "spring-boot-starter-blog", and load SQL in file src/main/resources/spring-boot-starter-blog.sql.
3. Update database config in src/main/resources/application.properties
4. Run project in Netbeans IDE.
5. Visit [http://localhost:8080](http://localhost:8080)

## FEATURES
- Beautiful blog theme
- Spring Boot MVC
- Acess MySQL via JPA and Mybatis
- Basic jstl syntax
- Anti CSRF
- REST API demo
- Request Filter demo
- User login
- Captcha and captcha verify(kaptcha)
- Articles management(MySQL CURD)
- Rich text editor(redactor)
- File upload
- Customed error page

### I18N
- NA

### Account
- admin/123456

## Screenshots
!["Homepage Screenshot"](https://github.com/aiddroid/spring-boot-starter-blog/raw/master/screenshots/screenshot-1.png "Homepage Screenshot")


## How to contribute?
You can contribute in any way you want. Any help appreciated, but most of all i need help with docs (^_^)

## Have any questions?
Mail to [aiddroid##gmail.com](mailto:aiddroid##gmail.com)

### NOTE
This starter blog was created mostly for developers NOT for end users.
This is a point where you can start your application, rather than creating it from scratch.
Good luck!

