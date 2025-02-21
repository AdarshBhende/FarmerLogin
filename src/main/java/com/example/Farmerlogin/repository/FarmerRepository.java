package com.example.Farmerlogin.repository;

import com.example.Farmerlogin.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer , Long> {
}
