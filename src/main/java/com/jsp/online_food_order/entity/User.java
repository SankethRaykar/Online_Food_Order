package com.jsp.online_food_order.entity;

import java.util.List;

import org.springframework.web.util.pattern.PatternParseException.PatternMessage;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@Pattern(
			regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
			flags = Pattern.Flag.CASE_INSENSITIVE,
			message = "Invalid email format"
			)
	private String email;
	@NotNull
	@NotBlank
	private String password;
	private String gender;
	@NotNull
	private Long contactNumber;
	
	@Lob
	private byte[] image;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Order> orders;
}