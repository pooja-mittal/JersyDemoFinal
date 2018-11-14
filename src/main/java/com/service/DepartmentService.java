package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.database.DataStore;
import com.pojo.Department;

public class DepartmentService {
	
	static Map<Integer, Department> departmentStore= DataStore.getAllDepartmentData();
	
	public DepartmentService() {
		departmentStore.put(1, new Department(101, "ece", "Shekhar"));
		departmentStore.put(2, new Department(102, "ece", "vandana"));
			
	}
	public Department getParticularDepartment(int departmentId) {
		return departmentStore.get(departmentId);
	}
	
	public List<Department> getDepartmentData() {
		return new ArrayList<>(departmentStore.values());
	}
	
	public Department removeDepartment(int id) {
		return departmentStore.remove(id);
	}
	
	public Department updateDepartment(Department department) {
		if(department.getDepartmentId()<0) 
			return null;
		else 
			departmentStore.put(department.getDepartmentId(), department);
		return department;
	}
	
	public Department addAnotherDepartment(Department department) {
		department.setDepartmentId(departmentStore.size()+1);
		departmentStore.put(department.getDepartmentId(), department);
		return department;
	}
	
	

}
