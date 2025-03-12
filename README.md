# webshopECommerceApp

This is a webshop eCommerce application that provides features like product listing, user management, and shopping cart functionality.

## Features

- **Product Listing**: Display a list of products for users to browse.
- **User Management**: Manage user accounts and profiles.
- **Shopping Cart**: Users can add products to their shopping cart and proceed to checkout.

## Technologies Used

### Backend
- **Java**: Core programming language.
- **Spring Boot**: Framework used for backend services.
- **RESTful APIs**: Used for managing product inventory and order processing.

### Frontend
- **HTML**: Markup language for creating web pages.
- **Thymeleaf**: Template engine for rendering dynamic web pages.
- **CSS**: Stylesheet language for designing web pages.

### Database
- **H2**: In-memory database used for development and testing.
- **MySQL**: Relational database management system used for production.

## Installation

### Prerequisites
- Java Development Kit (JDK)
- Maven
- MySQL

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/pavithra19/webshopECommerceApp.git
   ```
2. Navigate to the project directory:
   ```bash
   cd webshopECommerceApp
   ```
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Usage

1. Access the application at `http://localhost:8080`.
2. Browse the product listing, manage user profiles, and use the shopping cart functionality.

## Database Configuration

### H2 Database (Default)
- The application is pre-configured to use the H2 database for development.

### MySQL Database
To use MySQL, update the `application.properties` file with your MySQL database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
