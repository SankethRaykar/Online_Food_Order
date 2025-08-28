package com.jsp.online_food_order.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info; 
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class ApplicationSwaggerConfiguration {

	
	@Bean
	OpenAPI openApi() {
		
		Server localhost=new Server();
		localhost.setUrl("http://localhost:8089");
		localhost.setDescription("local environment");
		
		
		Contact contact=new Contact();
		contact.setEmail("sankethraykar17@gmail.com");
		contact.setName("Sanketh  S Raykar");
		
		
		Info info=new Info().title("online food order application")
				.version("1.8").contact(contact)
				.description("this documentation exposes the API endpoints to manage food application");
		return new OpenAPI().info(info).servers(List.of(localhost));
		
	}
}
