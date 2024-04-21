package com.ooad.carrental.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import com.ooad.carrental.model.car.CarStatus;
import com.ooad.carrental.model.reservation.ReservationStatus;
import com.ooad.carrental.model.reservation.VehicleReservation;
import com.ooad.carrental.model.account.User;
import com.ooad.carrental.model.car.Car;
import com.ooad.carrental.repository.BookingRepository;
import com.ooad.carrental.repository.CarRepository;
import com.ooad.carrental.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private CarRepository repository1;
    @Autowired
    private BookingRepository repository2;
    @CrossOrigin
    @PostMapping(value="/carrentals/signup")
    public String registerUser(@RequestBody User newUser) {
        User savedUser = repository.save(newUser);
        return savedUser.getId();
    }
    @CrossOrigin
    @PostMapping(value="/carrentals/login")
    public String loginUser(@RequestBody LoginCredentials loginDetails){
        User user = repository.findByEmail(loginDetails.email);
        if(user != null && user.getPassword().equals(loginDetails.password)){
            return user.getId();
        }
        else
            return null;
    }
    @CrossOrigin
    @GetMapping(value="/carrentals/{lid}")
    public List<Car> getCars(@PathVariable String lid){
        Predicate<Car> condition = car -> !(car.getCarStatus().equals(CarStatus.AVAILABLE));
        List<Car> cars = repository1.findByCarLocationId(lid);
        cars.removeIf(condition);
        return cars;
    }

    @CrossOrigin
    @GetMapping(value = "/carrentals/getName/{uid}")
    public Optional<User> getName(@PathVariable String uid){
        return repository.findById(uid);
    }
    @CrossOrigin
    @PostMapping(value="/carrentals/book")
    public String bookCar(@RequestBody BookingDetails bookingDetails){
		Car car = repository1.findById(bookingDetails.cid).orElse(null);;
        car.setCarStatus(CarStatus.BOOKED);
        repository1.save(car);
        VehicleReservation v = new VehicleReservation();
        v.setStatus(ReservationStatus.CONFIRMED);
        v.setReservationDate(LocalDateTime.now());
        v.setFromDate(bookingDetails.from);
        v.setDueDate(bookingDetails.to);
        v.setAllocatedVehicleId(bookingDetails.cid);
        v.setUserId(bookingDetails.uid);
        repository2.save(v);
        return "Success";
    }

    @CrossOrigin
    @GetMapping(value="/carrentals/mybookings/{uid}")
    public CarBook myBookings(@PathVariable String uid){
        VehicleReservation vr = repository2.findByUserId(uid);
        Car car = repository1.findById(vr.getAllocatedVehicleId()).orElse(null);
        CarBook cb = new CarBook();
        cb.vr = vr;
        cb.car = car;
        return cb;
    }

    @CrossOrigin
    @GetMapping(value="/carrentals/cancel/{uid}")
    public String cancelBooking(@PathVariable String uid){
        VehicleReservation vr = repository2.findByUserId(uid);
        repository2.deleteByUserId(uid);
        Car car = repository1.findById(vr.getAllocatedVehicleId()).orElse(null);;
        car.setCarStatus(CarStatus.AVAILABLE);
        repository1.save(car);
        return "Success";
    }

    @CrossOrigin
    @GetMapping(value="/carrentals/deleteAccount/{uid}")
    public String deleteAccount(@PathVariable String uid){
        repository.deleteById(uid);
        return "Success";
    }
}
