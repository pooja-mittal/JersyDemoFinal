package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.database.StudentDataBase;
import com.student.data.StudentPojo;

public class StudentServiceMethods {
	static Map<Integer, StudentPojo> dataInfo=StudentDataBase.getAllData();
	
	public StudentServiceMethods() {
		dataInfo.put(1, new StudentPojo("pooja","mittal",1));
		dataInfo.put(2,new StudentPojo("vicky","singhal",2));
		dataInfo.put(3, new StudentPojo("veenu", "agg",3));
	}

	public List<StudentPojo> getAllStndtData() {
		return new ArrayList<StudentPojo>(dataInfo.values());
	}
	//get
	public StudentPojo getStndtData(int id) {
		return dataInfo.get(id);
	}
	//post
	public StudentPojo addStndtData(StudentPojo stndt) {
		stndt.setId(dataInfo.size()+1);
		dataInfo.put(stndt.getId(), stndt);
		return stndt;
	}
	//put
	public StudentPojo updateStudentInfo(StudentPojo stndt) {
		if(stndt.getId()<=0) {
			return null;
		} else {
			dataInfo.put(stndt.getId(), stndt);
		}
		return stndt;
	}
	//delete
	public StudentPojo removeData(int id) {
		return dataInfo.remove(id);
	}
	
	
}
