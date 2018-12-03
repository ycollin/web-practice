package com.example.webpractice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name = "users")
public class User {

	@Id
	@NotNull
	private Integer id;

	@NotEmpty
	private String name;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;

	private Integer sex;

	private String prefectureId;


	@NotEmpty
	private String password;

}
