package com.service;

import java.util.ArrayList;
import java.util.List;

import com.student.data.StudentPojo;

public class StudentService {
	
	public List<StudentPojo> getAllData() {
		StudentPojo s1=new StudentPojo("pooja","mittal",1);
		StudentPojo s2=new StudentPojo("vicky","singhal",1);
		List<StudentPojo> li=new ArrayList<>();
		li.add(s1);
		li.add(s2);
		return li;		
	}
	
	
}
