Camel CXF Rest Example with JSON
-----------------------------------------

Thie example demonstrates the use of apache camel to invoke a CXFRS service which returns JSON data
The Client consumes this JSON data and then stores it into a file in json format

About The Example

	The Example contains 3 modules
		a) CXFRS Service Module 
		b) CXFRS Commmon Module
		c) CXFRS Client Module
	
	a) CXFRS Service Module
		
		This exposes a CXF REST service where a client hits the 
			http://localhost:8080/cxf-rest/services/country/{countrycode}
		url with some country code to get country details in JSON Format
		
		The CountryService creates a rest interface as shown below.
		
		public interface CountryService {
	
			@GET
			@Path(value = "/country/{countryCode}")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getCountry(@PathParam("countryCode") String countryCode);
	
		}
		
	b) CXFRS Commmon Module
		
		This module contains a POJO shared by both the client and service.
		This contains 2 POJOs
		i)  Country.java
		ii) CountryResponse.java 
		
		These are shared between both service for populating and client for consumption
			
	c) CXFRS Client Module
		
		This module calls a Rest service hosted at some address with a country code like IN, CH GE etc to get 
		country information in JSON format, the json obtained is then marshelled to a country POJO and then
		save to a text file in some folder
		
		This module contains 2 java class
		i) Main.java
		ii) CountryResource.java
			
		CountyResource.java exposes an interface to the client 	for communication with the CXF REST Service defined by 
		CXFRS service Module.
		
		Main.java is basically for executing application.
		
	    A CXF Rest client is created that hits the service hosted at 
	   		http://localhost:8080/cxf-rest/services 
	    url to fetch country details corrsponding to a country code.
	    
	    A Camel route is written that
	    	a) call the cxf service for a list of countries codes
	    	b) unmarshals the json obtained to pojo and idenifies whether the response is correct
	    	c) marshals the correct response to POJO
	    	d) save the pojo to File.

  Setting up the Example

	  i)   check out the example

     ii)  Go to cxf client module and adjust
		  <jaxrs:client id="restClient" address="http://localhost:8080/cxf-rest/services" in cxf-services.xml
		
		  the service url to url where you want to deploy you rest application		  
	 iii)   execute 
			mvn clean install
			
	 iv)  deploy the cxf-rest war available in cxf-rest-service module to  your favrioute web container
	  v)  hit 
	 	  http://localhost:8080/cxf-rest/services/country/in in your favrouite browser.
		  
		  This will tell whether web context is up or not.
		  
	vi)   execute mvn exec:exec from client module
			
