package com.example.repository;

import java.util.List;
import java.util.Optional;

import com.example.model.UserModel;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Integer> {
    Optional <UserModel> findByEmail(String email);
    Optional <UserModel> findByMobileNumber(String mobileNumber);
    Optional <UserModel> findById(Integer id);
    List <UserModel> findByRole(String role);
    Boolean existsByEmail(String email);
    Boolean existsByMobileNumber(String mobile_number);
}
