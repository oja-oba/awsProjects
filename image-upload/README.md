

This repository contains a Spring Boot application with a React frontend that demonstrates the integration of Amazon S3 for profile picture management. 
The application is designed to showcase how users, who are pre-defined, can have their profile pictures stored in an Amazon S3 bucket. 
The Spring Boot backend handles the retrieval of images from S3, while the React frontend provides an interactive interface for users to view and manage their profile pictures.

Features

    Pre-defined
    Download and display profile pictures stored in Amazon S3.
    Upload and update profile pictures through the user interface.
    Simple and intuitive web interface powered by React.

Technologies Used

    Java Spring Boot
    React
    Amazon S3
    RESTful API for communication between frontend and backend

Prerequisites

    Java Development Kit (JDK)
    Node.js and npm
    Amazon S3 account and access credentials
    IDE (Integrated Development Environment) for Java and Node.js (e.g., IntelliJ IDEA, Visual Studio Code)



Getting Started

    Clone this repository to your local machine:


Backend Setup:

    Open the backend directory in your preferred Java IDE.
    Configure your Amazon S3 credentials in the Amazonconfig file
    Build and run the Spring Boot application.

Frontend Setup:

    Open the frontend directory in your terminal.

    Install frontend dependencies:

    bash

npm install


Start the React development server:

bash

        npm start

    Access the application:
        Open your web browser and navigate to http://localhost:3000 to access the React frontend.

How to Use


    Profile Picture: After logging in, the user's profile picture, fetched from Amazon S3, will be displayed on the profile page.

    Update Profile Picture: Users can upload a new profile picture, which will be stored in the Amazon S3 bucket and immediately displayed on the profile page.

Folder Structure

    backend: Contains the Java Spring Boot application.
    frontend: Contains the React frontend application.