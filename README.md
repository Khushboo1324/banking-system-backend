# 🏦 Banking System Backend

A robust and secure digital banking system backend built with Spring Boot and MongoDB, featuring JWT authentication, transaction management, and comprehensive API documentation.

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Running the Application](#-running-the-application)
- [API Documentation](#-api-documentation)
- [Project Structure](#-project-structure)
- [API Endpoints](#-api-endpoints)
- [Security](#-security)
- [Contributing](#-contributing)

## ✨ Features

### Core Banking Features
- 👤 **User Management** - User registration, authentication, and profile management
- 🏦 **Account Management** - Create and manage multiple account types (Savings/Current)
- 💸 **Transaction Processing** - Deposit, withdrawal, and transfer operations
- 📊 **Transaction Analytics** - Detailed transaction history and analytics
- 🔍 **Advanced Filtering** - Filter transactions by type, date, and more

### Security & Performance
- 🔐 **JWT Authentication** - Secure token-based authentication
- 🛡️ **Spring Security** - Role-based access control (ADMIN/USER)
- ⚡ **Caching** - Performance optimization with Spring Cache
- 🚦 **Rate Limiting** - API rate limiting to prevent abuse
- ✉️ **Email Notifications** - Email service integration for notifications

### Developer Features
- 📝 **API Documentation** - Interactive Swagger/OpenAPI documentation
- ✅ **Validation** - Request validation with Jakarta Validation
- 🎯 **Exception Handling** - Global exception handling mechanism
- 📁 **File Upload** - File management capabilities

## 🛠️ Tech Stack

### Backend Framework
- **Spring Boot 3.2.5** - Main application framework
- **Java 17** - Programming language

### Database
- **MongoDB** - NoSQL database for flexible data storage

### Security
- **Spring Security** - Security framework
- **JWT (jjwt 0.11.5)** - JSON Web Token for authentication

### Additional Libraries
- **Lombok** - Reduce boilerplate code
- **SpringDoc OpenAPI** - API documentation
- **Spring Mail** - Email functionality
- **Jakarta Validation** - Request validation

### Build Tool
- **Maven** - Dependency management and build automation

## 📦 Prerequisites

Before running this application, ensure you have:

- **Java 17** or higher
- **Maven 3.6+**
- **MongoDB 4.4+** (running on localhost:27017)
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Khushboo1324/banking-system-backend.git
   cd banking-system-backend
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Set up MongoDB**
   - Ensure MongoDB is running on `localhost:27017`
   - The application will automatically create the database `banking_db`

## ⚙️ Configuration

### Application Configuration

Edit `src/main/resources/application.yaml` to configure:

```yaml
spring:
  application:
    name: Banking-System
  data:
    mongodb:
      uri: mongodb://localhost:27017/DigitalBank
      database: banking_db
  mail:
    host: smtp.gmail.com
    port: 587
    username: ${MAIL_USERNAME}
    password: ${MAIL_PASSWORD}

server:
  port: 8080

jwt:
  secret: your-secret-key-here
  expiration: 86400000  # 24 hours in milliseconds
```

### Environment Variables

Set the following environment variables:

```bash
# Email Configuration
export MAIL_USERNAME=your-email@gmail.com
export MAIL_PASSWORD=your-app-password
```

### MongoDB Setup

The application expects MongoDB to be running with the following default settings:
- **Host**: localhost
- **Port**: 27017
- **Database**: banking_db

## ▶️ Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Using Java

```bash
mvn clean package
java -jar target/banking-system-0.0.1-SNAPSHOT.jar
```

### Using Maven Wrapper

```bash
# On Windows
mvnw.cmd spring-boot:run

# On Linux/Mac
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## 📚 API Documentation

Once the application is running, access the interactive API documentation:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI Docs**: `http://localhost:8080/v3/api-docs`

## 📁 Project Structure

```
banking-system-backend/
├── src/
│   ├── main/
│   │   ├── java/com/bankingsystem/
│   │   │   ├── config/              # Configuration classes
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   ├── JwtAuthenticationFilter.java
│   │   │   │   ├── CacheConfig.java
│   │   │   │   ├── RateLimitInterceptor.java
│   │   │   │   └── ...
│   │   │   ├── controller/          # REST Controllers
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── AccountController.java
│   │   │   │   ├── TransactionController.java
│   │   │   │   └── UserController.java
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   │   ├── AuthenticationDtos/
│   │   │   │   ├── AccountDtos/
│   │   │   │   ├── TransactionDtos/
│   │   │   │   └── UserDtos/
│   │   │   ├── exception/           # Custom Exceptions
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   └── ...
│   │   │   ├── model/               # Domain Models
│   │   │   │   ├── User.java
│   │   │   │   ├── Account.java
│   │   │   │   ├── Transaction.java
│   │   │   │   └── ...
│   │   │   ├── repository/          # Data Access Layer
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── AccountRepository.java
│   │   │   │   └── TransactionRepository.java
│   │   │   ├── service/             # Business Logic
│   │   │   │   ├── AuthService.java
│   │   │   │   ├── AccountService.java
│   │   │   │   ├── TransactionService.java
│   │   │   │   └── UserService.java
│   │   │   └── util/                # Utility Classes
│   │   │       └── JwtUtil.java
│   │   └── resources/
│   │       └── application.yaml     # Application Configuration
│   └── test/                        # Test Classes
├── pom.xml                          # Maven Configuration
└── README.md
```

## 🔌 API Endpoints

### Authentication

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/auth/register` | Register a new user | No |
| POST | `/api/auth/login` | Login and get JWT token | No |

### User Management

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/api/users/{id}` | Get user details by ID | Yes |

### Account Management

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/accounts` | Create a new account | Yes |
| GET | `/api/accounts/{id}/balance` | Get account balance | Yes |
| POST | `/api/accounts/{id}/deposit` | Deposit money | Yes |
| POST | `/api/accounts/{id}/withdraw` | Withdraw money | Yes |
| POST | `/api/accounts/{id}/transfer` | Transfer money to another account | Yes |

### Transactions

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| GET | `/transactions/account/{accountId}` | Get all transactions for an account | Yes |
| GET | `/transactions/filter` | Filter transactions by type, date, etc. | Yes |
| GET | `/transactions/analytics/{accountId}` | Get transaction analytics | Yes |

### Request Examples

#### Register a User
```json
POST /api/auth/register
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "securePassword123"
}
```

#### Login
```json
POST /api/auth/login
{
  "email": "john@example.com",
  "password": "securePassword123"
}

Response:
{
  "token": "eyJhbGciOiJIUzI1NiIs...",
  "userId": "507f1f77bcf86cd799439011",
  "role": "USER"
}
```

#### Create Account
```json
POST /api/accounts?userId=507f1f77bcf86cd799439011
{
  "accountType": "SAVINGS"
}

Response:
{
  "accountId": "507f191e810c19729de860ea",
  "accountNumber": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
  "balance": 0.0,
  "accountType": "SAVINGS"
}
```

#### Deposit Money
```json
POST /api/accounts/{accountId}/deposit
{
  "amount": 1000.00,
  "description": "Initial deposit"
}
```

## 🔒 Security

### Authentication Flow
1. User registers with email and password
2. Password is encrypted using BCrypt
3. User logs in with credentials
4. Server returns JWT token
5. Client includes token in Authorization header for subsequent requests
6. Token is validated on each protected endpoint

### JWT Token Format
```
Authorization: Bearer <jwt-token>
```

### Roles
- **USER** - Standard user with access to own accounts
- **ADMIN** - Administrative privileges

## 🧪 Testing

Run tests using Maven:

```bash
mvn test
```

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

**Khushboo1324**

- GitHub: [@Khushboo1324](https://github.com/Khushboo1324)

## 🙏 Acknowledgments

- Spring Boot Documentation
- MongoDB Documentation
- JWT.io for token debugging
- Swagger/OpenAPI for API documentation

---

**Note**: This is a backend API service. For production deployment, ensure you:
- Change the JWT secret key
- Configure proper email credentials
- Set up MongoDB with authentication
- Enable HTTPS
- Configure CORS policies appropriately
- Implement proper logging and monitoring
