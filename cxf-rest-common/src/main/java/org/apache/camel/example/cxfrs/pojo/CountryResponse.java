package org.apache.camel.example.cxfrs.pojo;

import java.util.Map;

public class CountryResponse {

	private Map<String, Country> countries;
	private String message;
	public Map<String, Country> getCountries() {
		return countries;
	}
	public void setCountries(Map<String, Country> countries) {
		this.countries = countries;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "CountryResponse [countries=" + countries + ", message="
				+ message + "]";
	}
	
	
}
