package com.ooad.carrental.model.account;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Users")
public class User extends Account {
    private String licenseNumber;
    private Date licenseExpiryDate;
    @Id
    private String id;
    public String getId() {
        return id;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }
    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }
}
