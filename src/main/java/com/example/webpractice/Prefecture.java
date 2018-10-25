package com.example.webpractice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="prefectures")
public class Prefecture {

	@Id
	private Integer id;
	private String name;

	public static Map<Integer, String> toMap(List<Prefecture> list) {
		return list.stream().collect(Collectors.toMap(Prefecture::getId, Prefecture::getName));
	}

}
