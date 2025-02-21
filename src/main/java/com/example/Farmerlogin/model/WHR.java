package com.example.Farmerlogin.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class WHR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long whrNumber;

    private String commodityCode;
    private String season;

    private Double dispatchQty;
    private Integer dispatchBags;
    private Double acceptedQty;
    private Integer acceptedBags;
    private String remark;

    @OneToMany(mappedBy = "whr", cascade = CascadeType.ALL) // Assuming Dispatch has a reference to WHR
    private List<Dispatch> dispatches;

    // Getters and Setters
    public Long getWhrNumber() {
        return whrNumber;
    }

    public void setWhrNumber(Long whrNumber) {
        this.whrNumber = whrNumber;
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

    public Double getDispatchQty() {
        return dispatchQty;
    }

    public void setDispatchQty(Double dispatchQty) {
        this.dispatchQty = dispatchQty;
    }

    public Integer getDispatchBags() {
        return dispatchBags;
    }

    public void setDispatchBags(Integer dispatchBags) {
        this.dispatchBags = dispatchBags;
    }

    public Double getAcceptedQty() {
        return acceptedQty;
    }

    public void setAcceptedQty(Double acceptedQty) {
        this.acceptedQty = acceptedQty;
    }

    public Integer getAcceptedBags() {
        return acceptedBags;
    }

    public void setAcceptedBags(Integer acceptedBags) {
        this.acceptedBags = acceptedBags;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Dispatch> getDispatches() {
        return dispatches;
    }

    public void setDispatches(List<Dispatch> dispatches) {
        this.dispatches = dispatches;
    }
}