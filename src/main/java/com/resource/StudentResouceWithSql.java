package com.resource;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.pojo.Student;
import com.service.StudentSqlService;

@Path("/database")
public class StudentResouceWithSql {
	StudentSqlService studentService = new StudentSqlService();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getAllStudent() {
		return studentService.getAll();
	}

	@GET
	@Path("/{studentId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student getParticularStudent(@PathParam("studentId") int studentId) {
		return studentService.getById(studentId);
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student createNewStudent(Student s1) {
		studentService.create(s1);
		return s1;
	}

	@DELETE
	@Path("/{studentId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void deleteStudent(@PathParam("studentId") int studentId) {
		studentService.deleteById(studentId);
	}

	@PUT
	@Path("/{updateStudent}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student updateStudentInfo(Student updateStudent) {
		studentService.update(updateStudent);
		return updateStudent;
	}

}
