# Patient Portal
repository for software development project at TU Dresden (summer semester 2019)

## how to run this application using eclipse:


- download sts 4 plugin for eclipse from 
https://marketplace.eclipse.org/category/free-tagging/sts

(you can drag and drop the install button into the gui of eclipse)

- right klick on project, klick Run As --> Spring Boot App

- open browser: enter localhost:8080 into the address bar

## how to run this application using jar:


- build the application with maven (right klick on project --> Run As --> Maven build ..
(use [clean verify] as goal, without brackets)

- open your terminal

- move to the target folder of the project
(e.g. E:\Programmierung\git\SD-TUD_2019\target)

- run java -jar [filename].jar in your terminal 

- open browser: enter localhost:8080 into the address bar

## Tech-Stack:

### 1) Presentation Layer:
		- HTML
		- CSS
		- JavaScript
		- Thymeleaf
		
### 1<->2) Middleware: HTTP

### 2) Processing Layer:
		- Spring Boot 2

### 2<->3) Middleware: JPA

###	3) Persistence Layer:
		- H2 (for development)
		- maybe later: MySQL or PostgreSQL 

### Build Management: 	Maven
### Version control: 	github