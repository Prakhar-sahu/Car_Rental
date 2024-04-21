package com.ooad.carrental.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ooad.carrental.model.car.RentalLocation;

public interface RentalLocationRepository extends MongoRepository<RentalLocation,String> {
	public RentalLocation findByPincode(String pincode);
}