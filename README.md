# Java Challenge Backend Service

This project build using Spring Boot

## Requirement
- Java version 11

To run the application, you need to install this application :
- Intellij IDEA (latest version)
- pgAdmin 4

## API Documentation
This section outline all the API endpoint in this backend service:
### Base URL
For the base url, it depends on your localhost, usually in http://localhost:8080

### POST `/register`
Register a new User.
- **Endpoint:** `/register`
- **Method:** POST
- **Example OK Response:**
```json

{
    "data": {
        "username": "Admin",
        "password": "admin"
    },
    "message": "Registrasi berhasil"
}
```

### POST `/login`
Service to user login
- **Endpoint:** `/login`
- **Method:** POST
- **Example OK Response:**
```json

{
    "HttpStatus": 200,
    "message": "Sukses Login"
}
```


### GET `/user`
Retrieve all user list.
<br>
- **Endpoint:** `/user`
- **Method:** GET
- **Example OK Response:**
```json
[
    {
        "id": 1,
        "username": "root",
        "password": "root"
    },
    {
        "id": 2,
        "username": "test",
        "password": "test"
    }
]
```

### PUT `/user/edit/{id}`
Edit spesific user by user Id.
<br>
Note: `{id}` is the id of the user.
- **Endpoint:** `/edit/user/{id}`
- **Method:** PUT
- **Example OK Response:**
```json
{
    "data": {
        "id": 14,
        "username": "newData",
        "password": "admin"
    },
    "HttpStatus": 201,
    "message": "Data berhasil diedit"
}
```
