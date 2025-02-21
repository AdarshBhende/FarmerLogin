package com.example.Farmerlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Farmerlogin.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FarmerloginApplication implements CommandLineRunner {

	@Autowired
	private FarmerService farmerService;

	public static void main(String[] args) {
		SpringApplication.run(FarmerloginApplication.class, args);
	}

	@Override
	public void run(String... args) {
		farmerService.fetchFarmerDetails();
	}
}

