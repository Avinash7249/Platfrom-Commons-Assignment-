# Student Management Application

In this application, we can manage student data, and course data. Admin can add students, courses, and can manage these entities, students can get the courses they are assigned in and can drop from a particular course.

# ER Diagram
![ER Diagram Student Management](https://user-images.githubusercontent.com/101566533/208800309-d7c5f6e6-a433-4c22-bebb-a41f720c1952.png)

# Functionalities
-   Layered architecture
-   Admin can register/login
-   Register Courses,Students
-   Get Courses,Students
-   Student will be verified before ascession API
-   Can update Profile details

## Backend Work
-  Admin Authentication of signUp and Login using Spring security
-  Proper Exception Handling, and Input Validation
-  Data Stored in the database(mySQL)

## Installation and Run
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per your local database config.
```
server.port=8888
spring.datasource.url=jdbc:mysql://localhost:3306/studentsdb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
```

# Tech Stacks

-   Java Core
-   Spring Data JPA
-   Spring Security
-   Spring Boot
-   Hibernate
-   MySQL


# Backend

## Admin Controller

#### POST : /admin/register
```
{
    "userId": 1,
    "name": "Avinash Ghatanure",
    "mobileNumber": "7249249505",
    "password": "$2a$10$W.voyfiLVKfrB3u.BM.iRO6I6BN9qik8JNx9Ux./2dEu57.5ZS.rO",
    "role": "ROLE_ADMIN"
}
```

## Course Controller

#### POST : /courses/
```
**Response**
{
  "courseId": 2,
  "courseName": "Java Backend Development",
  "description": "The course is designed for every person from beginner to advance level",
  "courseType": "Live",
  "duration": "8 Months",
  "topics": "Java Core, Hibernate, JDBC, Spring, SpringBoot"
}
{
  "courseId": 4,
  "courseName": "Full Stack Web Development",
  "description": "The course is designed for every person from beginner to advance level",
  "courseType": "Live",
  "duration": "9 Months",
  "topics": "JavaScript, HTML, CSS, NodeJS, React"
}

```
#### GET => getStudentsFromCorseHandler : /courses/    
```
{
  "courseId": 4,
  "courseName": "Full Stack Web Development",
  "description": "The course is designed for every person from beginner to advance level",
  "courseType": "Live",
  "duration": "9 Months",
  "topics": "JavaScript, HTML, CSS, NodeJS, React",
  "studentList": [
    {
      "studentId": 5,
      "name": "Avinash Shrishail Ghatanure",
      "fatherName": "Shrishail Ghatanure",
      "email": "abc@gmail.com",
      "mobileNumber": "9890225498",
      "dob": "2000-11-20",
      "gender": "MALE"
    },
    {
      "studentId": 7,
      "name": "Abhinav Ashok Zambare",
      "fatherName": "Ashok Zambare",
      "email": "zambare@gmail.com",
      "mobileNumber": "8999712977",
      "dob": "2001-02-03",
      "gender": "MALE"
    },
    {
      "studentId": 9,
      "name": "Chetan Ramchand Gophne",
      "fatherName": "Ramchand Gophne",
      "email": "gophne@gmail.com",
      "mobileNumber": "9999712978",
      "dob": "2000-02-29",
      "gender": "MALE"
    },
    {
      "studentId": 11,
      "name": "Suraj Jaypal Gat",
      "fatherName": "Jaypal Gat",
      "email": "gat@gmail.com",
      "mobileNumber": "8499712978",
      "dob": "2000-05-16",
      "gender": "MALE"
    }
  ]
}
```
## Student Controller

#### Get : /students/courses
```
**Response
{
  "name": "Avinash Shrishail Ghatanure",
  "courses": [
    {
      "courseId": 2,
      "courseName": "Java Backend Development",
      "description": "The course is designed for every person from beginner to advance level",
      "courseType": "Live",
      "duration": "8 Months",
      "topics": "Java Core, Hibernate, JDBC, Spring, SpringBoot"
    },
    {
      "courseId": 4,
      "courseName": "Full Stack Web Development",
      "description": "The course is designed for every person from beginner to advance level",
      "courseType": "Live",
      "duration": "9 Months",
      "topics": "JavaScript, HTML, CSS, NodeJS, React"
    }
  ],
  "studentId": 5
}
```

## Swagger UI
## Student Controller
![s1](https://user-images.githubusercontent.com/101566533/208807712-1b99cb44-9f8b-492c-8fc1-d422bf17783d.JPG)


## Course Controller
![c](https://user-images.githubusercontent.com/101566533/208807704-2929e623-2101-4adc-9a2e-a768dbeb5436.JPG)

