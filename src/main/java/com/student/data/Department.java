package com.student.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
@Entity
public class Department {
	
	@Id
	int departmentId;
	String hodName;
	String departmentName;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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
	public Department(int deprtmentId, String departmentName,String hodName) {
		super();
		this.departmentId = deprtmentId;
		this.hodName = hodName;
		this.departmentName = departmentName;
	}
	
	public Department() {
		
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", hodName=" + hodName + ", departmentName="
				+ departmentName + "]";
	}	
	
	
}
