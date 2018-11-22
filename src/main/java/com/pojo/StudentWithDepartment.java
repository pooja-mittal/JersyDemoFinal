package com.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentWithDepartment {
	@Id
	int id;
	String hodName;
	String departmentName;
	String firstName, lastName;
	
	public StudentWithDepartment() {
		
	}
	
	public StudentWithDepartment(int id, String hodName, String departmentName, String firstName, String lastName) {
		super();
		this.id = id;
		this.hodName = hodName;
		this.departmentName = departmentName;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHodName() {
		return hodName;
	}
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
