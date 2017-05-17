package online.edirect.connector.domain;

public class EmailAlert{
	private String type_id;
	private int property_id;
	private String description;
	private java.util.Date created_date;

	public String getType_id(){
		return type_id;
	}

	public void setType_id(String type_id){
		this.type_id=type_id;
	}

	public int getProperty_id(){
		return property_id;
	}

	public void setProperty_id(int property_id){
		this.property_id=property_id;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public java.util.Date getCreated_date(){
		return created_date;
	}

	public void setCreated_date(java.util.Date created_date){
		this.created_date=created_date;
	}
}