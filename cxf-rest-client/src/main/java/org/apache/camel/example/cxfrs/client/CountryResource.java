package org.apache.camel.example.cxfrs.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface CountryResource {


	@GET
	@Path(value = "/country/{countryCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCountryInfo(@PathParam("countryCode") String countryCode);
	
}
