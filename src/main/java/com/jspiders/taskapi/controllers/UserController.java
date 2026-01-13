package com.jspiders.taskapi.controllers;

import com.jspiders.taskapi.data.users.AppUser;
import com.jspiders.taskapi.data.users.AppUserDTO;
import com.jspiders.taskapi.data.users.CreateUserRequest;
import com.jspiders.taskapi.data.users.CreateUserResponse;
import com.jspiders.taskapi.services.AppUserService;
import com.jspiders.taskapi.services.impl.AppUserServiceimpl2;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
//***************************
// This is logger annotation , istead of the LoggerFactory.getLogger(), we can use the annotaion
@Slf4j
//*******************************
@RestController
@RequestMapping("/api/v1/users")
public class UserController
{

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    //immutable

    //AppUserServiceimpl2 : we are using this as we have created new implementation becasue we are using MySQL Database
    private final AppUserServiceimpl2 appUserService;
    @Autowired
    public UserController(AppUserServiceimpl2 appUserService)
    {
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> addUser(@RequestBody @Valid CreateUserRequest createUserRequest)
    {
        //instead of System.out.println use logger
        //and if we are writing with the help of @Slf4j annotaion then write log.info("message").
        //logger.info("this is UserController --> addUser()");
        //System.out.println("this is UserController --> addUser()");
        log.info("inside addUser() createUserRequest : {}",createUserRequest);
        ResponseEntity<CreateUserResponse> response = appUserService.createUser(createUserRequest);
        log.info("inside addUser() : User created");
        return response;
    }

    @PutMapping
    public ResponseEntity<String> updateUser(){
        //instead of System.out.println use logger
        //and if we are writing with the help of @Slf4j annotaion then write log.info("message").
        //log.info("this is UserController --> updateUser()");
        //System.out.println("this is UserController --> updateUser()");
        log.info("updateUser()");
        ResponseEntity<String> response = appUserService.updateUser();
        return response;
    }

    @DeleteMapping
    ResponseEntity<String> deleteUser(String email,String mobile,String password){
        //instead of System.out.println use logger
        //and if we are writing with the help of @Slf4j annotaion then write log.info("message").
        logger.info("this is UserController --> deleteUser()");
        //System.out.println("this is UserController --> deleteUser()");
        ResponseEntity<String> response = appUserService.deleteUser(email,mobile,password);
        return response;
    }

    @GetMapping
    ResponseEntity<List<AppUser>> getAllUsers(){
        //instead of System.out.println use logger
        //and if we are writing with the help of @Slf4j annotaion then write log.info("message").
        logger.info("this is UserController --> getAllUsers()");
        //System.out.println("this is UserController --> getAllUsers()");
        ResponseEntity<List<AppUser>> response = appUserService.getAllUsers();
        return response;
    }
    @GetMapping("/{userId}")
    ResponseEntity<AppUserDTO> getUserById(@PathVariable Long userId){
        //instead of System.out.println use logger
        //and if we are writing with the help of @Slf4j annotaion then write log.info("message").
        logger.info("this is UserController --> getUserById()");
        System.out.println("this is UserController --> getUserById()");
        ResponseEntity<AppUserDTO> response = appUserService.getUserById(userId);
        return response;
    }
}
