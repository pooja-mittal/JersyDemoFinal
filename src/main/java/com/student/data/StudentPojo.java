package com.student.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentPojo {
	public StudentPojo(String name, String lastName, int id) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.id = id;
	}
	public StudentPojo() {
		
	}
	String name, lastName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int id;
	

}
