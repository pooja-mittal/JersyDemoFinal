package com.service;

import java.util.List;
import com.pojo.Department;
import dao.DepartmentDaoWithMethod;

//connect jersy to dao
public class DepartmentHibernateService {
	
	DepartmentDaoWithMethod connectWithDeptDao=new DepartmentDaoWithMethod();
	public Department getParticularDept(int departmentId) {
		return connectWithDeptDao.selectDept(departmentId);
	}
	
	public List<Department> getListOfDepts() {
		return connectWithDeptDao.getListOFDept();
	}
	
	public Department addNewDept(Department newDept) {
		return connectWithDeptDao.createDept(newDept);
	}
	
	public void deleteDept(int departmentId) {
		connectWithDeptDao.deleteDept(departmentId);
	}
	
	public Department updateDept(Department updateDepartment) {
		connectWithDeptDao.updateDeptInfo(updateDepartment);
		return updateDepartment;
	}

}
