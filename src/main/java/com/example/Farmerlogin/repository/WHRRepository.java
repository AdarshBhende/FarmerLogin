package com.example.Farmerlogin.repository;
import com.example.Farmerlogin.model.WHR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WHRRepository extends JpaRepository<WHR, Long> {

    // Fetch WHRs for a given Farmer ID based on associated Dispatch records
    @Query("SELECT w FROM WHR w JOIN w.dispatches d JOIN d.lot l WHERE l.farmer.farmerId = :farmerId AND d.dispatchStatus IN ('C', 'R')")
    List<WHR> WHRsByFarmerId(@Param("farmerId") Long farmerId);
}
//    @Query("SELECT w FROM WHR w JOIN w.dispatches d JOIN d.lot l WHERE l.farmer.farmerId = :farmerId AND d.dispatchStatus IN ('C', 'R')")
//    List<WHR> findCompletedAndRejectedWHRsByFarmerId(@Param("farmerId") Long farmerId);
