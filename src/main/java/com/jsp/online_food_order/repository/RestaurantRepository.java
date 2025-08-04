package com.jsp.online_food_order.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.online_food_order.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

}
