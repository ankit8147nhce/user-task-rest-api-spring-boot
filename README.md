# User & Task Management REST API

## Description
This project is a Spring Boot REST API developed as part of an intern-level backend assignment.  
It provides APIs to manage users and tasks using standard CRUD operations.

The project follows a layered architecture using Controller, Service, DTO, and Entity patterns.

---

## Features
- Create, update, delete users
- Create, update, delete tasks
- Fetch all users and tasks
- Fetch user or task by ID
- RESTful API design
- Proper HTTP status codes using ResponseEntity

---

## Technologies Used
- Java 17
- Spring Boot
- Spring Web (REST API)
- Lombok
- Maven
- Apache Tomcat
- IntelliJ IDEA

---

## Project Structure
- Controller layer for handling HTTP requests
- Service layer for business logic
- DTOs for request and response handling
- Entity classes for domain models

---

## API Endpoints

### User APIs
- `POST /api/user`
- `GET /api/user`
- `GET /api/user/{id}`
- `PUT /api/user`
- `DELETE /api/user/{id}`

### Task APIs
- `POST /api/task`
- `GET /api/task`
- `GET /api/task/{id}`
- `PUT /api/task`
- `DELETE /api/task/{id}`

---

## How to Run the Project
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Make sure Java 17 is configured
4. Run the Spring Boot application
5. Test APIs using Postman or browser

---

## Author
Ankit Kumar
