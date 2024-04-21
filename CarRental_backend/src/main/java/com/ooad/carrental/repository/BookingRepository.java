package com.ooad.carrental.repository;

import com.ooad.carrental.model.reservation.VehicleReservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<VehicleReservation,String>{

    VehicleReservation findByUserId(String uid);
    void deleteByUserId(String uid);
    
}
