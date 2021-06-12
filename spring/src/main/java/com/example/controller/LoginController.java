package com.example.controller;

import java.util.*;
import com.example.service.UserService;
import com.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping(path="/login")
public class LoginController {
    private final UserService userService;
    @Autowired
    public LoginController(UserService userService){
        this.userService=userService;
    }
    @PostMapping()
    public Map<String, String> checkUser(@RequestBody LoginModel loginItem) {
        HashMap<String, String> map = new HashMap<>();
        try{
            UserModel a = userService.get(loginItem.getEmail());
            if(a.getPassword().equals(loginItem.getPassword())){
                 map.put("status","true");
                 map.put("role",a.getRole());
                return map;
            }else{
                map.put("status","false");
                return map;
            }
        }catch(NoSuchElementException e){
            map.put("status","false");
            return map;
        }
    }
}
