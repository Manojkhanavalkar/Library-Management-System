# 📚 Library Management System (Console-Based - Spring Boot)

This is a **practice Java console project** built using **Spring Boot**, demonstrating the core functionalities of a **Library Management System**, such as managing books, users, and book issuance/return operations. The application uses **JDBC with Spring's JdbcTemplate** and runs entirely in the console.

---

## ✨ Features

- 📘 **Books**
  - Add new books
  - View all books
  - Search books by title
  - Update book details
  - Delete books
  - View specific book information

- 👤 **Users**
  - Add users
  - View all users
  - Get details of a specific user
  - Update user information
  - Delete a user

- 🔄 **Book Issuing/Returning**
  - Issue a book to a user
  - Return an issued book
  - View all currently issued books

---

## 🧠 Technologies Used

- **Java**
- **Spring Boot**
- **Spring JDBC (JdbcTemplate)**
- **PostgreSQL / Any Relational DB**
- **Maven**
- **CommandLineRunner Interface**

---

## 🛠️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/library-management-system.git
   cd library-management-system
## project sturcture
com.library.management
├── dao
│   ├── BookDao.java
│   ├── IssueBookDao.java
│   └── UserDao.java
├── entity
│   ├── Book.java
│   ├── IssueBook.java
│   └── User.java
└── LibraryManagementSystemApplication.java

## 📖 Why This Project?
This project is a great beginner-friendly console project for Java developers learning:

Spring Boot basics

Spring JDBC with JdbcTemplate

CRUD operations

Console-based user input handling

Object-oriented design using DAOs and Entities
