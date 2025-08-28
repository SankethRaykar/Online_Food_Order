package com.jsp.online_food_order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BillResponse {

	private String restaurantName;
	private String orderSummary;
	private float totalPrice; //we are keeping this in primitive because if there ar two non primitive with out of range we are going to get error as it is going to unboxing
	
}
