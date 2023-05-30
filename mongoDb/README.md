Spring Boot CRUD Application with MongoDB

This repository contains a Spring Boot CRUD application that utilizes MongoDB as the database. The application provides basic Create, Read, Update, and Delete operations for managing data.
Technologies Used

    Java
    Spring Boot
    MongoDB
    Docker Compose

Prerequisites

Before running the application, make sure you have the following installed:

    Java Development Kit (JDK)
    Docker
    Docker Compose

Installation and Setup

    Clone this repository to your local machine.

    Ensure that Docker is running.

    Navigate to the project directory.

    Run the following command to start MongoDB and Mongo Express using Docker Compose:

docker-compose up -d

Build the Spring Boot application using the following command:

bash

    ./mvnw clean install

Usage

    Once the application and MongoDB are up and running, you can access the API  at http://localhost:8080/api/v1/students.

    Use the provided endpoints in the StudentController class to  perform CRUD operations on the MongoDB database with postman or any appropriate tool.

Customization

    You can modify the application's configuration in the application.properties file.
    Adjust the Docker Compose file (docker-compose.yml) if you need to change any MongoDB or Mongo Express settings.

Contributions

Contributions to this project are welcome! Feel free to submit pull requests or open issues if you encounter any problems or have suggestions for improvement.


Feel free to customize and enhance this Spring Boot CRUD application to meet your specific requirements. If you have any questions or need assistance, please don't hesitate to reach out.

Happy coding!