package com.resource;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.pojo.StudentWithDepartment;
import com.service.StdntjoinDeptService;

@Path("/join")
public class StdntWithDeptResource {

	StdntjoinDeptService joinService = new StdntjoinDeptService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentWithDepartment> getJoinedList() {
		return joinService.getStudentDeptList();
	}
}
