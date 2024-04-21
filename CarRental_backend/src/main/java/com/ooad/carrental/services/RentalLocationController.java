package com.ooad.carrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ooad.carrental.model.car.RentalLocation;
import com.ooad.carrental.repository.RentalLocationRepository;

@RestController
public class RentalLocationController {
	@Autowired
	private RentalLocationRepository repository;
	
	// @GetMapping("/createRentalLocation")
	// public String createRentalLocation() {
	// 	RentalLocation crl = new RentalLocation();
	// 	crl.setCentreName("Mysore OOAD Car Rentals");
	// 	crl.setAddress("2nd main road, Lakshmi Nagara, Mysore");
	// 	crl.setPincode("570040");
	// 	repository.save(crl);
	// 	return "Success";
	// }
	@CrossOrigin
	@PostMapping("/createRentalLocation")
	public String createRentalLocation(@RequestBody RentalLocation rl){
		repository.save(rl);
		return "Success";
	}
	@CrossOrigin
	@GetMapping("/getRentalLocation/{pincode}")
	public RentalLocation getRentalLocation(@PathVariable String pincode){
		return repository.findByPincode(pincode);
	}
	@CrossOrigin
	@GetMapping("/getRentalLocationById/{id}")
	public RentalLocation getRentalLocationById(@PathVariable String id){
		return repository.findById(id).orElse(null);
	}
}
