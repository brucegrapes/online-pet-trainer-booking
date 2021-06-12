package com.example.service;

import com.example.model.AppointmentModel;
import com.example.model.UserModel;
import com.example.repository.AppointmentRepository;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AppointmentService {
    @Autowired
    private final AppointmentRepository appointmentRepository;
    @Autowired
    private final UserRepository repo;
    public AppointmentService(AppointmentRepository appointmentRepository,UserRepository repo) {
        this.appointmentRepository = appointmentRepository;
        this.repo=repo;
    }

    public String addAppointment(AppointmentModel data) {
        /*if(appointmentRepository.existsById(data.getAppointmentId())){
            return false;
        }*/
        //data.setIssuedBy((UserModel) repo.findByEmail(data.getUserMail()));
        appointmentRepository.save(data);
        return new String("Appointment Created");
    }
    public String updateAppointment(AppointmentModel data){
        appointmentRepository.save(data);
        return "Appointment Update";
    }
    public String deleteAppointment(String id) {
        appointmentRepository.deleteById(id);
        return "Appointment Deleted";
    }   
    public AppointmentModel getById(String id) {
        return appointmentRepository.findById(id).get();
    }
}

