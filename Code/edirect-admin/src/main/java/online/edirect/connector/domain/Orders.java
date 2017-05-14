package online.edirect.connector.domain;

public class Orders {
	private int user_id;
	private java.util.Date sell_date;
	private double sell_price;
	private java.util.Date receive_date;
	private String discount_code;
	private String salt;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public java.util.Date getSell_date() {
		return sell_date;
	}

	public void setSell_date(java.util.Date sell_date) {
		this.sell_date = sell_date;
	}

	public double getSell_price() {
		return sell_price;
	}

	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}

	public java.util.Date getReceive_date() {
		return receive_date;
	}

	public void setReceive_date(java.util.Date receive_date) {
		this.receive_date = receive_date;
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
}