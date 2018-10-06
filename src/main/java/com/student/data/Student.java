package com.student.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	public Student(String name, String lastName, int id, int deptId) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.deptId=deptId;
	}
	public Student() {
		
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
	int deptId;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	

}
