package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class StudntOfOneDept {
	
	@GET
	public String test() {
		return "hello pooja";
	}

}
