package com.example.Farmerlogin.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "lot")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lotId;

    private String commodityCode;
    private String season;
    private double lotQty;
    private int lotBags;
    private double rate;
    private double lotValue;
    private String lotStatus; // 'C', 'P', 'R'
    private String remark;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false) // Foreign key to Farmer
    private Farmer farmer;

    @OneToMany(mappedBy = "lot", cascade = CascadeType.ALL) // One Lot to Many Dispatches
    private List<Dispatch> dispatches; // List of Dispatches associated with this Lot

    // Getters and Setters
    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
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

    public double getLotQty() {
        return lotQty;
    }

    public void setLotQty(double lotQty) {
        this.lotQty = lotQty;
    }

    public int getLotBags() {
        return lotBags;
    }

    public void setLotBags(int lotBags) {
        this.lotBags = lotBags;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getLotValue() {
        return lotValue;
    }

    public void setLotValue(double lotValue) {
        this.lotValue = lotValue;
    }

    public String getLotStatus() {
        return lotStatus;
    }

    public void setLotStatus(String lotStatus) {
        this.lotStatus = lotStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public List<Dispatch> getDispatches() {
        return dispatches;
    }

    public void setDispatches(List<Dispatch> dispatches) {
        this.dispatches = dispatches;
    }
}