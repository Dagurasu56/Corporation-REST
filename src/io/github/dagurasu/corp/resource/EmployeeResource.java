package io.github.dagurasu.corp.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.github.dagurasu.corp.controller.EmployeeController;
import io.github.dagurasu.corp.model.Employee;

@Path("/employee")
public class EmployeeResource {

	@GET
	@Path("/listAll")
	@Produces("application/json")
	public ArrayList<Employee> listAll() {
		return new EmployeeController().listAll();
	}

}
