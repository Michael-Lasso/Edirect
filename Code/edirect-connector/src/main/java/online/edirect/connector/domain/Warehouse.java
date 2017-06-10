package online.edirect.connector.domain;

public class Warehouse {
	private long warehouse_id;
	private String warehouse_name;
	private String street;
	private String city;
	private String state;
	private String country;
	private String phone_number;
	private String zip_code;

	public long getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(long warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public String getWarehouse_name() {
		return warehouse_name;
	}

	public void setWarehouse_name(String warehouse_name) {
		this.warehouse_name = warehouse_name;
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	@Override
	public String toString() {
		return "{Warehouse: { warehouse_id: " + warehouse_id + ", :warehouse_name" + warehouse_name + ", street:"
				+ street + ", city:" + city + ", state:" + state + ", country:" + country + ", phone_number:"
				+ phone_number + ", zip_code:" + zip_code + " } }";
	}

}