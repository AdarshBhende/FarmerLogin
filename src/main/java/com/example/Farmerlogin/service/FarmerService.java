package com.example.Farmerlogin.service;

import com.example.Farmerlogin.model.Farmer;
import com.example.Farmerlogin.model.Lot;
import com.example.Farmerlogin.model.WHR;
import com.example.Farmerlogin.repository.FarmerRepository;
import com.example.Farmerlogin.repository.LotRepository;
import com.example.Farmerlogin.repository.WHRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class FarmerService {

    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private WHRRepository whrRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    public void fetchFarmerDetails() {
        Scanner scanner = new Scanner(System.in);

        // Get Farmer ID from user
        System.out.print("Enter Farmer ID: ");
        Long farmerId = scanner.nextLong();

        // Fetch total payment & lot count
        Double totalPayment = lotRepository.getTotalPaymentByFarmer(farmerId);
        Long lotCount = lotRepository.getLotCountByFarmer(farmerId);

        System.out.println("\n--- Farmer Details ---");
        System.out.println("Total Payment: ₹" + totalPayment);
        System.out.println("Total Lots: " + lotCount);

        // Fetch rejected and completed lots
        List<Lot> lots = lotRepository.findRejectedAndCompletedLots(farmerId);
        System.out.println("\nRejected and Completed Lots:");
        for (Lot lot : lots) {
            System.out.println("Lot ID: " + lot.getLotId() + ", Status: " + lot.getLotStatus());
        }
        System.out.println("Fetching WHRs for Farmer ID: " + farmerId);
        // Fetch associated WHRs
        List<WHR> whrs = whrRepository.WHRsByFarmerId(farmerId); // Fetch WHRs based on farmer ID
        System.out.println("\nAssociated WHRs:");
        for (WHR whr : whrs) {
            System.out.println("WHR Number: " + whr.getWhrNumber() + ", Commodity: " + whr.getCommodityCode());
        }
        System.out.println("Number of associated WHRs found: " + whrs.size());


        scanner.close();

    }
}