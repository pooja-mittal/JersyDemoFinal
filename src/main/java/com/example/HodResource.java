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

import com.service.HodService;
import com.student.data.HodPojo;
@Path("/hod")

public class HodResource {
	
	HodService hodService=new HodService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<HodPojo> getAllHod() {
		return hodService.getHodData();
	}
	
	@PUT
	@Path("/{hodDeptId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HodPojo updateHodInfo(@PathParam("hodDeptId") HodPojo h1) {
		return hodService.updateHod(h1);		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HodPojo addHod(HodPojo newHod) {
		return hodService.addAnotherHod(newHod);
	}
	
	@DELETE
	@Path("/{hodId}")
	public void removeHod(@PathParam("hodId") HodPojo delHod) {
		
		
	}
	
	
}
