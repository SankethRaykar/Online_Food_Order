package com.jsp.online_food_order.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.online_food_order.dto.ResponseStructure;
import com.jsp.online_food_order.entity.User;
import com.jsp.online_food_order.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
		
	private final UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> createUser(@RequestBody User user){
		User response = userService.createUser(user);
		ResponseStructure<User> apiRespose = new ResponseStructure();
		apiRespose.setData(response);
		apiRespose.setMessage("User is created");
		apiRespose.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(apiRespose,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/get")
	public ResponseEntity<ResponseStructure<User>> getUser(@PathVariable Integer id){
		User response = userService.getUser(id);
		ResponseStructure<User> apiRespose = new ResponseStructure();
		apiRespose.setData(response);
		apiRespose.setMessage("User is found");
		apiRespose.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<User>>(apiRespose,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUser(){
		List<User> response = userService.getAllUsers();
		ResponseStructure<List<User>> apiRespose = new ResponseStructure();
		apiRespose.setData(response);
		apiRespose.setMessage("Users found");
		apiRespose.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(apiRespose,HttpStatus.OK);
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user,@PathVariable Integer id){
		User response = userService.updateUser(user, id);
		ResponseStructure<User> apiRespose = new ResponseStructure();
		apiRespose.setData(response);
		apiRespose.setMessage("User updated");
		apiRespose.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(apiRespose,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping("/{id}/user/uploadImage")
	public ResponseEntity<ResponseStructure<String>> uploadImage(@RequestParam MultipartFile image,
			@PathVariable Integer id) throws IOException{
		String response = userService.uploadImage(image, id);
		ResponseStructure<String> apiRespose = new ResponseStructure();
		apiRespose.setData(response);
		apiRespose.setMessage("Success");
		apiRespose.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(apiRespose,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}/user/getImage")
	public ResponseEntity<byte[]> getImage(@PathVariable Integer id){
		byte[] image = userService.getImage(id);  
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(image);
	}
}
