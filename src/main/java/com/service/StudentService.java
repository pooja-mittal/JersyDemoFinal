package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.database.DataStore;
import com.pojo.Student;

public class StudentService {
	static Map<Integer, Student> studentStore=DataStore.getAllStudentData();
	
	public StudentService() {
		studentStore.put(1, new Student("pooja","mittal",1,101));
		studentStore.put(2, new Student("vicky","singhal",2,101));
		studentStore.put(3, new Student("veenu", "agg",3,102));
		studentStore.put(4, new Student("Akansha", "shekghal",3,102));
	}

	public List<Student> getAllStudenttData() {
		return new ArrayList<Student>(studentStore.values());
	}
	//get
	public Student getStudenttData(int id) {
		return studentStore.get(id);
	}
	//post
	public Student addStudenttData(Student student) {
		student.setId(studentStore.size()+1);
		studentStore.put(student.getId(), student);
		return student;
	}
	//put
	public Student updateStudentInfo(Student student) {
		if(student.getId()<=0) {
			return null;
		} else {
			studentStore.put(student.getId(), student);
		}
		return student;
	}
	//delete
	public Student deleteStudent(int id) {
		return studentStore.remove(id);
	}
	
	
}
