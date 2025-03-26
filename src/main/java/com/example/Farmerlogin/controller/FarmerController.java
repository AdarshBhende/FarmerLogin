package com.example.Farmerlogin.controller;

import com.example.Farmerlogin.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @GetMapping("/{farmerId}")
    public void fetchFarmerDetails(@PathVariable Long farmerId) {
        // Call the service method with the farmerId
        farmerService.fetchFarmerDetails(farmerId);
    }
}