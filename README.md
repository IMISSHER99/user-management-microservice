# User Microservice

### Overview
The User Microservice is a core part of the e-commerce platform, responsible for handling user authentication, authorization, profiles, addresses, and other user-related functionalities. This microservice supports multiple roles (e.g., customer, vendor, admin), manages multiple addresses for each user, and ensures secure password management, JWT authentication, and verification mechanisms

### Key Features
1. User registration, login, and profile management.
2. Role-based access control (RBAC).
3. Multiple addresses per user with the option to mark one as the primary address.
4. Password reset, email, and phone verification.
5. JWT-based authentication with refresh tokens.
6. Activity logging for security and auditing purposes.
7. Custom user preferences (e.g., language, currency, and promotional settings).

### Table Structure
The database schema consists of ten main tables designed to support all the features mentioned above.

#### 1. Users
Stores essential user information such as email, phone, and verification status.

| column              | Type         | Description                               |
|---------------------|--------------|-------------------------------------------|
| id                  | BIGINT       | Primary Key, Auto Generated               |
| first_name          | VARCHAR(255) | User's first name                         |
| last_name           | VARCHAR(255) | User's last name                          |
| email               | VARCHAR(255) | User's email (unique)                     |
| phone_number        | VARCHAR(20)  | User's Phone Number (uniquer)             |
| password_hash       | VARCHAR(255) | Encrypted Password                        |
| profile_picture_url | VARCHAR(255) | URL for user's profile picture            |
| email_verified      | BOOLEAN      | Flag to indicate if the email is verified |
| phone_verified      | BOOLEAN      | Flag to indicate if the phone is verified |
| status              | ENUM         | User status: ACTIVE, DEACTIVATED, DELETED |
| created_at          | TIMESTAMP    | Time of creation                          |
| updated_at          | TIMESTAMP    | Time of last update                       |

#### 2. addresses
   Stores multiple addresses for each user, with one address marked as primary.

| column         | Type         | Description                                  |
|----------------|--------------|----------------------------------------------|
| id             | BIGINT       | Primary Key, Auto Generated                  |
| user_id        | BIGINT       | Foreign Key to users table                   |
| street         | VARCHAR(255) | Street Name                                  |
| city           | VARCHAR(255) | City                                         |
| state          | VARCHAR(20)  | state (optional)                             |
| country        | VARCHAR(255) | Country                                      |
| postal_code    | VARCHAR(10)  | Postal Code                                  |
| is_primary     | BOOLEAN      | Whether this address is the primary address. |
| created_at     | TIMESTAMP    | Time of creation                             |
| updated_at     | TIMESTAMP    | Time of last update                          |

#### 3. roles
Defines the roles that can be assigned to users (e.g., CUSTOMER, VENDOR, ADMIN).

| column    | Type        | Description                 |
|-----------|-------------|-----------------------------|
| id        | BIGINT      | Primary Key, Auto Generated |
| role_name | VARCHAR(50) | Name of the role            |

#### 4. user_roles
Maps users to roles, allowing many-to-many relationships between users and roles.

| column          | Type           | Description                    |
|-----------------|----------------|--------------------------------|
| role_id         | BIGINT         | Foreign key to the roles table |
| user_id         | BIGINT         | Foreign Key to users table     |
| assigned_at     | TIMESTAMP(255) | Time the role was assigned     |