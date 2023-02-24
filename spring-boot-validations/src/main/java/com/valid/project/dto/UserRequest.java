package com.valid.project.dto;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class UserRequest {
	
	@NotNull(message="User name shouldn't be null")
	private String name;
	
	@Email
	private String email;
	
	@NotNull
	@Pattern(regexp="^\\d{10}$",message="invalid mobile number")
	private String mobile;
	private String gender;
	
	@Min(18)
	@Max(75)
	private int age;
	@NotBlank
	private String nationality;
	
	@NotNull
	private Date date;

}
