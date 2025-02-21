package com.example.Farmerlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.Farmerlogin.service.WHRService;
import com.example.Farmerlogin.model.WHR;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Farmerlogin.repository.WHRRepository;

import java.util.List;

@RestController
@RequestMapping("/api/whr")
public class WHRController {

    @Autowired
    private WHRRepository whrRepository;

    @GetMapping("/farmer/{farmerId}/status")
    public List<WHR> getCompletedAndRejectedWHRs(@PathVariable Long farmerId) {
        return whrRepository.WHRsByFarmerId(farmerId);
    }
}