package online.edirect.connector.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deal {
	private long product_id;
	private long deal_id;
	private int category_id;
	private String deal_name;
	private Date start_date;
	private Date end_date;

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(long deal_id) {
		this.deal_id = deal_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getDeal_name() {
		return deal_name;
	}

	public void setDeal_name(String deal_name) {
		this.deal_name = deal_name;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public void setStart_date(String start_date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate;
		try {
			startDate = df.parse(start_date);
			this.start_date = startDate;
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
		Date startDate;
		try {
			startDate = df.parse(end_date);
			this.end_date = startDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}