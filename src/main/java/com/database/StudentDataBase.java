package com.database;

import java.util.HashMap;
import java.util.Map;

import com.student.data.HodPojo;
import com.student.data.StudentPojo;

public class StudentDataBase {

	static Map<Integer, StudentPojo> dataInfo = new HashMap<>();
	static Map<Integer, HodPojo> hodMap = new HashMap<>();

	public static Map<Integer, StudentPojo> getAllData() {
		return dataInfo;
	}

	public static Map<Integer, HodPojo> getAllHodData() {
		return hodMap;
	}
}
