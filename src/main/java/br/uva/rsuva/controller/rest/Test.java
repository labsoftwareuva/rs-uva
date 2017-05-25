package br.uva.rsuva.controller.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/teste")
public class Test {
	 	
		@GET
	    @Produces("application/json")
	    public Response defaultReverser() throws JSONException {
	 
	        StringBuilder sb = new StringBuilder();
	        sb.append("ANKARA");
	 
	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put("original", sb.toString());
	        jsonObject.put("reversed", sb.reverse().toString());
	 
	        String result = "" + jsonObject;
	        return Response.status(200).entity(result).build();
	    }
}
