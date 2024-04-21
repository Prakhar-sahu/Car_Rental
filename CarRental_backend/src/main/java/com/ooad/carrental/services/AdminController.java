package com.ooad.carrental.services;

import com.ooad.carrental.model.account.Admin;
import com.ooad.carrental.model.account.User;
import com.ooad.carrental.model.car.Car;
import com.ooad.carrental.model.car.CarStatus;
import com.ooad.carrental.model.reservation.Bill;
import com.ooad.carrental.model.reservation.ReservationStatus;
import com.ooad.carrental.model.reservation.VehicleReservation;
import com.ooad.carrental.repository.AdminRepository;
import com.ooad.carrental.repository.BillRepository;
import com.ooad.carrental.repository.BookingRepository;
import com.ooad.carrental.repository.CarRepository;
import com.ooad.carrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private CarRepository repository1;
    @Autowired
    private BookingRepository repository2;
    @Autowired
    private AdminRepository repository3;
    @Autowired
    private BillRepository repository4;
    

    @GetMapping("/")
    public String admin() {
        return "CarRental_Admin_frontend/src/app.js"; // Assuming your admin frontend's entry point is index.html
    }




    @CrossOrigin
    @PostMapping(value="/carrentals/AdminSignup")
    public String registerAdmin(@RequestBody Admin newAdmin) {
        Admin savedUser = repository3.save(newAdmin);
        return savedUser.getId();
    }

    @CrossOrigin
    @PostMapping(value="/carrentals/admin/login")
    public String loginUser(@RequestBody LoginCredentials loginDetails){
        Admin admin = repository3.findByEmail(loginDetails.email);
        if(admin != null && admin.getPassword().equals(loginDetails.password)){
            return admin.getId();
        }
        else
            return null;
    }

    @CrossOrigin
    @PostMapping(value = "/carrentals/admin/checkOut")
    public String checkOut(@RequestBody LoginCredentials checkOutDetails){
        User user = repository.findByEmail(checkOutDetails.email);
        VehicleReservation vr = repository2.findByUserId(user.getId());
        Car car = repository1.findById(vr.getAllocatedVehicleId()).orElse(null);
        car.setCarStatus(CarStatus.LOANED);
        repository1.save(car);
        vr.setStartMileage(Double.parseDouble(checkOutDetails.password));
        repository2.save(vr);
        return "Success";
    }
    
    @CrossOrigin
    @PostMapping(value="/carrentals/admin/checkIn")
    public Bill checkIn(@RequestBody Form data){
        User user = repository.findByEmail(data.email);
        VehicleReservation vr = repository2.findByUserId(user.getId());
        Car car = repository1.findById(vr.getAllocatedVehicleId()).orElse(null);
        car.setCarStatus(CarStatus.AVAILABLE);
        vr.setReturnDate(data.returnDate);
        vr.setEndMileage(Double.parseDouble(data.endM));
        vr.setStatus(ReservationStatus.COMPLETED);
        Bill bill = new Bill();
        bill.setAddonCost(Double.parseDouble(data.fine));
        bill.setUsageCharges((vr.getEndMileage()-vr.getStartMileage())*(car.getCostPerKM()));
        bill.setTaxes(0.05*(bill.getAddonCost()+bill.getUsageCharges()));
        bill.setTotal(bill.getAddonCost()+bill.getUsageCharges()+bill.getTaxes());
        repository1.save(car);
        repository2.save(vr);
        return repository4.save(bill);
    }
}