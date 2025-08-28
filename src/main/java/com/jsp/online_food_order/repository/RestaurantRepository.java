package com.jsp.online_food_order.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.online_food_order.entity.Food;
import com.jsp.online_food_order.entity.Order;
import com.jsp.online_food_order.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

	
	@Query("Select r_Food FROM Restaurant r WHERE r_id =restaurantId")
//@param is used to store the value to passed to the above query

	List<Food> findFoodByRestaurantId(@Param(value = "restaurantId")int id);

	List<Order> findOrdersByRestaurantId(Integer id);
	
	
	
	@Query("SELECT r.orders FROM Restaurant r WHERE r.id = :restaurantId")
	List<Order> findOrdersByRestaurantId(@Param(value="restaurantId") int id);
}
