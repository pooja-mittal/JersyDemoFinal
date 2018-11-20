package com.resource;

import dao.DepartmentDaoWithMethod;

public class DepartmentWithEntity {

	public static void main(String[] args) {
		DepartmentDaoWithMethod entiry=new DepartmentDaoWithMethod();
//		entiry.updateDeptInfo();
//		entiry.deleteDept(101);
//		entiry.selectDept(102);
		entiry.getListOFDept();

	}

}
