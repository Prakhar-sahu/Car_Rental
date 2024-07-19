package com.ooad.carrental.repository;

import java.util.List;
import com.ooad.carrental.model.car.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CarRepository extends MongoRepository<Car,String>{
    public List<Car> findByCarLocationId(String cid);

   @Query("{'licensePlateNumber' : ?0}")
    Car findByLicensePlateNumber(String licensePlateNumber);

    @Transactional
    @Query("{'licensePlateNumber' : ?0}")
    void updateCarStatus(String licensePlateNumber, String carStatus);
}
