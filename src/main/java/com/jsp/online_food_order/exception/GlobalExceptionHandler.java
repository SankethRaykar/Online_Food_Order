package com.jsp.online_food_order.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//in this class we will be creating methods which will catch the exception

import com.jsp.online_food_order.dto.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> NoSucHElementException(NoSuchElementException exception){
		ResponseStructure<String> response =new ResponseStructure<>();
		response.setData(exception.getMessage());
		response.setMessage("exception created and handled");
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(PaymentFailedException.class)
	public ResponseEntity<ResponseStructure<String>> paymentFailedException(PaymentFailedException exception){
		ResponseStructure<String> apiresponse =new ResponseStructure<>();
		apiresponse.setData(exception.getMessage());
		apiresponse.setMessage("exception handled");
		apiresponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		
		return new ResponseEntity<>(apiresponse, HttpStatus.NOT_ACCEPTABLE);
		
	}
}
