package ninyan.entities;

import java.io.Serializable;

public class Blog implements Serializable{

	private static final long serialVersionUID = 1L;
	private  Integer id;
	private  String title;
	private  String content;
	private  String owner;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString(){
		return id + " - " + title + " - " + content + " - " + owner;
	}
}
