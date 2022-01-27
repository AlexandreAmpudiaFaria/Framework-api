# Framework API

This project was created with a framework of motivation to reformulate the blog of the Digital company, improving the technologies used, and implementing the RESTful API concept

## Requirements

You need to install PostgreSql:

* `https://www.postgresql.org/download/`

You need to install Java SE Development Kit 17:

* `https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html`

To run the project, you can use an IDE of choice or (Eclipse):

* `https://www.eclipse.org/downloads/`

To make requests to the API, you can use Postman:

* `https://www.postman.com/downloads`

## Instructions

Before running the project, it will be necessary to create a database in PostgreSql, using the name of the database below:

* `framework-db`

Note: I did some research, and the recommendations using PostgreSql, is to create the database manually, since PostgreSql works differently from MySql.

After creating the database, it is possible to run the project from the IDE

Project initialized, now we can go to Postman, and send requests to the api. 
The first request must be the registration of your user, with the POST method to * `localhost:8080/user`. Use the Json example below as the request body:

* `{
    "username" : "alexandre",
    "pwd" : "12345"
}`

In this project we have 2 calls released without authentication:
* `POST: localhost:8080/user`.
* `POST: localhost:8080/auth`.

On call * `/auth`, it is necessary to use the same json example described above in the request body.

After authenticating this user, a token with JWT will be generated and you will receive it in the body of the response. This token must be included in the request header in Postman or in the authorization tab.

This file exported from Postman, contains all the application calls 
* `https://drive.google.com/file/d/1ewKeiV3Xnz-Xe1BxnYzMHr5937PsPkf6/view?usp=sharing`.

## 
