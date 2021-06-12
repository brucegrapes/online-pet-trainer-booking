package com.example.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "report")
public class ReportModel {
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name =  "system-uuid", strategy = "uuid")
    @Id
    private String reportId;
    @OneToOne
    private AppointmentModel appointmentDetail;
    private LocalDate date;
    private String days;
    private String report;
    @OneToOne
    private UserModel issuedBy;
    private String apId;
    private String userMail;


    public ReportModel() {
        
    }
    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public AppointmentModel getAppointmentDetail() {
        return appointmentDetail;
    }

    public void setAppointmentDetail(AppointmentModel appointmentDetail) {
        this.appointmentDetail = appointmentDetail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public UserModel getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(UserModel issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getApId() {
        return apId;
    }

    public void setApId(String apId) {
        this.apId = apId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}