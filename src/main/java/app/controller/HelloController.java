package app.controller;

import app.domain.Person;
import app.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/hello")
	public String index(Model model, @RequestParam(value = "name", required = false)String name) {
		model.addAttribute("name", name);
		model.addAttribute("prop", "RequestProperties");
		userDao.create(new Person("2014-12-12", "rita", "s", "26"));

		return "hello";
	}

}
