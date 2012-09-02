package org.apache.camel.example.cxfrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface CountryService {

	@GET
	@Path(value = "/country/{countryCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCountry(@PathParam("countryCode") String countryCode);

}
