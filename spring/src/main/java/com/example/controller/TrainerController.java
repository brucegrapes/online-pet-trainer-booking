package com.example.controller;

import java.util.List;

import com.example.model.LoginModel;
import com.example.model.TrainerModel;
import com.example.model.UserModel;
import com.example.service.TrainerService;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@CrossOrigin
public class TrainerController {
    private final TrainerService usr;
    @Autowired
    public TrainerController(TrainerService usr){
        this.usr=usr;
    }
    @GetMapping("/Trainer")
    public List<TrainerModel> getTrainers(){
        return usr.getTrainers();
    }
    @PostMapping("/login/Trainer")
    public Boolean getTrainer(@RequestBody LoginModel data){
        TrainerModel t = usr.getByEmail(data.getEmail());
        if(t.getPassword().equals(data.getPassword())){
            return true;
        }
        return false;
    }
}