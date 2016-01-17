package ninyan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ninyan.entities.Project;

@Controller
public class HomeController {
	@RequestMapping(value="/home")
	public String goHome(Model model, @ModelAttribute("project") Project project){
		model.addAttribute("project", project);
		return "home";
	}
}
