package com.ahumadamob.model;

import java.util.Date;

public class Vacant {
	
	private Integer id;
	private String name;
	private String description;
	private Date postDate;
	private Double salary;
	private Integer highlight;
	private String image = "noimage.png";
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}	
	public Integer getHighlight() {
		return highlight;
	}
	public void setHighlight(Integer highlight) {
		this.highlight = highlight;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Vacant [id=" + id + ", name=" + name + ", description=" + description + ", postDate=" + postDate
				+ ", salary=" + salary + ", highlight=" + highlight + ", image=" + image + "]";
	}
	


}
