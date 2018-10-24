package com.example;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.student.data.Student;
import dao.StudentDao;

@Path("/database")
public class StudentResouceWithSql {
	StudentDao student=new StudentDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudent() {
		return student.getAllStudent();
	}
	
	@GET
	@Path("/studentId")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getParticularStudent(@PathParam("studentId") int studentId) {
		return student.getStudent(studentId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createNewStudent(Student s1) {
		 student.createNewStudent(s1);
	}
	
	

}
