package ninyan.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ninyan.entities.Project;

public class ProjectValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {
		Project project = (Project)obj;
		if(project.getName().length()<5){
			error.rejectValue("name", "project.name", "The name is too short!!!");
		}
	}

}
