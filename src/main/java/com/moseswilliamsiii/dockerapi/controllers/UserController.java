package com.moseswilliamsiii.dockerapi.controllers;

import Model.User;
import com.moseswilliamsiii.dockerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ok().body(userService.getUsers());
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id){
        return ok().body(userService.getUserById(id));
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping(path = "/users/delete/{id}")
    public void deleteUserById(@PathVariable String id){
        userService.deleteById(id);
    }
    @DeleteMapping(path="/delete")
    public void deleteAll(){
        userService.deleteAll();
    }
}
