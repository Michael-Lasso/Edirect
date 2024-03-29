package online.edirect.model.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StreetIntersection {

	@Id
	@GeneratedValue
	private Long streetid;

	@Column
	private String streetName;
	@Column
	private String longitude;
	@Column
	private String latitude;

	public StreetIntersection() { // jpa only
	}

	public Long getStreetid() {
		return streetid;
	}

	public void setStreetid(Long street_intersection_id) {
		this.streetid = street_intersection_id;
	}

	public StreetIntersection(String street_intersection, String longitude, String latitude) {
		this.streetName = street_intersection;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetintersection) {
		this.streetName = streetintersection;
	}

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

	@Override
	public String toString() {
		return streetid + "\t" + streetName + "\t" + longitude + "\t" + latitude;
	}

}