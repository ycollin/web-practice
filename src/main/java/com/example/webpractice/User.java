package com.example.webpractice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="users")
public class User {

	@Id
	private Integer id;

	private String name;
	private Date birthday;
	private Integer sex;
	private String prefectureId;
	private String password;

}
