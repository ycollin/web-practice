package com.example.webpractice;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
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

	@Autowired
	private PrefectureRepository prefectureRepository;

	final public static Map<String, String> sexList = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
		{
			put("male", "1");
			put("female", "2");
			put("other", "3");
		}
	});

	@GetMapping("/users/list")
	public String list(@RequestParam(name = "name", required = false, defaultValue = "user1") String name,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("condition", new UserCondition());
		model.addAttribute("userList", userRepository.findAll());
		return "users/list";
	}

	@GetMapping("/users/search")
	public String search(@ModelAttribute UserCondition condition, Model model) {
		model.addAttribute("condition", condition);
		// TODO: 検索条件
		if (Strings.isNotEmpty(condition.getName())) {
			model.addAttribute("userList", userRepository.findByName(condition.getName()));
		} else {
			model.addAttribute("userList", userRepository.findAll());
		}
		return "users/list";
	}

	@GetMapping("/users/update")
	public String showUpdate(@RequestParam(name = "id", required = true, defaultValue = "1") Integer id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("user", userRepository.findById(id).get());
		model.addAttribute("prefectureList", prefectureRepository.findAll());
		model.addAttribute("sexList", sexList);

		return "users/update";
	}

	@PostMapping("/users/update")
	public String update(@ModelAttribute User user, Model model) {
		userRepository.save(user);
		model.addAttribute("user", userRepository.findById(user.getId()).get());

		return "redirect:list";
	}

	@GetMapping("/users/register")
	public String showRegister(@ModelAttribute User user, Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("prefectureList", prefectureRepository.findAll());
		model.addAttribute("sexList", sexList);
		return "users/register";
	}

	@PostMapping("/users/register")
	public String register(@ModelAttribute User user, Model model) {
		userRepository.save(user);
		return "redirect:list";
	}

	@PostMapping("/users/delete")
	public String delete(@RequestParam(name = "id", required = true) Integer id, Model model) {
		userRepository.deleteById(id);
		return "redirect:list";
	}
}
