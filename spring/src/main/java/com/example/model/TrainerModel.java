package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="trainer",uniqueConstraints =@UniqueConstraint(columnNames={"email"}))
public class TrainerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "trainer-uuid")
    @GenericGenerator(name =  "trainer-uuid", strategy = "uuid")
    private String trainerId;
    private String name;
    @Email
    private String email;
    private Integer experience;
    private String shopName;
    @NotNull
    private String password;
    private Boolean active;
    private int bookingCount;
    public TrainerModel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getActive() {
	    return active;
    }

    public void setActive(Boolean active) {
	    this.active = active;
   }
    public TrainerModel(String name, @Email String email, Integer experience, String shopName, @NotNull String password,
           Boolean active) {
       this.name = name;
       this.email = email;
       this.experience = experience;
       this.shopName = shopName;
       this.password = password;
       this.active = active;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public int getBookingCount() {
        return bookingCount;
    }

    public void setBookingCount(int bookingCount) {
        this.bookingCount = bookingCount;
    }
}