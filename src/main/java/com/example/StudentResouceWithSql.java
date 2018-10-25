package com.example;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.student.data.Student;
import dao.StudentDao;

@Path("/database")
public class StudentResouceWithSql {
	StudentDao studentDao=new StudentDao();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudent() {
		return studentDao.getAllStudent();
	}
	
	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getParticularStudent(@PathParam("studentId") int studentId) {
		return studentDao.getStudent(studentId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createNewStudent(Student s1) {
		 studentDao.createNewStudent(s1);
	}
	
	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudent(@PathParam("studentId") int studentId) {
		studentDao.deleteStudent(studentId);
	}
	
	@PUT
	@Path("/{updateStudent}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudentInfo(Student updateStudent) {		
		if(studentDao.getStudent(updateStudent.getId())==null) {
			System.out.println("id doesn't exists");
			studentDao.createNewStudent(updateStudent);
		} else {
			System.out.println("id exists");
			studentDao.updateStudentInfo(updateStudent);
		}	
		
//		return studentDao.getStudent(updateStudent.getId());
		return updateStudent;
	}
	

}
