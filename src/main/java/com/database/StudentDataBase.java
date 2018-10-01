package com.database;

import java.util.HashMap;
import java.util.Map;

import com.student.data.StudentPojo;

public class StudentDataBase {
	
	static Map<Integer, StudentPojo> dataInfo=new HashMap<>();
	
	public static Map<Integer, StudentPojo> getAllData() {
		return dataInfo;
	}
}
