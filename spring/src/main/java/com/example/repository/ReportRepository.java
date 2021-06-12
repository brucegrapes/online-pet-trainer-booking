package com.example.repository;

import com.example.model.ReportModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportModel,String> {
    
}