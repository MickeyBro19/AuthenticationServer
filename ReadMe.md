# Authentication Server API

A secure REST API implementing JWT-based authentication and authorization using Spring Security.

## Features

* User Registration
* User Login
* BCrypt Password Encryption
* JWT Token Generation
* JWT Token Validation
* Stateless Authentication
* Protected Endpoints
* Role-Based Authorization
* Spring Security Integration
* Global Exception Handling
* Validation
* Swagger/OpenAPI

## Tech Stack

* Java 26
* Spring Boot
* Spring Security
* JWT (JJWT)
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok

## Roles

* USER
* ADMIN

## API Endpoints

### Authentication

POST /api/auth/register

POST /api/auth/login

### Protected

GET /api/users/profile

## Authentication Flow

1. Register a new user
2. Login with email and password
3. Receive JWT token
4. Include token in Authorization header

Authorization: Bearer <JWT_TOKEN>

## Security

* BCrypt Password Hashing
* JWT Authentication
* Stateless Session Management
* Protected REST Endpoints

## Running Locally

1. Clone the repository
2. Configure PostgreSQL
3. Update application.properties
4. Run:

mvn spring-boot:run

## Future Improvements

* Refresh Tokens
* Email Verification
* Forgot Password
* OAuth2 Login
* Docker Support
* Unit & Integration Tests
