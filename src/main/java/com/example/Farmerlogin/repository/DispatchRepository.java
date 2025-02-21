package com.example.Farmerlogin.repository;

import com.example.Farmerlogin.model.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DispatchRepository extends JpaRepository<Dispatch, Long> {

    // Find Dispatches by their status
    List<Dispatch> findByDispatchStatus(String status);

    // Find Dispatches by Lot ID
    List<Dispatch> findByLot_LotId(Long lotId);

    // Custom query to find Dispatches by Lot's Farmer ID
    @Query("SELECT d FROM Dispatch d WHERE d.lot.farmer.farmerId = :farmerId")
    List<Dispatch> findByFarmerId(@Param("farmerId") Long farmerId);
}

