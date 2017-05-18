package br.uva.rsuva.controller.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 
@Path("/hello")
public class RESTfulHelloWorld 
{
	@GET
	@Path("/{user}")
	@Produces("text/html")	
	public Response hello(@PathParam("user") String user)
	{
		String output = "Hello " + user;
		return Response.status(200).entity(output).build();
	}
}