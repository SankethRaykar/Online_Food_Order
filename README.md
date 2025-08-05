

# 🍽️ Online\_Food\_Order – Restaurant & Food Management API

A Spring Boot RESTful application that enables restaurants to manage their food items efficiently. It provides full CRUD operations on restaurants and food, supports pagination & sorting, and is easily extendable for future order and user management features.

---

## 📁 Project Structure

```
src/main/java/
└── com.jsp.online_food_order/
    ├── OnlineFoodOrderApplication.java
    ├── controller/
    │   ├── RestaurantController.java
    │   └── FoodController.java
    ├── entity/
    │   ├── Restaurant.java
    │   └── Food.java
    ├── repository/
    │   ├── RestaurantRepository.java
    │   └── FoodRepository.java
    ├── dao/
    │   ├── RestaurantDao.java
    │   └── FoodDao.java
    ├── service/
    │   ├── RestaurantService.java
    │   ├── FoodService.java
    │   └── implementation/
    │       ├── RestaurantServiceImplementation.java
    │       └── FoodServiceImplementation.java
    └── exception/
        ├── GlobalExceptionHandler.java
        └── ResourceNotFoundException.java
```

---

## ✅ Technologies Used

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman
* Eclipse / IntelliJ IDE

---

## 📌 Features

### 🏨 Restaurant Module

* Add new restaurant
* Update restaurant information
* Delete restaurant by ID
* Get restaurant by ID
* List all restaurants with pagination and sorting

### 🍽️ Food Module

* Add food items to a specific restaurant
* Update food details
* Delete food by ID
* Get food item by ID
* Get all food items

### 🛡 Error Handling

* Graceful exception handling for invalid IDs, missing data, etc.

---

## 🌐 API Endpoints

### 📍 Restaurant APIs

| Method | Endpoint            | Description                      |
| ------ | ------------------- | -------------------------------- |
| POST   | `/restaurants`      | Create a new restaurant          |
| PUT    | `/restaurants/{id}` | Update restaurant details        |
| DELETE | `/restaurants/{id}` | Delete restaurant by ID          |
| GET    | `/restaurants/{id}` | Get restaurant by ID             |
| GET    | `/restaurants`      | List all restaurants (paginated) |

### 📍 Food APIs

| Method | Endpoint                | Description              |
| ------ | ----------------------- | ------------------------ |
| POST   | `/food/{restaurant_id}` | Add food to a restaurant |
| PUT    | `/food/{id}`            | Update food item         |
| DELETE | `/food/{id}`            | Delete food item         |
| GET    | `/food/{id}`            | Get food item by ID      |
| GET    | `/food`                 | Get all food items       |

---

## ⚙️ application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/online_food_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧪 Sample JSON Payloads

### ➕ Add a Restaurant

**POST** `/restaurants`

```json
{
  "name": "Food Haven",
  "location": "Hyderabad"
}
```

### ➕ Add Food to Restaurant

**POST** `/food/1`

```json
{
  "name": "Chicken Biryani",
  "price": 300,
  "type": "NON_VEG"
}
```

---

## 🚀 Getting Started

1. Clone the repository:
   `git clone https://github.com/SankethRaykar/Online_Food_Order.git`

2. Open the project in Eclipse or IntelliJ

3. Update DB credentials in `application.properties`

4. Run `OnlineFoodOrderApplication.java`

5. Test the REST APIs via Postman or Swagger (if enabled)

---

## 🔮 Future Enhancements

* 🔐 JWT Authentication & Authorization
* 📦 Order Placement & Tracking
* 💳 Payment Gateway Integration
* 🌐 Frontend using React or Angular
* 👥 Role-Based Access (Admin, Restaurant Owner, Customer)

