package com.example.service;

import com.example.repository.BookingRepository;
import com.example.repository.TrainerRepository;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.model.BookingModel;
import com.example.model.TrainerModel;
@Service
public class BookingService {
    @Autowired
    private final BookingRepository bRepo;
    public BookingService(BookingRepository b){
        this.bRepo= b;
    }
    public List<BookingModel> getBooking(){
        return (List<BookingModel>) bRepo.findAll();
    }
    public List<BookingModel> getBookingByEmail(String trainerEmail){
        return bRepo.findByEmailTrainerDetail(trainerEmail);
    }
    public List<BookingModel> getBookingByEmail2(String trainerEmail,Boolean status){
        List<BookingModel> a = getBookingByEmail(trainerEmail);
        List<BookingModel> temp=new ArrayList<BookingModel>();
        for(BookingModel b : a){
            if((b.getBookingStatus()==status)){
                temp.add(b);
            }
        }
        return temp;
    }
    public String addBooking(BookingModel data){
        bRepo.save(data);
        return new String("Booking Created");
    }
    public String approveBooking(BookingModel data){
        data.setBookingStatus(true);
        bRepo.save(data);
        return new String("Booking Approved");
    }
    public String deleteBooking(String id){
        if(bRepo.existsById(id)){
            bRepo.deleteById(id);
            return new String("Booking  Deleted");
        }else{
            return new String("Unable to Delete");
        }

    }
    public List<BookingModel> findByClientEmail(String email){
        return bRepo.findByEmailClientDetail(email);
    }
}