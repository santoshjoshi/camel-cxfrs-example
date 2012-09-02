Camel CXF Rest Example with JSON
-----------------------------------------

Thie example demonstrates the use of apache camel to invoke a CXFRS service which returns JSON data
The Client consumes this JSON data and then stores it into a file in json format

##### About The Example

The Example contains 3 modules

1. CXFRS Service Module  
2. CXFRS Commmon Module
3. CXFRS Client Module  


            
            
#####CXFRS Service Module  
 		
This exposes a CXF REST service where a client hits the  
_http://localhost:8080/cxf-rest/services/country/{countrycode}_  
url with some country code to get country details in JSON Format
		
The CountryService creates a rest interface as shown below.  
	
     public interface CountryService {  
     
       @GET  			
       @Path(value = "/country/{countryCode}")
       @Produces(MediaType.APPLICATION_JSON)  
       public Response getCountry(@PathParam("countryCode") String countryCode);
     
    }  

#####CXFRS Commmon Module
		
This module contains POJOs shared by both the client and service.  

1. Country.java  
2. CountryResponse.java 
		
These are shared between both service for populating and client for consumption  

			
#####CXFRS Client Module
		
This module calls a Rest service hosted at some address with a country code like IN, CH GE etc to get country information in JSON format, the json obtained is then marshelled to a country POJO and then save to a text file in some folder
		
This module contains 2 java class  

1. Main.java
2. CountryResource.java
			
*CountyResource.java* exposes an interface to the client 	for communication with the CXF REST Service defined by CXFRS service Module.
		
*Main.java* is basically for executing application.
		
A CXF Rest client is created that hits the service hosted at  
_http://localhost:8080/cxf-rest/services_  
url to fetch country details corrsponding to a country code.
	    
A Camel route is written that  

1. call the cxf service for a list of countries codes 
2. unmarshals the json obtained to pojo and idenifies whether the response is correct
3. marshals the correct response to POJO
4. save the pojo to File.

#####Setting up the Example

1. check out the example

2. Go to *cxf* client module and adjust  
_< jaxrs:client id="restClient" address="http://localhost:8080/cxf-rest/services"_   
in _cxf-services.xml_
		
  the service url to url where you want to deploy you rest application		  
3.   execute 
			mvn clean install
			
4.  deploy the cxf-rest war available in cxf-rest-service module to  your favrioute web container
5.  Hit 
_http://localhost:8080/cxf-rest/services/country/in_  
in your favrioute browser.
		  This will tell whether web context is up or not.
		  
6.  execute mvn exec:exec from client module
			
