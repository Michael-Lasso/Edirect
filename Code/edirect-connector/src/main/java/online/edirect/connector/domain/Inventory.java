package online.edirect.connector.domain;

public class Inventory {
	private int restock_id;
	private java.util.Date entry_date;
	private java.util.Date exit_date;
	private java.util.Date shipped_date;
	private java.util.Date receive_date;
	private java.util.Date deficient_date;
	private java.util.Date return_date;
	private String warehouse_row;
	private String warehouse_column;

	public int getRestock_id() {
		return restock_id;
	}

	public void setRestock_id(int restock_id) {
		this.restock_id = restock_id;
	}

	public java.util.Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(java.util.Date entry_date) {
		this.entry_date = entry_date;
	}

	public java.util.Date getExit_date() {
		return exit_date;
	}

	public void setExit_date(java.util.Date exit_date) {
		this.exit_date = exit_date;
	}

	public java.util.Date getShipped_date() {
		return shipped_date;
	}

	public void setShipped_date(java.util.Date shipped_date) {
		this.shipped_date = shipped_date;
	}

	public java.util.Date getReceive_date() {
		return receive_date;
	}

	public void setReceive_date(java.util.Date receive_date) {
		this.receive_date = receive_date;
	}

	public java.util.Date getDeficient_date() {
		return deficient_date;
	}

	public void setDeficient_date(java.util.Date deficient_date) {
		this.deficient_date = deficient_date;
	}

	public java.util.Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(java.util.Date return_date) {
		this.return_date = return_date;
	}

	public String getWarehouse_row() {
		return warehouse_row;
	}

	public void setWarehouse_row(String warehouse_row) {
		this.warehouse_row = warehouse_row;
	}

	public String getWarehouse_column() {
		return warehouse_column;
	}

	public void setWarehouse_column(String warehouse_column) {
		this.warehouse_column = warehouse_column;
	}
}