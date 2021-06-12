package com.example.controller;
import com.example.model.UserModel;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.UserService;
import java.util.*;

@RestController
@RequestMapping(path="/signup")
@CrossOrigin
public class SignupController {
    private final UserService userService;
    @Autowired
    public SignupController(UserService userService){
        this.userService=userService;
    }
    @PostMapping()
    public Map<String, String> saveUser(@RequestBody UserModel user) {
        HashMap<String , String> h = new HashMap<String,String>();
        if(userService.save(user)){
            h.put("status","true");
        }else{
            h.put("status","false");
        }
        return h;
    }
    @GetMapping
    public String test(){
        return "Working";
    }
}
