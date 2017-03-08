package com.redrunner.simulator.model;

public class RedRunner {

	private Long red_runner_id;

	private String longitude;

	private String latitude;

	private String streetName;

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
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "RedRunner[Latitude: " + latitude + ", Longitude: " + longitude + ", Timestamp: " + timestamp + "]";
	}

}