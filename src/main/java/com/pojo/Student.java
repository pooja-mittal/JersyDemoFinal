package com.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	public Student(String name, String lastName, int id, int deptId) {
		super();
		this.firstName = name;
		this.lastName = lastName;
		this.id = id;
		this.deptId=deptId;
	}
	public Student() {
		
	}
	String firstName, lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName = name;
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
	int deptId;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	

}
