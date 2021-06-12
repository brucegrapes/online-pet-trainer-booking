package com.example.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "appointment")
public class AppointmentModel {
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name =  "system-uuid", strategy = "uuid")
    @Id
    private String appointmentId;
    @OneToOne
    private UserModel userId;
    private LocalDate date;
    @JsonFormat(pattern="HH:mm:ss")
    private Date time;
    @OneToOne
    private UserModel issuedBy;
    private String userMail;
    public String getUserMail(){
        return userMail;
    }
    public void setUserMail(String m){
        this.userMail=m;
    }
    public String getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }
    public UserModel getUserId() {
        return userId;
    }
    public void setUserId(UserModel userId) {
        this.userId = userId;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public UserModel getIssuedBy() {
        return issuedBy;
    }
    public void setIssuedBy(UserModel issuedBy) {
        this.issuedBy = issuedBy;
    }
    public AppointmentModel() {

    }
  /*  public AppointmentModel(String appointmentId, UserModel userId, LocalDate date, UserModel issuedBy) {
        this.appointmentId = appointmentId;
        this.userId = userId;
        this.date = date;
        this.issuedBy = issuedBy;
    }
    */
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
