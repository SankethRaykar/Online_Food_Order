package com.jsp.online_food_order.service;

import com.jsp.online_food_order.dto.BillResponse;
import com.jsp.online_food_order.dto.OrderRequest;
import com.jsp.online_food_order.dto.PaymentDto;
import com.jsp.online_food_order.entity.Order;
import com.jsp.online_food_order.entity.OrderStatus;

public interface OrderService {

	
	BillResponse generateBill(OrderRequest orderRequest);
	
	String payAndPlaceOrder(PaymentDto payment);
	
void deleteOrder(Integer id);
	
	Order getOrder(Integer id);
	
	Order updateStatusByAdmin(OrderStatus status,Integer id);
	
	String cancelOrder(Integer id);
}


