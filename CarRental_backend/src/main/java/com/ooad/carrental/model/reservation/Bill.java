package com.ooad.carrental.model.reservation;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Bills")
public class Bill {
    @Id
    private String billId;
    private String reservationId;
    private double usageCharges;
    private double addonCost;
    private double taxes;
    private double total;
    public String getBillId() {
        return billId;
    }
    public String getReservationId() {
        return reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    public double getUsageCharges() {
        return usageCharges;
    }
    public void setUsageCharges(double usageCharges) {
        this.usageCharges = usageCharges;
    }
    public double getAddonCost() {
        return addonCost;
    }
    public void setAddonCost(double addonCost) {
        this.addonCost = addonCost;
    }
    public double getTaxes() {
        return taxes;
    }
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}
