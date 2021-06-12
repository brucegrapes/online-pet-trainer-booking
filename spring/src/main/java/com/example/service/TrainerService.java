package com.example.service;

import com.example.repository.TrainerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.model.BookingModel;
import com.example.model.TrainerModel;

@Service
public class TrainerService {
    @Autowired
    private final TrainerRepository trRepo;
    @Autowired 
    private final BookingService bRepo;
    public TrainerService(TrainerRepository t,BookingService b){
        trRepo=t;
        bRepo=b;
    }
    public List<TrainerModel> getTrainers(){
        return (List<TrainerModel>) trRepo.findAll();
    }
    public TrainerModel getByEmail(String email){
        return trRepo.findByEmail(email).get();
    }
    public TrainerModel getById(String id){
        return trRepo.findById(id).get();
    }
    public String addTrainer(TrainerModel data){
        try{
            trRepo.save(data);
            return new String("Trainer Created");
            
        }catch(Exception e){
            return new String("Trainer Exists Already");
        }
    }
    public String updateTrainer(TrainerModel data){
        trRepo.save(data);
        return new String("Trainer Updated");
    }   
    public Boolean deleteTrainer(String id){
        if(trRepo.existsById(id)){
            try{
                trRepo.deleteById(id);
                return true;
            }catch(Exception e){
                return false;
            }
        }else{
            return false;
        }
    }
}
