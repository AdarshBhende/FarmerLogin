package com.example.Farmerlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.Farmerlogin.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

@SpringBootApplication
public class FarmerloginApplication implements CommandLineRunner {

	@Autowired
	private FarmerService farmerService;

	public static void main(String[] args) {
		SpringApplication.run(FarmerloginApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Farmer ID: ");
		Long farmerId = scanner.nextLong(); // Get the farmer ID from user input

		// Call the service method with the farmer ID
		farmerService.fetchFarmerDetails(farmerId);

		scanner.close(); // Close the scanner
	}
}
