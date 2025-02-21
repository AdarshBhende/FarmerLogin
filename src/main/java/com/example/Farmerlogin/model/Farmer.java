package com.example.Farmerlogin.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "farmer")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmerId;

    private String farmerName;
    private String farmerAdhar;
    private Date farmerDob;
    private String farmerVillage;
    private String farmerDistrict;

    // Getters and Setters
    public Long getFarmerId() { return farmerId; }
    public void setFarmerId(Long farmerId) { this.farmerId = farmerId; }

    public String getFarmerName() { return farmerName; }
    public void setFarmerName(String farmerName) { this.farmerName = farmerName; }

    public String getFarmerAdhar() { return farmerAdhar; }
    public void setFarmerAdhar(String farmerAdhar) { this.farmerAdhar = farmerAdhar; }

    public Date getFarmerDob() { return farmerDob; }
    public void setFarmerDob(Date farmerDob) { this.farmerDob = farmerDob; }

    public String getFarmerVillage() { return farmerVillage; }
    public void setFarmerVillage(String farmerVillage) { this.farmerVillage = farmerVillage; }

    public String getFarmerDistrict() { return farmerDistrict; }
    public void setFarmerDistrict(String farmerDistrict) { this.farmerDistrict = farmerDistrict; }
}
