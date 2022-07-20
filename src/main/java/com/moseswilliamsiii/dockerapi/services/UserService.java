package com.moseswilliamsiii.dockerapi.services;


import Model.User;
import com.moseswilliamsiii.dockerapi.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    private UserRepo userRepo;

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User getUserById(String id){
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("No user by ID: " + id));
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public void deleteById(String id){
        userRepo.deleteById(id);
    }

    public void deleteAll(){
        userRepo.deleteAll();
    }
}
