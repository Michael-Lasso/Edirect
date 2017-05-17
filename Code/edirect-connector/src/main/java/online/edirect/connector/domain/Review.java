package online.edirect.connector.domain;

public class Review {
	private int product_id;
	private int user_id;
	private java.sql.Blob description;
	private java.util.Date review_date;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public java.sql.Blob getDescription() {
		return description;
	}

	public void setDescription(java.sql.Blob description) {
		this.description = description;
	}

	public java.util.Date getReview_date() {
		return review_date;
	}

	public void setReview_date(java.util.Date review_date) {
		this.review_date = review_date;
	}
}