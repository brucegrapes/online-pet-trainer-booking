package com.example.controller;

import java.util.List;

import com.example.model.BookingModel;
import com.example.model.TrainerModel;
import com.example.service.BookingService;
import com.example.service.TrainerService;
import com.example.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping()
public class BookingController{
    @Autowired
    private final BookingService b;
    @Autowired
    private final UserService u;
    @Autowired
    private final TrainerService t;
    public BookingController(BookingService b,UserService u,TrainerService t){
        this.b=b;
        this.u=u;
        this.t=t;
    }
    @PostMapping(value="/booking")
    public String addBooking(@RequestBody BookingModel data) {
        //TODO: process POST request
        TrainerModel a = t.getByEmail((data.getEmailTrainerDetail()));
        data.setTrainerDetail(t.getByEmail(data.getEmailTrainerDetail()));
        data.setClientDetail(u.get(data.getEmailClientDetail()));
        if(a.getBookingCount()<5){
            a.setBookingCount(a.getBookingCount()+1);
            t.updateTrainer(a);
            return b.addBooking(data);
        }else{
            return "Cannot add more than 5 Pets";
        }
    }

    @GetMapping("/Trainer/booking")
    public List<BookingModel> getAllBooking(){
        return b.getBooking();
    }
    @GetMapping("/Trainer/booking/{email}")
    public List<BookingModel> getBookingByEmail(@PathVariable String email){
        return b.getBookingByEmail(email);
    }
    @GetMapping("/Trainer/booking/{email}/{status}")
    public List<BookingModel> getBookingByEmail2(@PathVariable String email,Boolean status){
        return b.getBookingByEmail2(email, status);
    }
    @DeleteMapping("/booking/{id}")
    public String deleteBooking(@PathVariable String id){
        return b.deleteBooking(id);
    }
    @DeleteMapping("/Trainer/booking/{id}")
    public String deleteBookingB(@PathVariable String id){
        return b.deleteBooking(id);
    }

    @PostMapping("/Trainer/booking")
    public String approveBooking(@RequestBody BookingModel data){
        return b.approveBooking(data);
    }
    @GetMapping(value="/Appointment/{id}")
    public List<BookingModel> viewAppointment(@PathVariable String id) {
        return b.findByClientEmail(id);
    }
}