 
== Camel CXF Rest Example with JSON ==

-----------------------------------------


This example demonstrates the use of apache camel to invoke a CXFRS service which returns JSON data
The Client consumes this JSON data and then stores it into a file in json format

 '''About The Example'''

The Example contains 3 modules

# CXF Rest Service Module
# CXF Rest Commmon Module
# CXF Rest Client Module
 
==== 1) CXF Rest Service Module ====


   This exposes a CXF REST service where a client hits the 
	<blockquote>''http://localhost:8080/cxf-rest/services/country/{countrycode}''</blockquote>
  url with some country code to get country details in JSON Format
  
  The CountryService creates a rest interface as shown below.
   
	<code>  public interface CountryService {
	
			@GET
			@Path(value = "/country/{countryCode}")
			@Produces(MediaType.APPLICATION_JSON)
			public Response getCountry(@PathParam("countryCode") String countryCode);
	
		}</code>
		 
==== 2) CXFRS Commmon Module ====
 
		This module contains a POJO shared by both the client and service.
			# Country.java
			# CountryResponse.java


		These are shared between both service for populating and client for consumption 
==== 3) CXFRS Client Module ====
 
		This module calls a Rest service hosted at some address with a country code like IN, CH GE etc to get 
		country information in JSON format, the json obtained is then marshelled to a country POJO and then
		save to a text file in some folder
		
		This module contains 2 java class


# Main.java
# CountryResource.java
			
		CountyResource.java exposes an interface to the client 	for communication with the CXF REST Service defined by 
		CXFRS service Module.
		
		Main.java is basically for executing application.
		
	    A CXF Rest client is created that hits the service hosted at 
	   		http://localhost:8080/cxf-rest/services 
	    url to fetch country details corrsponding to a country code.
	    
	    A Camel route is written that
	    	
			# call the cxf service for a list of countries codes
			# unmarshals the json obtained to pojo and idenifies whether the response is correct
			# marshals the correct response to POJO
			# save the pojo to File.


b) Setting up the Example

	
		# check out the example
		# Go to cxf client module and adjust
		# execute 			
			mvn clean install
		# deploy the cxf-rest war available in cxf-rest-service module to  your favrioute web container
		# hit 	 	  
			http://localhost:8080/cxf-rest/services/country/in in your favrouite browser. 		  		  
			This will tell whether web context is up or not.
		# execute mvn exec:exec from client module
 