package ninyan.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ninyan.entities.Project;

@Service
public class ProjectService {
	private List<Project> projects = new LinkedList<Project>();
	
	public ProjectService(){
		projects.add(createProject("Java", "Java"));
		projects.add(createProject("B", "B"));
		projects.add(createProject("C", "C"));
		projects.add(createProject("D", "D"));
		projects.add(createProject("E", "E"));
	}

	public List<Project> findAll(){
		return projects;
	}

	private Project createProject(String title, String description) {
		Project p = new Project();
		p.setName(title);
		p.setDescription(description);
		p.setSponsor("yanning");
		p.setAuthorized_funds(1000L);
		p.setAuthorized_hours(100L);
		return p;
	}

	public Project findByName(String name) {
		for(Project p: projects){
			if(p.getName().equals(name))
				return p;
		}
		return null;
	}
	
	
}
