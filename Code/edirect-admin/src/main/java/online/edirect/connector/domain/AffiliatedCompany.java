package online.edirect.connector.domain;

public class AffiliatedCompany{
	private int address_id;
	private int discount_id;
	private java.util.Date start_affiliated_date;
	private java.util.Date end_affiliated_date;
	private String name;
	private String email;

	public int getAddress_id(){
		return address_id;
	}

	public void setAddress_id(int address_id){
		this.address_id=address_id;
	}

	public int getDiscount_id(){
		return discount_id;
	}

	public void setDiscount_id(int discount_id){
		this.discount_id=discount_id;
	}

	public java.util.Date getStart_affiliated_date(){
		return start_affiliated_date;
	}

	public void setStart_affiliated_date(java.util.Date start_affiliated_date){
		this.start_affiliated_date=start_affiliated_date;
	}

	public java.util.Date getEnd_affiliated_date(){
		return end_affiliated_date;
	}

	public void setEnd_affiliated_date(java.util.Date end_affiliated_date){
		this.end_affiliated_date=end_affiliated_date;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email=email;
	}
}