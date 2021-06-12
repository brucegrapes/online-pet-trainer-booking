package com.example.controller;

import com.example.service.TrainerService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.example.model.TrainerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping
public class AdminController {
    @Autowired
    private final TrainerService t;

    public AdminController(TrainerService t){
        this.t=t;
    }
    @GetMapping("/Admin/")
    public List<TrainerModel> getAllTrainers(){
        return t.getTrainers();
    }
    @GetMapping("/Admin/get/{id}")
    public TrainerModel getTrainer(@PathVariable String id){
        return t.getById(id);
    }
    @PostMapping("/Admin/add")
    public Map<String, String> saveUser(@RequestBody TrainerModel data) {
        Map<String,String> m=new HashMap<String,String>();
        m.put("status",t.addTrainer(data));
        return m;
    }
    @PutMapping(value="/Admin/update/{id}")
    public Map<String,String> updateTrainerData(@PathVariable String id, @RequestBody TrainerModel data) {
        //TODO: process PUT request
        Map<String,String> m=new HashMap<String,String>();
        try{
            TrainerModel trainer = t.getById(id);
            data.setTrainerId(trainer.getTrainerId());
            if(trainer!=null){
                trainer=data;
                t.updateTrainer(trainer);
                m.put("status","Updated Successfully");
                return m;
            }else{
                m.put("status", "Not Updated");
                return m;
            }
        }catch(Exception e){
            m.put("status","Not Updated");
            return m;
        }
    }
    @DeleteMapping("/Admin/remove/{id}")
    public Map<String,String> deleteTrainer(@PathVariable String id){
            Map<String,String> m=new HashMap<String,String>();
            if(t.deleteTrainer(id)){
                m.put("status","Deleted Successfully");
                return m;
            }
            m.put("status","Not Successfull");
            return m;
    }

}