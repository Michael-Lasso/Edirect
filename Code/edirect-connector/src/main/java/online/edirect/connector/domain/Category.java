package online.edirect.connector.domain;

public class Category {

	private long category_id;
	private String category_name;
	private String description;

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "category_id: " + category_id + ", category_name: " + category_name + ", description: " + description;
	}

}
