package online.edirect.connector.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiscountCode {

	private long discount_id;
	private int category_id;
	private Date start_date;
	private Date end_date;
	private String discount_code;
	private String discount_name;
	private String salt = "no value";

	public long getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(long discount_id) {
		this.discount_id = discount_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getDiscount_name() {
		return discount_name;
	}

	public void setDiscount_name(String discount_name) {
		this.discount_name = discount_name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setStart_date(String start_date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.start_date = df.parse(start_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public void setEnd_date(String end_date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.end_date = df.parse(end_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDiscount_code() {
		return discount_code;
	}

	public void setDiscount_code(String discount_code) {
		this.discount_code = discount_code;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}