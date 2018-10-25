package com.example.webpractice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sex {
	MALE(1,"male"),
	FEMALE(2,"female"),
	OTHER(3,"other"),
	;

	private final int id;
	private final String name;

	public static String idToName(int id) {
		for(Sex s : values()) {
			if (s.id == id) {
				return s.name;
			}
		}
		return MALE.name;
	}

}
