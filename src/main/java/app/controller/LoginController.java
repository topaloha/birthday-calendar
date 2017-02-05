package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController {

	@RequestMapping(path = "/login")
	public String loginPage(Model model) {
		model.addAttribute("viewName", "login-page");
		return "main";
	}

}
