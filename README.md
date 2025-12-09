# Student Management System

## Description
A Java console-based Student Management System using MySQL database.
Supports CRUD operations: Insert, View, Update, Delete and Exit.

## Technologies Used
- Java
- MySQL
- JDBC
- NetBeans IDE
- Git & GitHub

## Features
- Add new student
- View students
- Update student details
- Delete student
- Menu-driven console application

## How to Run
1. Clone the repository
2. Import into NetBeans
3. Create database and table in MySQL
4. Run the main class

##Database Schema
```sql
CREATE DATABSE studentdb;
USE studentdb;

CREATE TABLE students (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  age INT,
  course VARCHAR(50)
  );



