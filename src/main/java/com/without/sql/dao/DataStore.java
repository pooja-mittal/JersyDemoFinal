package com.without.sql.dao;

import java.util.HashMap;
import java.util.Map;

import com.pojo.Department;
import com.pojo.Student;

public class DataStore {

	static Map<Integer, Student> studentStore = new HashMap<>();
	static Map<Integer, Department> departmentStore = new HashMap<>();

	public static Map<Integer, Student> getAllStudentData() {
		return studentStore;
	}

	public static Map<Integer, Department> getAllDepartmentData() {
		return departmentStore;
	}
}
