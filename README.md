

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

Perfect! Based on your current controller code for both `RestaurantController` and `FoodController`, here's the **accurate `🌐 API Endpoints` section** for your `README.md` file.

---

## 🌐 API Endpoints

### 📍 Restaurant APIs

| Method | Endpoint                                     | Description                                                 |
| ------ | -------------------------------------------- | ----------------------------------------------------------- |
| POST   | `/restaurant/api/save`                       | Create a new restaurant                                     |
| GET    | `/restaurant/api/get/{id}`                   | Get restaurant by ID                                        |
| GET    | `/restaurant/api/getall`                     | Get all restaurants with pagination/sorting                 |
| PUT    | `/restaurant/api/update/{id}`                | Update restaurant by ID                                     |
| DELETE | `/restaurant/api/{id}/delete`                | Delete restaurant by ID                                     |
| POST   | `/restaurant/api/{restaurantId}/assignFood`  | Assign one or more food items to a restaurant (by food IDs) |

---

### 📍 Food APIs

| Method | Endpoint                    | Description                                |
| ------ | --------------------------- | ------------------------------------------ |
| POST   | `/food/api/save`            | Create a new food item                     |
| GET    | `/food/api/getfood/{id}`    | Get food item by ID                        |
| GET    | `/food/api/getallfood`      | Get all food items with pagination/sorting |
| PUT    | `/food/api/updatefood/{id}` | Update food item by ID                     |
| DELETE | `/food/api/{id}/delete`     | Delete food item by ID                     |

---

### 📝 Notes:

* Pagination & sorting supported in `/getall` endpoints using:

  ```
  ?pageNum=0&pageSize=5&sortBy=createdAt
  ```
* Food assignment uses `Set<Integer>` of food IDs in request body.

Would you like me to update the full `README.md` with this section included and send it as a file?

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
  "name": "The Spicy Spoon",
  "location": "MG Road",
  "city": "Bangalore",
  "state": "Karnataka",
  "country": "India",
  "pincode": 560001
}
```

### ➕ Add Food to Restaurant

**POST** `/food/1`

```json
{
  "name": "Chicken Biryani",
  "description": "spicy biriyani",
  "price": 200.0
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

