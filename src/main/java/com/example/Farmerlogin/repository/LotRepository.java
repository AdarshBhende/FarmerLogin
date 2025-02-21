package com.example.Farmerlogin.repository;

import com.example.Farmerlogin.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LotRepository extends JpaRepository<Lot, Long> {

    @Query("SELECT SUM(CASE WHEN l.lotStatus = 'C' THEN l.lotValue ELSE 0 END) - " +
            "SUM(CASE WHEN l.lotStatus = 'R' THEN l.lotValue ELSE 0 END) " +
            "FROM Lot l WHERE l.farmer.farmerId = :farmerId")
    Double getTotalPaymentByFarmer(@Param("farmerId") Long farmerId);

    @Query("SELECT COUNT(l) FROM Lot l WHERE l.farmer.farmerId = :farmerId")
    Long getLotCountByFarmer(@Param("farmerId") Long farmerId);

    @Query("SELECT l FROM Lot l WHERE l.farmer.farmerId = :farmerId AND l.lotStatus IN ('C', 'R')")
    List<Lot> findRejectedAndCompletedLots(@Param("farmerId") Long farmerId);
}