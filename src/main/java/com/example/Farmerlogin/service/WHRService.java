package com.example.Farmerlogin.service;



import com.example.Farmerlogin.model.WHR;
import com.example.Farmerlogin.repository.WHRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WHRService {

    private final WHRRepository whrRepository;

    @Autowired
    public WHRService(WHRRepository whrRepository) {
        this.whrRepository = whrRepository;
    }

    public List<WHR> WHRsByFarmerId(Long farmerId) {
        return whrRepository.WHRsByFarmerId(farmerId);
    }
}