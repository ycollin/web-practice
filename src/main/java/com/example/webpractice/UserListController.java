package com.example.webpractice;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	@GetMapping("/users/list")
	public String list(@RequestParam(name = "name", required = false, defaultValue = "user1") String name,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("condition", new UserCondition());
		model.addAttribute("userList", userRepository.findAll());
		model.addAttribute("prefectureMap", Prefecture.toMap(prefectureRepository.findAll()));
		return "users/list";
	}

	@GetMapping("/users/search")
	public String search(@ModelAttribute UserCondition condition, Model model) {
		model.addAttribute("condition", condition);
		// TODO: 検索条件ほか
		if (Strings.isNotEmpty(condition.getName())) {
			model.addAttribute("userList", userRepository.findByNameLike("%" + condition.getName() + "%"));
		} else {
			model.addAttribute("userList", userRepository.findAll());
		}
		model.addAttribute("name", condition.getName());
		model.addAttribute("condition", condition);
		model.addAttribute("prefectureMap", Prefecture.toMap(prefectureRepository.findAll()));
		return "users/list";
	}

	@GetMapping("/users/update")
	public String showUpdate(@RequestParam(name = "id", required = true, defaultValue = "1") Integer id, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("user", userRepository.findById(id).get());
		model.addAttribute("prefectureList", prefectureRepository.findAll());

		return "users/update";
	}

	@PostMapping("/users/update")
	public String update(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "users/update";
		}
		userRepository.save(user);
		model.addAttribute("user", userRepository.findById(user.getId()).get());

		return "redirect:list";
	}

	@GetMapping("/users/register")
	public String showRegister(@ModelAttribute User user, Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("prefectureList", prefectureRepository.findAll());
		return "users/register";
	}

	@PostMapping("/users/register")
	public String register(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "users/register";
		}
		userRepository.save(user);
		return "redirect:list";
	}

	@PostMapping("/users/delete")
	public String delete(@RequestParam(name = "id", required = true) Integer id, Model model) {
		userRepository.deleteById(id);
		return "redirect:list";
	}
}
