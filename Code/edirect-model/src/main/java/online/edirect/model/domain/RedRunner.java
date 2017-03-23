package online.edirect.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RedRunner {

	@Id
	@GeneratedValue
	private Long red_runner_id;
	@Column
	private String longitude;
	@Column
	private String latitude;
	@Column
	private String streetName;
	@Column
	private Long timestamp;

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public Long getRed_runner_id() {
		return red_runner_id;
	}

	public void setRed_runner_id(Long red_runner_id) {
		this.red_runner_id = red_runner_id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public RedRunner() { // jpa only
	}

	public RedRunner(String latitude, String longitude, Long timestamp, String streetName) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
		this.streetName = streetName;
	}

}