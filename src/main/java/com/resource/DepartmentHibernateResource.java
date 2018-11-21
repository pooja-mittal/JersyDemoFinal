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
import javax.ws.rs.core.MediaType;
import com.pojo.Department;
import com.service.DepartmentHibernateService;

@Path("/department")
public class DepartmentHibernateResource {

	DepartmentHibernateService deptService = new DepartmentHibernateService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{departmentId}")
	public Department getDept(@PathParam("departmentId") int departmentId) {
		return deptService.getParticularDept(departmentId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> listOfDept() {
		return deptService.getListOfDepts();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Department createNewDept(Department newDept) {
		return deptService.addNewDept(newDept);
	}

	@DELETE
	@Path("/{departmentId}")
	public void deleteDept(@PathParam("departmentId") int departmentId) {
		deptService.deleteDept(departmentId);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{updateDepartment}")
	public Department updateDept(Department updateDepartment) {
		return deptService.updateDept(updateDepartment);
	}
}
