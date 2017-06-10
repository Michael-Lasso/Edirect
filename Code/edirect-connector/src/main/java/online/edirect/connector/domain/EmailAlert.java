package online.edirect.connector.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailAlert {
	private long alert_id;
	private String type_id;
	private long property_id;
	private String description;
	private Date created_date;
	private String alert_name;

	public long getAlert_id() {
		return alert_id;
	}

	public void setAlert_id(long alert_id) {
		this.alert_id = alert_id;
	}

	public String getAlert_name() {
		return alert_name;
	}

	public void setAlert_name(String alert_name) {
		this.alert_name = alert_name;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public long getProperty_id() {
		return property_id;
	}

	public void setProperty_id(long property_id) {
		this.property_id = property_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public void setCreated_date(String created_date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate;
		try {
			startDate = df.parse(created_date);
			this.created_date = startDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}