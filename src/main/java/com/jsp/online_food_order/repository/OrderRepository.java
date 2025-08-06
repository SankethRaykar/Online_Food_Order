package com.jsp.online_food_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.online_food_order.entity.Order;

public interface OrderRepository  extends JpaRepository<Order, Integer>{

}
