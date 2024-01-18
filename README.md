# Task-Management
This is a simple Task Management System designed to manage tasks with functionalities like adding tasks, updating task details, checking task status,due date and retrieving tasks by email.


## Task Service
The TaskService class provides various functionalities related to task management. Key methods include:

#### addTask: Adds a new task to the system.
#### assignTask: Updates task details and sends an email notification.
#### checkStatus: Retrieves the status of a task.
#### checkDueDate: Retrieves the due date of a task.
#### getByEmail: Retrieves tasks associated with a specific email.
## Usage
### Adding a Task
To add a task, use the addTask endpoint with a POST request. Provide the necessary task details in the request body.

```http
POST /task
{
  "taskName": "Complete Project",
  "dueDate": "2024-02-01",
  "assignedTo": "John Doe",
  "assignedBy": "Jane Smith",
  "mail": "john.doe@example.com"
}
```
 ### Updating a Task
 To update a task, use the updateTask endpoint with a PUT request. Provide the task ID and updated details in the request body.
 
 ```http
PUT /task/{id}
{
  "taskname": "Edited",
   "assignedTo": "Greeshma",
  "mail": "geethamadhuri1976@gmail.com",
  "status": "assigned"
}
```

### Checking Task Status
To check the status of a task, use the checkStatus endpoint with a GET request.
```http
GET /tasks/{id}
```
### Checking Due Date
To check the due date of a task, use the checkDueDate endpoint with a GET request.
```http
GET /tasks/dueDate/{id}
```
### Retrieving Tasks by Email
To retrieve tasks associated with a specific email, use the getByEmail endpoint with a GET request.
```http
GET /task/checkByEmail/{mail}
```
