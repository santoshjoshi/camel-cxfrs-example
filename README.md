Camel CXF Rest Example with JSON
-----------------------------------------

#####Version Used:
1. camel : 2.16.0
2. CXF Version  3.1.3

Thie example demonstrates the use of apache camel to invoke a CXFRS service which returns JSON data.    
The Client consumes this JSON data and then stores it into a file in json format

##### About The Example

The Example contains 3 modules

1. CXFRS Service Module  
2. CXFRS Common Module
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

#####CXFRS Common Module
		
This module contains POJOs that are shared by both client and service module.  

1. Country.java  
2. CountryResponse.java 
		
service module populates it and client for consumes it.  

			
#####CXFRS Client Module
		
This module calls a REST service hosted by service module with a country code like IN, CH, GE etc to get country information in JSON format, the JSON obtained is then marshalled to a country POJO and then save to a text file.
		
This module contains below java class  

1. Main.java
2. CountryResource.java
			
*CountyResource.java* exposes an interface to the client 	for communication with the CXF REST Service defined by CXFRS service Module.
		
*Main.java* is basically for executing application.
		
A CXF Rest client has been created that hits the service hosted at  
_http://localhost:8080/cxf-rest/services_  
to fetch country details corrosponding to the passed country code.
	    
A Camel route is written that executes as below

1. Calls the cxf service by passing country code and obtains a country in JSON format 
2. unmarshals the JSON obtained to POJO and identifies whether the response is correct
3. marshals the correct response to POJO
4. saves the pojo to File.

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
		
