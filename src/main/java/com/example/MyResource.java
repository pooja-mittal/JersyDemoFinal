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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.service.StudentService;
import com.service.StudentServiceMethods;
import com.student.data.StudentPojo;

@Path("/message")
public class MyResource {
	
//	StudentService service=new StudentService();
		
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return "Hello There!";
//    }
	
//	@GET
//    @Produces(MediaType.APPLICATION_XML)
//	public List<StudentPojo> getMessages(@Context HttpHeaders httpheaders) {
//		return service.getAllData();
//	}
	StudentServiceMethods service=new StudentServiceMethods();
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<StudentPojo> getMessages(@Context HttpHeaders httpheaders) {
		return service.getAllStndtData();
	}
	
	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentPojo getParticulartStdntInfo(@PathParam("studentId")int studentId) {
		return service.getStndtData(studentId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StudentPojo addMoreStudent(StudentPojo newStdnt) {
		return service.addStndtData(newStdnt);
	}
	
	@PUT
	@Path("/{studentId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StudentPojo updateStudentInfo(@PathParam("studentId")int id, StudentPojo stndtInfo) {
		stndtInfo.setId(id);
		return service.updateStudentInfo(stndtInfo);
	}
	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudent(@PathParam("studentId")int id) {
		service.removeData(id);
	}
	
}