package com.example.webpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserListController {

	@Autowired
	private UserRepository userRepository;

	   @GetMapping("/users")
	    public String list(@RequestParam(name="name", required=false, defaultValue="user1") String name, Model model) {
		    model.addAttribute("name", name);
		    model.addAttribute("count" , userRepository.count());
	        return "users";
	    }
}
