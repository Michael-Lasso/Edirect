package online.edirect.connector.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AffiliatedCompany {

	private long company_id;
	private long discount_id;
	private Date start_affiliated_date;
	private Date end_affiliated_date;
	private String company_name;
	private String street;
	private String city;
	private String state;
	private String country;
	private String phone_number;
	private String zip_code;
	private String company_email;

	public long getCompany_id() {
		return company_id;
	}

	public void setCompany_id(long company_id) {
		this.company_id = company_id;
	}

	public long getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(long discount_id) {
		this.discount_id = discount_id;
	}

	public Date getStart_affiliated_date() {
		return start_affiliated_date;
	}

	public void setStart_affiliated_date(Date start_affiliated_date) {
		this.start_affiliated_date = start_affiliated_date;
	}

	public void setStart_affiliated_date(String start_affiliated_date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.start_affiliated_date = df.parse(start_affiliated_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public java.util.Date getEnd_affiliated_date() {
		return end_affiliated_date;
	}

	public void setEnd_affiliated_date(Date end_affiliated_date) {
		this.end_affiliated_date = end_affiliated_date;
	}

	public void setEnd_affiliated_date(String end_affiliated_date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.end_affiliated_date = df.parse(end_affiliated_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_email() {
		return company_email;
	}

	public void setCompany_email(String company_email) {
		this.company_email = company_email;
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

}