package app.controller;

import app.domain.BirthdayEntry;
import app.domain.builder.BirthdayEntryBuilder;
import app.dto.BirthdayEntryDto;
import app.models.BirthdayEntryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BirthdayEntryController {

	private static Logger logger = LoggerFactory.getLogger(BirthdayEntryController.class);

	@Autowired
	private BirthdayEntryDao birthdayEntryDao;

	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(value = "name", required = false)String name) {
		model.addAttribute("name", name);
		model.addAttribute("prop", "RequestProperties");

		return "hello";
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("persons", birthdayEntryDao.getAll());
		model.addAttribute("prop", "RequestProperties");
		model.addAttribute("viewName", "birthday-list");

		return "main";
	}

	@GetMapping(value = "/createBirthdayEntry")
	public String createBirthdayEntry(Model model) {
		model.addAttribute("viewName", "create-birthday-entry");
		model.addAttribute("entry", new BirthdayEntryDto());

		return "main";
	}

	@PostMapping(value = "/createBirthdayEntry")
	public String saveBirthdayEntry(@ModelAttribute BirthdayEntryDto entry) {
		BirthdayEntry birthdayEntry = BirthdayEntryBuilder.aBirthdayEntry()
													.withDataFromDto(entry)
													.build();
		birthdayEntryDao.createEntry(birthdayEntry);
		return "redirect:/";
	}

}
