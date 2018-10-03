package com.student.data;

public class HodPojo {
	
	int deptId;
	String hodName;
	String deptName;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getHodName() {
		return hodName;
	}
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public HodPojo(int deptId, String hodName, String deptName) {
		super();
		this.deptId = deptId;
		this.hodName = hodName;
		this.deptName = deptName;
	}
	
	
	
}
