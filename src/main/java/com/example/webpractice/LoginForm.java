package com.example.webpractice;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginForm {
	@NotEmpty
	String name;
	@NotEmpty
	String password;

}
