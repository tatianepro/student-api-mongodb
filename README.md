# student-api-mongodb

Spring Boot REST API Student with CRUD operations, using MongoDB along with Docker Compose to create the database environment.

* api url:


    http://localhost:8080/api/v1/student

* build the jar file:


    mvn clean install

* run the 1st instance at port 8080:


    java -jar student-api-0.0.1-SNAPSHOT.jar

* run the 2nd instance in to a different port:


    java -jar student-api-0.0.1-SNAPSHOT.jar --server.port=8081

