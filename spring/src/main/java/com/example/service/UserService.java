package com.example.service;

import java.util.List;

import com.example.model.UserModel;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<UserModel> listAll() {
        return (List<UserModel>) repo.findAll();
    }
    public List<UserModel> getTrainers(){
        return repo.findByRole("trainer");
    }
    public Boolean save(UserModel usr) {
        if(repo.existsByEmail(usr.getEmail())){
            return false;
        }
        else{
            repo.save(usr);
            return true;
        }
    }
    public UserModel get(String email){
        return repo.findByEmail(email).get();
    }
    public UserModel get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<UserModel> getUsers(){
        return (List<UserModel>) repo.findAll();
    }
}
