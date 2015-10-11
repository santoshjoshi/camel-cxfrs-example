package org.apache.camel.example.cxfrs.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.camel.example.cxfrs.CountryService;
import org.apache.camel.example.cxfrs.pojo.Country;
import org.apache.camel.example.cxfrs.pojo.CountryResponse;
import org.apache.commons.lang3.StringUtils;


public class CountryServiceImpl implements CountryService {

	public static final Map<String, Country>  countryMap = new LinkedHashMap<String, Country>();

	static{

		Country india 		= new Country("IN", "India", "New Delhi", "Asia");
		Country australia   = new Country("AU", "Australia", "Canberra", "Australia");
		Country canada		= new Country("CA", "Canada", "Ottawa", "North America");
		Country china 	    = new Country("CH", "China", "Beijing", "Asia");
		Country germany     = new Country("GE", "Germany", "Berlin", "Europe");

		countryMap.put("IN", india);
		countryMap.put("AU", australia);
		countryMap.put("CA", canada);
		countryMap.put("CH", china);
		countryMap.put("GE", germany);
	}

	public Response getCountry(String countryCode) {

		Response response = null;
		Map<String, Country>  countries =  new HashMap<String, Country>();
		CountryResponse countryResponse = new CountryResponse();
		countryResponse.setCountries(countries);

		if(StringUtils.isEmpty(countryCode)){
			countryResponse.setMessage("Country Code Not provided!") ;
			response = Response.ok(countryResponse).status(Status.BAD_REQUEST).build();
		}

		Country country = countryMap.get(countryCode.toUpperCase());
		if(country == null){
			countryResponse.setMessage("No Country Found for country code " + countryCode) ;
			response = Response.ok(countryResponse).status(Status.NOT_FOUND).build();
		}else{

			countryResponse.getCountries().put(countryCode.toUpperCase(), country);
			countryResponse.setMessage("ok");
			response = Response.ok(countryResponse).status(Status.OK).build();
		}

		return response;
	}

	public Response getCountries() {

		CountryResponse countryResponse = new CountryResponse();
		countryResponse.setCountries(countryMap);
		countryResponse.setMessage("ok");
		Response response = Response.ok(countryResponse).status(Status.OK).build();

		return response;
	}
}
