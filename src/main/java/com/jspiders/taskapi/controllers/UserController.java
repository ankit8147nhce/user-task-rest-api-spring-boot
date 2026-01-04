package com.jspiders.taskapi.controllers;

import com.jspiders.taskapi.data.users.AppUser;
import com.jspiders.taskapi.data.users.CreateUserRequest;
import com.jspiders.taskapi.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController
{
    //immutable
    private final AppUserService appUserService;
    @Autowired
    public UserController(AppUserService appUserService)
    {
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody CreateUserRequest createUserRequest)
    {
        System.out.println("this is UserController --> addUser()");
        ResponseEntity<String> response = appUserService.createUser(createUserRequest);
        return response;
    }

    @PutMapping
    public ResponseEntity<String> updateUser(){
        System.out.println("this is UserController --> updateUser()");
        ResponseEntity<String> response = appUserService.updateUser();
        return response;
    }

    @DeleteMapping
    ResponseEntity<String> deleteUser(String email,String mobile,String password){
        System.out.println("this is UserController --> deleteUser()");
        ResponseEntity<String> response = appUserService.deleteUser(email,mobile,password);
        return response;
    }

    @GetMapping
    ResponseEntity<List<AppUser>> getAllUsers(){
        System.out.println("this is UserController --> getAllUsers()");
        ResponseEntity<List<AppUser>> response = appUserService.getAllUsers();
        return response;
    }
    @GetMapping("/{userId}")
    ResponseEntity<AppUser> getUserById(@PathVariable Long userId){
        System.out.println("this is UserController --> getUserById()");
        ResponseEntity<AppUser> response = appUserService.getUserById(userId);
        return response;
    }
}
