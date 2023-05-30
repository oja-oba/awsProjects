Customer Spring Boot Application with PostgreSQL

This repository contains a customer management Spring Boot application that utilizes PostgreSQL as the database. The application provides functionalities for managing customer information, such as creating, updating, deleting, and retrieving customer records.
Technologies Used

    Java
    Spring Boot
    PostgreSQL
    Docker Compose

Prerequisites

Before running the application, ensure that you have the following installed:

    Java Development Kit (JDK)
    Docker
    Docker Compose

Installation and Setup

    Clone this repository to your local machine.

    Ensure that Docker is running.

    Navigate to the project directory.

    Run the following command to start PostgreSQL using Docker Compose:

docker-compose up -d

Build the Spring Boot application using the following command:

bash

    ./mvnw clean install

Usage

    Once the application and PostgreSQL are up and running, you can access the application through the provided RESTful API endpoints.

    Use a tool like Postman or cURL to interact with the API endpoints and perform CRUD operations on customer records.

Customization

    Adjust the application's configuration in the application.properties file as needed.
    Modify the Docker Compose file (docker-compose.yml) to change PostgreSQL settings or add additional environment variables.

Contributions

Contributions to this project are welcome! Feel free to submit pull requests or open issues if you encounter any problems or have suggestions for improvement.
License


Feel free to customize and enhance this customer management Spring Boot application to meet your specific requirements. If you have any questions or need assistance, please don't hesitate to reach out.

Happy coding!