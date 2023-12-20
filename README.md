# 🏥 Hospital Management System

Welcome to the Hospital Management System, a Java application designed for managing patient and doctor information as well as appointments in a hospital setting! 🚑

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
