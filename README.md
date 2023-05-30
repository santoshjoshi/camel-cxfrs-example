# Camel CXF Rest Example with JSON

This example demonstrates the use of Apache Camel to invoke a CXF Restful web service that returns JSON data. The client consumes this JSON data and stores it into a file in JSON format.

## Version Used
- camel: 2.16.0
- CXF Version: 3.1.3

## Modules

The example consists of three modules:

1. **CXFRS Service Module**: 
   - This module exposes a CXF REST service where a client can hit the endpoint `http://localhost:8080/cxf-rest/services/country/{countrycode}` with a country code to retrieve country details in JSON format.
   - The `CountryService` interface defines the REST interface:

     ```java
     public interface CountryService {
   
       @GET
       @Path(value = "/country/{countryCode}")
       @Produces(MediaType.APPLICATION_JSON)
       public Response getCountry(@PathParam("countryCode") String countryCode);
     
     }
     ```

2. **CXFRS Common Module**: 
   - This module contains the POJOs shared by both the client and service modules.
   - It includes `Country.java` and `CountryResponse.java` classes which are populated by the service module and consumed by the client module.

3. **CXFRS Client Module**: 
   - This module calls the REST service hosted by the service module, providing a country code (e.g., IN, CH, GE) to retrieve country information in JSON format.
   - The JSON response is then unmarshalled to a POJO and saved to a file.

## Getting Started

To run this example:

1. Check out the project from GitHub.
2. Adjust the service URL in `cxf-services.xml` file in the CXF client module to the URL where you want to deploy your REST application.
3. Build the project using Maven:

mvn clean install

4. Deploy the `cxf-rest` WAR available in the `cxf-rest-service` module to your favorite web container.
5. Verify that the web context is up by hitting `http://localhost:8080/cxf-rest/services/country/in` in your favorite browser.
6. Execute `mvn exec:exec` from the client module to run the client application.

