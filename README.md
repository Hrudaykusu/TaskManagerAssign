# TaskManagerAssign

# Task Management API

A simple Spring Boot REST API to manage tasks.  
Supports CRUD operations with validation, exception handling, and in-memory H2 database.

---

##  Features
- Create, Read, Update, Delete tasks
- Validation for task fields (title, status, priority, dueDate, etc.)
- Exception handling (404 for not found, 400 for validation errors)
- H2 in-memory database with console access
- Unit tests included

---

## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- JUnit 5

---



API Endpoints

1. Create Task

POST /api/tasks
Request Body:

{
  "title": "Complete Spring Boot Assignment",
  "description": "Build a task management API",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2024-02-15"
}


Response: 201 Created

{
  "id": 1,
  "title": "Complete Spring Boot Assignment",
  "description": "Build a task management API",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2024-02-15"
}



2. Get All Tasks

GET /api/tasks
Response: 200 OK

[
  {
    "id": 1,
    "title": "Complete Spring Boot Assignment",
    "description": "Build a task management API",
    "status": "PENDING",
    "priority": "HIGH",
    "dueDate": "2024-02-15"
  }
]

3. Get Task by ID

GET /api/tasks/{id}
Example: /api/tasks/1
Response: 200 OK

{
  "id": 1,
  "title": "Complete Spring Boot Assignment",
  "description": "Build a task management API",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2024-02-15"
}


If not found → 404 Not Found


4. Update Task

PUT /api/tasks/{id}
Request Body:

{
  "title": "Update Spring Boot Assignment",
  "description": "Refactor code",
  "status": "IN_PROGRESS",
  "priority": "MEDIUM",
  "dueDate": "2024-02-20"
}


Response: 200 OK


5. Delete Task

DELETE /api/tasks/{id}
Response: 204 No Content



Test Cases Covered

.Create Task (valid & invalid request)

.Get Task by ID (existing & non-existing)

.Get All Tasks

.Update Task

.Delete Task



