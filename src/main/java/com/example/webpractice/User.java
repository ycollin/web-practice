package com.example.webpractice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name = "users")
public class User {

	@Id
	private Integer id;

	private String name;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	private Integer sex;
	private String prefectureId;
	private String password;
//
//	final public static Map<String, String> sexList = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
//		{
//			put("male", "1");
//			put("female", "2");
//			put("other", "3");
//		}
//	});
//
//	public String getSexString() {
//		return sexList.get(sex);
//	}

}
