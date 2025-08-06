package com.jsp.online_food_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.online_food_order.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
