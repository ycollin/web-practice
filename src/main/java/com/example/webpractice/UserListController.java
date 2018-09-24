package com.example.webpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserListController {

	@Autowired
	private UserRepository userRepository;

	   @RequestMapping("/")
	    public String index() {

	        return "Greetings from Spring Boot!aaa" + userRepository.count();
	    }
}
