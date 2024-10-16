# JobQuest REST API

This project is a **Spring Boot REST API** built for managing job postings, including operations to create, search, and retrieve job posts. It uses **MongoDB** for data storage.

## Features

- **Home Page API**: Basic information about the API.
- **Help API**: Lists all available API endpoints.
- **Get All Job Posts**: Retrieve all job posts from the database.
- **Add New Job Post**: Create a new job posting.
- **Search Job Post**: Search for job posts based on criteria.


## Table of Contents

- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Request & Response Examples](#request--response-examples)
- [Running the Application](#running-the-application)
- [Technologies Used](#technologies-used)


## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6+
- MongoDB installed and running
- Spring Boot 2.5+

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Hariharan1893/JobQuest-RestAPI.git
   ```

2. Navigate to the project directory:

   ```bash
   cd JobQuest-RestAPI
   ```

3. Build the application using Maven:

   ```bash
   mvn clean install
   ```

4. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

5. Make sure MongoDB is running on the default port (27017) or configure it in the `application.properties`.

## API Endpoints

### 1. Home Page API

- **URL**: `/api/home`
- **Method**: `GET`
- **Description**: Provides basic information about the application.

#### Response

```json
Hello all Welcome to JobQuest...
```

### 2. Help API (List of Endpoints)

- **URL**: `/api/help`
- **Method**: `GET`
- **Description**: Lists all available API endpoints for easy reference.

#### Response

```json
{
  "endpoints": [
    {
      "method": "GET",
      "url": "/api/jobpost/allposts",
      "description": "Get all job posts"
    },
    {
      "method": "POST",
      "url": "/api/jobpost/addpost",
      "description": "Add a new job post"
    },
    {
      "method": "GET",
      "url": "/api/jobpost/get/search",
      "description": "Search for a job post"
    },
    {
      "method": "GET",
      "url": "/api/home",
      "description": "Get home page information"
    },
    {
      "method": "GET",
      "url": "/api/help",
      "description": "List all available API endpoints"
    }
  ]
}
```

### 3. Get All Job Posts

- **URL**: `/api/jobpost/allposts`
- **Method**: `GET`
- **Description**: Fetches all job posts from the database.

#### Response

```json
[
  {
        "profile": "java developer",
        "desc": "Responsible for developing, testing, and maintaining Java-based applications using Spring Boot and Microservices architecture.",
        "exp": 2,
        "techs": [
            "java",
            "springboot",
            "microservices",
            "mysql"
        ]
    },
  ...
]
```

### 4. Add New Job Post

- **URL**: `/api/jobpost/addpost`
- **Method**: `POST`
- **Description**: Adds a new job post to the database.
- **Request Body**:

```json
{
  "desc" : "Develops software solutions by analyzing system requirements and writing clean, efficient code for embedded systems.",
  "exp" : "4",
  "profile" : "embedded software engineer",
  "techs" : ["c", "c++", "rtos", "arm cortex"]
}
```

#### Response

```json
{
    "id": "2",
    "profile": "embedded software engineer",
    "desc": "Develops software solutions by analyzing system requirements and writing clean, efficient code for embedded systems.",
    "exp": 4,
    "techs": [
        "c",
        "c++",
        "rtos",
        "arm cortex"
    ]
}
```

### 5. Search Job Post

- **URL**: `/api/jobpost/get/search`
- **Method**: `GET`
- **Description**: Search for job posts by title, company, or location.

#### Example Request

```bash
GET /api/jobpost/get/java
```

#### Response

```json
[
   {
        "profile": "java developer",
        "desc": "Responsible for developing, testing, and maintaining Java-based applications using Spring Boot and Microservices architecture.",
        "exp": 2,
        "techs": [
            "java",
            "springboot",
            "microservices",
            "mysql"
        ]
    },
    ...
]
```



## Running the Application

Make sure MongoDB is running locally or modify the configuration in `application.properties`. Then, use the following command to start the Spring Boot application:

```bash
mvn spring-boot:run
```

Access the API on `http://localhost:8080`.

## Technologies Used

- **Java 21**
- **Spring Boot 3.3.4**
- **MongoDB** for data storage
- **Maven** for project management

