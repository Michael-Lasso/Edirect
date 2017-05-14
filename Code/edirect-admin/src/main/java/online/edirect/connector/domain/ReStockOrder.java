package online.edirect.connector.domain;

public class ReStockOrder{
	private String description;
	private java.util.Date order_date;
	private java.util.Date arrive_date;

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public java.util.Date getOrder_date(){
		return order_date;
	}

	public void setOrder_date(java.util.Date order_date){
		this.order_date=order_date;
	}

	public java.util.Date getArrive_date(){
		return arrive_date;
	}

	public void setArrive_date(java.util.Date arrive_date){
		this.arrive_date=arrive_date;
	}
}