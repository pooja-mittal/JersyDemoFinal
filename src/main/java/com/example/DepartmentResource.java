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

import com.service.DepartmentService;
import com.student.data.Department;

@Path("/department")
public class DepartmentResource {
	
	DepartmentService departmentService=new DepartmentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> getAllDepartment(@Context HttpHeaders httpheaders) {
		return departmentService.getDepartmentData();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{departmentId}")
	public Department getDepartment(@PathParam("departmentId") int departmentId) {
		return departmentService.getParticularDepartment(departmentId);
		
	}
	
	@PUT
	@Path("/{departmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Department updateDepartmentInfo(@PathParam("departmentId") int departmentId, Department department) {
		department.setDepartmentId(departmentId);
		return departmentService.updateDepartment(department);		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Department addDepartment(Department newDepartment) {
		return departmentService.addAnotherDepartment(newDepartment);
	}
	
	@DELETE
	@Path("/{departmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void removeDepartment(@PathParam("departmentId") int departmentId) {
		departmentService.removeDepartment(departmentId);		
	}
	
	
}
