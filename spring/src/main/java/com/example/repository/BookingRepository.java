package com.example.repository;
import java.util.List;
import java.util.Optional;

import com.example.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingRepository extends CrudRepository<BookingModel,String> {
    List<BookingModel> findByEmailTrainerDetail(String emailTrainerDetail);
    List<BookingModel> findByEmailClientDetail(String emailClientDetail);
}