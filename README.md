#Paytm-Clone

Paytm Clone – Spring Boot Project
A Paytm Clone Application built using Spring Boot that simulates core online banking and digital wallet functionalities. This project demonstrates backend development using Spring Boot, REST APIs, JPA, and MySQL — providing a secure and scalable digital payment system.


🚀 Features
👤 User Module
Register a new user
User login with authentication (Spring Security / JWT)
View user profile and wallet balance

💰 Wallet Module
Automatic wallet creation on user registration
Check wallet balance
Add money to wallet (mock payment gateway simulation)
Transaction history tracking

🔁 Transaction Module
Send money to another user using mobile number or email
Request money from another user
View all sent and received transactions
Validate sufficient balance before transfer

🏦 Bank Integration (Simulation)
Link/Unlink bank account
Add funds from linked bank account
Withdraw funds to linked account

⚙️ Admin Panel
View all users
View all transactions
Manage user accounts


🛠️ Tech Stack
Backend Framework: Spring Boot (v3.x)
Database: MySQL
ORM: Spring Data JPA / Hibernate
Security: Spring Security / JWT Authentication
Build Tool: Maven
Language: Java 21
IDE: IntelliJ IDEA


📁 Project Structure
Paytm-Clone/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/paytmclone/
 │   │   │   ├── controller/        # REST API controllers
 │   │   │   ├── service/           # Business logic layer
 │   │   │   ├── dto/               # Data Transfer Objects
 │   │   │   ├── entity/            # JPA entities
 │   │   │   ├── repository/        # Spring Data JPA interfaces
 │   │   │   └── config/            # Security & JWT configuration
 │   │   └── resources/
 │   │       ├── application.properties
 │   │       └── data.sql (optional test data)
 │   └── test/                      # Unit & integration tests
 ├── pom.xml
 └── README.md



⚙️ Configuration
🧩 application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/paytm_clone
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.security.jwt.secret=your_secret_key
server.port=8080

   
