package com.one.app.user;

import java.sql.Date;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UserVO {

	@NotBlank(message = "ID는 필수입력")
	private String username;
	@Size(min = 8, max = 16)
	@NotBlank(message = "PW는 필수입력")
	private String password;
	private String passwordCheck;
	private String name;
	private String phone;
	//@Range(min = 0, max = 150)
	//private int age;
	@Email
	private String email;
	@Past
	@NotNull
	private Date birth;
	private String fileName;
	private String oriName;
	
	
	
	
	
}
