package ninyan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ninyan.entities.Project;
import ninyan.validator.ProjectValidator;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject() {
		System.out.println("addProject");
		return "project_add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute Project project, Errors errors, RedirectAttributes attribute) {
		System.out.println("saveProject");
		if(!errors.hasErrors()){
			System.out.println("The project is validate");
		}else{
			System.out.println("The project is not validate");
		}
		System.out.println(project);
		attribute.addFlashAttribute("project", project);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, params={"type=multi"})
	public String saveMutiYearProject() {
		System.out.println("saveMutiYearProject");
		return "project_add";
	}
	
	@RequestMapping(value = "/find")
	@ResponseBody 
	public List<Project> find(Model model){
		//model.addAttribute("projects", this.projectService.findAll());
		//return "projects";
		return this.projectService.findAll();
	}
	
	@RequestMapping(value="/{name}")
	public String findProject(Model model, @PathVariable("name") String name){
		model.addAttribute("project", this.projectService.findByName(name));
		return "project";
	}
	
}
