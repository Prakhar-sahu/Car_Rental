package com.ooad.carrental.model.car;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="RentalLocations")
public class RentalLocation {
    @Id
    private String locationId;
    private String centreName;
    private String address;
    private String pincode;
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getLocationId() {
		return locationId;
	}
	public String getCentreName() {
		return centreName;
	}
	public String getAddress() {
		return address;
	}
	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
