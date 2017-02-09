package app.controller;

import app.domain.security.User;
import app.dto.UserDto;
import app.models.UserDao;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/login")
	public String loginPage(Model model) {
		model.addAttribute("viewName", "login-page");
		model.addAttribute("user", new UserDto());

		return "main";
	}

	@GetMapping(path = "/registration")
	public String registrationPage(Model model) {
		model.addAttribute("viewName", "registration-page");
		model.addAttribute("user", new UserDto());

		return "main";
	}

	@PostMapping(path = "/registration")
	public String saveUser(@ModelAttribute UserDto userDto) {
		userService.saveUser(userDto);

		return "redirect:/login";
	}

//	@PostMapping(path = "/login")
//	public String doLogin(Model model,@ModelAttribute UserDto user) {
//		userService.loginUser(user);
//		return "redirect:/";
//	}

}
