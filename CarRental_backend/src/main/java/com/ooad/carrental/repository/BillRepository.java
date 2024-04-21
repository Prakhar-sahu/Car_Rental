package com.ooad.carrental.repository;

import com.ooad.carrental.model.reservation.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepository extends MongoRepository<Bill,String>{
    
}
