package com.ooad.carrental.model.car;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Cars")
public class Car {
    @Id
    private String id;
    private String licensePlateNumber;
    public String getId() {
        return id;
    }
    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }
    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public double getMileage() {
        return mileage;
    }
    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public CarStatus getCarStatus() {
        return carStatus;
    }
    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }
    public String getCarLocationId() {
        return carLocationId;
    }
    public void setCarLocationId(String carLocation) {
        this.carLocationId = carLocation;
    }
    public double getCostPerKM() {
        return costPerKM;
    }
    public void setCostPerKM(double costPerKM) {
        this.costPerKM = costPerKM;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    private String make;
    private String model;
    private int yearOfManufacture;
    private double mileage;
    private int numberOfSeats;
    private CarStatus carStatus;
    private String carLocationId;
    private double costPerKM;
    private String image;
}
