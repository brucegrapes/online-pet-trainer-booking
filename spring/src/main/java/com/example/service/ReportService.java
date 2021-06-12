package com.example.service;

import com.example.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.model.ReportModel;
@Service
public class ReportService {
    @Autowired
    private final ReportRepository rRepo;
    @Autowired
    private final AppointmentService as;
    public ReportService(ReportRepository r, AppointmentService a){
        rRepo=r;
        as=a;
    }
    public List<ReportModel> getReportDetails(String id){
        return rRepo.findAll();
    }
    public Boolean addReport(ReportModel data){
        data.setAppointmentDetail(as.getById(data.getApId()));
        rRepo.save(data);
        return true;
    }
    public Boolean updateReport(ReportModel data){
        data.setAppointmentDetail(as.getById(data.getApId()));
        rRepo.save(data);
        return true;
    }

}