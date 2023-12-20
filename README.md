# 🏥 Hospital Management System

Welcome to the Hospital Management System, a Java application designed for managing patient and doctor information as well as appointments in a hospital setting! 🚑

## 🎓 Project Purpose

This Hospital Management System is part of my ongoing efforts to enhance my skills in JDBC and MySQL. Through the development of this application, I aim to gain hands-on experience in database management and Java programming. Your contributions and feedback are valuable as they contribute to the continuous improvement of this project.

## 📋 Table of Contents

- [Features](#features)
- [Setup](#setup)
  - [Database Setup](#database-setup)
  - [Java Setup](#java-setup)
- [Usage](#usage)
  - [Main Menu](#main-menu)
  - [Patient Management](#patient-management)
  - [Doctor Management](#doctor-management)
  - [Appointment Booking](#appointment-booking)
- [Contributing](#contributing)
- [License](#license)

## ✨ Features

- Patient registration and viewing 🏥
- Doctor registration and viewing 👨‍⚕️
- Appointment booking system 📅
- User-friendly command-line interface 🖥️

## 🛠️ Setup

### Database Setup

1. Install MySQL on your machine if not already installed.
2. Create a new database named `hospital`.
3. Execute the SQL script in `database.sql` to create the necessary tables (`patients`, `doctors`, and `appointments`).

```sql
-- Create patients table
CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL
);

-- Create doctors table
CREATE TABLE IF NOT EXISTS doctors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    specialization VARCHAR(200) NOT NULL
);

-- Create appointments table
CREATE TABLE IF NOT EXISTS appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
```

## 🛠️ Java Setup

1. **Clone this repository to your local machine.**
2. **Open the project in your favorite Java IDE (e.g., IntelliJ IDEA, Eclipse).**
3. **Ensure you have the MySQL Connector/J library in your classpath.**
4. **Update the `url`, `username`, and `password` variables in `HospitalManagementSystem.java` to match your MySQL configuration.**

// Update these variables with your MySQL configuration
private static final String url = "jdbc:mysql://localhost:3306/hospital";
private static final String username = "your_username";
private static final String password = "your_password";

# 🚀 Usage

## Main Menu

Upon running the application, you will be presented with the main menu:

- **Add Patient:** Allows adding a new patient.
- **View Patients:** Displays a list of all patients.
- **Add Doctor:** Enables adding a new doctor.
- **View Doctors:** Shows a list of all doctors.
- **Book Appointment:** Books an appointment between a patient and a doctor.
- **Exit:** Closes the application.

## Patient Management

- **Add Patient:** Enter patient details, including name, age, and gender, to add a new patient.
- **View Patients:** Displays a list of all patients, including their ID, name, age, and gender.

## Doctor Management

- **Add Doctor:** Enter doctor details, including name and specialization, to add a new doctor.
- **View Doctors:** Shows a list of all doctors, including their ID, name, and specialization.

## Appointment Booking

- **Book Appointment:** Enter patient ID, doctor ID, and appointment date to book a new appointment. Checks for doctor availability.

## 🤝 Contributing

Feel free to contribute to the development of this Hospital Management System by submitting issues or pull requests. Contributions are welcome and appreciated!

