package com.service;

import java.util.List;
import com.pojo.Student;
import dao.StudentDao;

public class StudentSqlService {
	StudentDao studentDao = new StudentDao();
	Student s1;
	
	public Student getById(int studentId) {
		return studentDao.getStudent(studentId);		
	}
	
	public void deleteById(int studentId) {
		studentDao.deleteStudent(studentId);
	}
	
	public List<Student> getAll() {
		return studentDao.getAllStudent();
	}
	
	public void create(Student s1) {
		studentDao.createNewStudent(s1);
	}
	public void update(Student updateStudent) {
		studentDao.updateStudentInfo(updateStudent);
	}	

}
