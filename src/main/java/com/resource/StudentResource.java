package com.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.pojo.Student;
import com.service.StudentService;

@Path("/studentDao")
public class StudentResource {
	
	StudentService studentService=new StudentService();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Student> getAllStudentData(@Context HttpHeaders httpheaders) {
		return studentService.getAllStudenttData();
	}
	
	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getParticulartStdntInfo(@PathParam("studentId")int studentId) {
		return studentService.getStudenttData(studentId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student addMoreStudent(Student newStdnt) {
		return studentService.addStudenttData(newStdnt);
	}
	
	@PUT
	@Path("/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudentInfo(@PathParam("studentId")int id, Student student) {
		student.setId(id);
		return studentService.updateStudentInfo(student);
	}
	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudent(@PathParam("studentId")int id) {
		studentService.deleteStudent(id);
	}
	
}