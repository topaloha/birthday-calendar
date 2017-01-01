package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String index(Model model, @RequestParam(value = "name", required = false)String name) {
		model.addAttribute("name", name);
		model.addAttribute("prop", "RequestProperties");

		return "hello";
	}

}
