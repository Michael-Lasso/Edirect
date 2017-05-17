package online.edirect.connector.domain;

public class Users {
	private int address_id;
	private java.util.Date created_date;
	private java.util.Date updated_date;
	private String company_name;
	private String first_name;
	private String last_name;
	private String password;
	private String salt;
	private String email;

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public java.util.Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(java.util.Date created_date) {
		this.created_date = created_date;
	}

	public java.util.Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(java.util.Date updated_date) {
		this.updated_date = updated_date;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}