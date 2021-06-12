package com.example.repository;

import java.util.Optional;

import com.example.model.TrainerModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrainerRepository extends CrudRepository<TrainerModel,String> {
    Optional <TrainerModel> findByEmail(String email);
}