package com.rgt.journal.controller;

import com.rgt.journal.entity.UserEntity;
import com.rgt.journal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class publicController {

    @Autowired
    private UserService userService;

    @GetMapping("health-check")
    public  String healthCheck() {
        return  "Ok";
    }

    // Signup(Create new user)
    @PostMapping("signup")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        System.out.print("SignUp Called ");                 // SaveNewUser Use only for Create user
        try {
            System.out.println("Received NewUser: " + userEntity);                 // SaveNewUser Use only for Create user
            userService.saveNewUser(userEntity);                                   // Save New User With Encrypted PassWord
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
