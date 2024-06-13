package com.app.controller;

import com.app.entity.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;



    //create user
    @PostMapping
    public User createUser(@RequestBody User user){

        //return userService.createUser(user);
        return userRepository.save(user);
    }

    //get all users

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    //getUserById
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        Optional<User> user=userService.getUserById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());

        }
        else {
            return ResponseEntity.notFound().build();
        }


    }

    //update user

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User userDetails){
        try{
            User updatedUser=userService.updateUser(id,userDetails);
            return ResponseEntity.ok(updatedUser);
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }

    }

    //delete user

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
