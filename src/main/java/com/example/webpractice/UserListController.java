package com.example.webpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserListController {

	@Autowired
	private UserRepository userRepository;

	   @GetMapping("/users/list")
	    public String list(@RequestParam(name="name", required=false, defaultValue="user1") String name, Model model) {
		    model.addAttribute("name", name);
		    model.addAttribute("userList", userRepository.findAll());
	        return "users/list";
	    }


	   @GetMapping("/users/update")
	    public String update(@RequestParam(name="id", required=true, defaultValue="1") Integer id, Model model) {
		    model.addAttribute("id", id);
		    model.addAttribute("user", userRepository.findById(id).get());

	        return "users/update";
	    }



	   @PostMapping("/users/update")
	    public String update(@ModelAttribute  User user, Model model) {
		   userRepository.save(user);
		   model.addAttribute("user", userRepository.findById(user.getId()).get());

	        return "redirect:list";
	    }
}
