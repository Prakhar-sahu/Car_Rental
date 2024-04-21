package com.ooad.carrental.model.reservation;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Bookings")
public class VehicleReservation {
    @Id
    private String reservationId;
    private String userId;
    public String getReservationId() {
        return reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    public String getUserId() {
        return userId;
    }
    public String getBillId() {
        return billId;
    }
    public void setBillId(String billId) {
        this.billId = billId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public LocalDateTime getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
    public ReservationStatus getStatus() {
        return status;
    }
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public String getPickupLocation() {
        return pickupLocation;
    }
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
    public String getDropLocation() {
        return dropLocation;
    }
    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }
    public double getStartMileage() {
        return startMileage;
    }
    public void setStartMileage(double startMileage) {
        this.startMileage = startMileage;
    }
    public double getEndMileage() {
        return endMileage;
    }
    public void setEndMileage(double endMileage) {
        this.endMileage = endMileage;
    }
    public String getAllocatedVehicleId() {
        return allocatedVehicleId;
    }
    public void setAllocatedVehicleId(String allocatedVehicleId) {
        this.allocatedVehicleId = allocatedVehicleId;
    }
    private LocalDateTime reservationDate;
    private ReservationStatus status;
    private Date fromDate;
    private Date dueDate;
    private Date returnDate;
    private String pickupLocation;
    private String dropLocation;
    private double startMileage;
    private double endMileage;
    private String allocatedVehicleId;
    private String billId;
}
