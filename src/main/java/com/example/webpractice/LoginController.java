package com.example.webpractice;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.val;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;

	@Autowired
	private UserRepository userRepository;


	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute(new User());
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute  User user ,Model model) {
		val found = userRepository.findByName(user.getName());
		if (found.isEmpty() || !user.getPassword().equals(found.get(0).getPassword())) {
			user.setPassword("");
			return "/login";
		}
		session.setAttribute("login", new Date());

		return "redirect:/users/list";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {

		session.removeAttribute("login");

		return "redirect:/login";
	}
}
