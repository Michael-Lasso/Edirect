package online.edirect.connector.domain;

public class Image {
	private long image_id;
	private long product_id;
	private String image_name;
	private String url;

	public long getImage_id() {
		return image_id;
	}

	public void setImage_id(long image_id) {
		this.image_id = image_id;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getProduct_id() {
		return product_id;
	}

}