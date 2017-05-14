package online.edirect.connector.domain;

public class DiscountCode{
	private java.util.Date start_date;
	private java.util.Date end_date;
	private String discount_code;
	private String salt;

	public java.util.Date getStart_date(){
		return start_date;
	}

	public void setStart_date(java.util.Date start_date){
		this.start_date=start_date;
	}

	public java.util.Date getEnd_date(){
		return end_date;
	}

	public void setEnd_date(java.util.Date end_date){
		this.end_date=end_date;
	}

	public String getDiscount_code(){
		return discount_code;
	}

	public void setDiscount_code(String discount_code){
		this.discount_code=discount_code;
	}

	public String getSalt(){
		return salt;
	}

	public void setSalt(String salt){
		this.salt=salt;
	}
}