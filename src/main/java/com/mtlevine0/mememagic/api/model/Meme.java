package com.mtlevine0.mememagic.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	Template template;
	String location;
	String topLine;
	String bottomLine;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTopLine() {
		return topLine;
	}
	public void setTopLine(String topLine) {
		this.topLine = topLine;
	}
	public String getBottomLine() {
		return bottomLine;
	}
	public void setBottomLine(String bottomLine) {
		this.bottomLine = bottomLine;
	}
	
}
