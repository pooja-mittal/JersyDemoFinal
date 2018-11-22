package com.service;

import java.util.List;
import com.pojo.StudentWithDepartment;
import dao.StdntWithDeptDao;

public class StdntjoinDeptService {
	StdntWithDeptDao joinDao=new StdntWithDeptDao();
	
	public List<StudentWithDepartment> getStudentDeptList() {
		return  joinDao.getAllDeptDetail();
	}
	
	

}
