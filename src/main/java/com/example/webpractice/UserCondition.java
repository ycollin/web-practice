package com.example.webpractice;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class UserCondition {

	@Id
	private Integer id;

	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromBirthday;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date toBirthday;
	private Integer sex;
	private String prefectureId;

}
