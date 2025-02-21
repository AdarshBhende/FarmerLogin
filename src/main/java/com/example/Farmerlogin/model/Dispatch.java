package com.example.Farmerlogin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dispatch")
public class Dispatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto-incremented
    private Long dispatchId;

    private String commodityCode;
    private String season;
    private double dispatchQty;
    private int dispatchBags;
    private double dispatchValue;
    private String dispatchStatus; // 'C', 'P', 'R'
    private String remark;

    @ManyToOne
    @JoinColumn(name = "lot_id", nullable = false) // Foreign key to Lot
    private Lot lot; // Reference to Lot

    @ManyToOne
    @JoinColumn(name = "whr_number") // Foreign key to WHR
    private WHR whr; // Reference to WHR

    // Getters and Setters
    public Long getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Long dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getDispatchQty() {
        return dispatchQty;
    }

    public void setDispatchQty(double dispatchQty) {
        this.dispatchQty = dispatchQty;
    }

    public int getDispatchBags() {
        return dispatchBags;
    }

    public void setDispatchBags(int dispatchBags) {
        this.dispatchBags = dispatchBags;
    }

    public double getDispatchValue() {
        return dispatchValue;
    }

    public void setDispatchValue(double dispatchValue) {
        this.dispatchValue = dispatchValue;
    }

    public String getDispatchStatus() {
        return dispatchStatus;
    }

    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Lot getLot() {
        return lot; // Getter for Lot
    }

    public void setLot(Lot lot) {
        this.lot = lot; // Setter for Lot
    }
}