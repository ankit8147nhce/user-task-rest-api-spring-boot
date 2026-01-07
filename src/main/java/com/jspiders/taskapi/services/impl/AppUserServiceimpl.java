package com.jspiders.taskapi.services.impl;

import com.jspiders.taskapi.data.users.AppUser;
import com.jspiders.taskapi.data.users.CreateUserRequest;
import com.jspiders.taskapi.error.InvalidEmailException;
import com.jspiders.taskapi.error.InvalidMobileException;
import com.jspiders.taskapi.error.InvalidNameException;
import com.jspiders.taskapi.error.InvalidPasswordException;
import com.jspiders.taskapi.services.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.List;

//@Component
@Service
public class AppUserServiceimpl implements AppUserService
{
    @Override
    public ResponseEntity<String> createUser(CreateUserRequest createUserRequest)
    {
        System.out.println("this is AppUserServiceImpl --> createUser()");


        //*********************
        //validation calls
        //*********************

        validateName(createUserRequest);
        validateEmail(createUserRequest);
        validateMobile(createUserRequest);
        validatePassword(createUserRequest);

        //*********************
        //Validation calls ends
        //*********************

        //logics

//        ResponseEntity<String> response = ResponseEntity.ok("User created ");
//        return response;
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User created");
    }

    @Override
    public ResponseEntity<String> updateUser() {
        System.out.println("this is AppUserServiceImpl --> updateUser()");

        //logics
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User updated");
    }

    @Override
    public ResponseEntity<String> deleteUser(String email, String mobile, String password)
    {
        System.out.println("this is AppUserServiceImpl --> deleteUser()");

        //logics
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User deleted");
    }

    @Override
    public ResponseEntity<List<AppUser>> getAllUsers()
    {
        System.out.println("this is AppUserServiceImpl --> getAllUsers()");

        //logics
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

    @Override
    public ResponseEntity<AppUser> getUserById(Long userId)
    {
        System.out.println("this is AppUserServiceImpl --> getUserById()");


        
        //logics


        //save data to database

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

    //************************************
    //validation logics
    //************************************

    //Validation logic for Name
    private void validateName(CreateUserRequest createUserRequest)
    {
        //Validation
        if(createUserRequest.getName() != null && createUserRequest.getName().length()<3)
        {
//            IllegalArgumentException ex = new IllegalArgumentException();
//            throw ex;

            InvalidNameException ex = new InvalidNameException("Invalid Name");
            throw ex;
        }
    }

    //Validation logic for Email
    private void validateEmail(CreateUserRequest createUserRequest) {
        //Validation
        if (createUserRequest.getEmail() != null && createUserRequest.getEmail().length() < 8) {
//            IllegalArgumentException ex = new IllegalArgumentException();
//            throw ex;

            InvalidEmailException ex = new InvalidEmailException("Invalid Email");
            throw ex;
        }
    }

        //Validation logic for MobileNumber
        private void validateMobile(CreateUserRequest createUserRequest)
        {
            //Validation
            if(createUserRequest.getMobile() != null && createUserRequest.getMobile().length()<11)
            {
//            IllegalArgumentException ex = new IllegalArgumentException();
//            throw ex;

                InvalidMobileException ex = new InvalidMobileException("Invalid Mobile Number");
                throw ex;
            }
        }

    //Validation logic for Password
    private void validatePassword(CreateUserRequest createUserRequest)
    {
        //Validation
        if(createUserRequest.getPassword() != null && createUserRequest.getPassword().length()<8)
        {
//            IllegalArgumentException ex = new IllegalArgumentException();
//            throw ex;

            InvalidPasswordException ex = new InvalidPasswordException("Invalid Name");
            throw ex;
        }
    }

    //*******************************************
    //Validaition Logic ends
    //*******************************************



    }







}
