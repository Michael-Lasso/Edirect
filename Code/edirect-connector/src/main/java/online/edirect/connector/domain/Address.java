package online.edirect.connector.domain;

public class Address {
	private String street;
	private String city;
	private String state;
	private String country;
	private long phone_number;
	private long zipCode;

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPhone_number() {
		return phone_number;
	}
}
