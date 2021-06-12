package com.example.controller;

import com.example.model.AppointmentModel;
import com.example.service.AppointmentService;
import com.example.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
@RequestMapping()
public class AppointmentController {
    @Autowired
    private final AppointmentService appointmentService;
    @Autowired
    private final UserService usr;
    public AppointmentController(AppointmentService appointmentService,UserService usr) {
        this.appointmentService = appointmentService;
        this.usr=usr;
    }
   /* @GetMapping(value="/Appointment/{id}")
    public AppointmentModel viewAppointment(@RequestParam String id) {
        return appointmentService.getById(id);
    }
    */
    @DeleteMapping(value="/Trainer/Appointment/{id}")
    public String deleteAppointment(@RequestParam String id){
        return appointmentService.deleteAppointment(id);
    }
    @PostMapping(value = "/Trainer/Appointment")
    public String addAppointment(@RequestParam AppointmentModel ap){
        ap.setIssuedBy(usr.get(ap.getUserMail()));
        ap.setUserId(usr.get(ap.getUserMail()));
        return appointmentService.addAppointment(ap);
    }
    @PutMapping(value="/Trainer/Appointment/{id}")
    public String updateAppointment(@PathVariable String id, @RequestBody AppointmentModel ap) {
        //TODO: process PUT request
        ap.setIssuedBy(usr.get(ap.getUserMail()));
        ap.setUserId(usr.get(ap.getUserMail()));
        return appointmentService.updateAppointment(ap);
    }
}
