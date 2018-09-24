package com.example.webpractice;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="prefectures")
public class Prefecture {

	@Id
	private Integer id;
	private String name;

}
