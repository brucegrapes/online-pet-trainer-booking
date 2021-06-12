package com.example.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "booking-uuid")
    @GenericGenerator(name =  "booking-uuid", strategy = "uuid")
    private String bookingId;
    private String emailTrainerDetail;
    private String emailClientDetail;
    @OneToOne
    private UserModel clientDetail;
    @OneToOne
    private TrainerModel TrainerDetail; 
    private String lawFirmName; 
    private LocalDate date;
    @JsonFormat(pattern="HH:mm:ss")
    private Date time;
    private Integer amount;
    private Boolean bookingStatus;
    public BookingModel(){

    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public UserModel getClientDetail() {
        return clientDetail;
    }

    public void setClientDetail(UserModel clientDetail) {
        this.clientDetail = clientDetail;
    }

    public TrainerModel getTrainerDetail() {
        return TrainerDetail;
    }
    public void setTrainerDetail(TrainerModel trainerDetail) {
        TrainerDetail = trainerDetail;
    }

    public String getLawFirmName() {
        return lawFirmName;
    }

    public void setLawFirmName(String lawFirmName) {
        this.lawFirmName = lawFirmName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer number) {
        amount = number;
    }

    public Boolean getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getEmailClientDetail() {
        return emailClientDetail;
    }

    public void setEmailClientDetail(String emailClientDetail) {
        this.emailClientDetail = emailClientDetail;
    }

    public String getEmailTrainerDetail() {
	    return emailTrainerDetail;
    }

    public void setEmailTrainerDetail(String emailTrainerDetail) {
	    this.emailTrainerDetail = emailTrainerDetail;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}