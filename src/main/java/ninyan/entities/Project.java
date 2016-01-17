package ninyan.entities;

import java.util.Date;

public class Project {
	private Long projectId;
	private String name;
	private String description;
	private String sponsor;
	private Long authorized_funds;
	private Long authorized_hours;
	private String year;
	private String type;
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public Long getAuthorized_funds() {
		return authorized_funds;
	}
	public void setAuthorized_funds(Long authorized_funds) {
		this.authorized_funds = authorized_funds;
	}
	public Long getAuthorized_hours() {
		return authorized_hours;
	}
	public void setAuthorized_hours(Long authorized_hours) {
		this.authorized_hours = authorized_hours;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", description=" + description + ", sponsor="
				+ sponsor + ", authorized_funds=" + authorized_funds + ", authorized_hours=" + authorized_hours
				+ ", year=" + year + ", type=" + type + ", date=" + date + "]";
	}
	

}
