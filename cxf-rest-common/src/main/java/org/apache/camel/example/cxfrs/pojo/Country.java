package org.apache.camel.example.cxfrs.pojo;


/*
 * A Simple POJO 
 * 
 */
public class Country {

	private String countryCode;
	
	private String name;
	
	private String capital;
	
	private String continent;
	
	
	public Country() {
		super();
	}

	public Country(String countryCode, String name, String capital, String continent) {
		this.countryCode = countryCode;
		this.name = name;
		this.capital = capital;
		this.continent = continent;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result
				+ ((continent == null) ? 0 : continent.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (continent == null) {
			if (other.continent != null)
				return false;
		} else if (!continent.equals(other.continent))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}

	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", name=" + name
				+ ", capital=" + capital + ", continent=" + continent + "]";
	}
	
	
}
