package com.jspiders.taskapi.services.impl;

import com.jspiders.taskapi.data.users.AppUser;
import com.jspiders.taskapi.data.users.AppUserDTO;
import com.jspiders.taskapi.data.users.CreateUserRequest;
import com.jspiders.taskapi.data.users.CreateUserResponse;
import com.jspiders.taskapi.error.InvalidEmailException;
import com.jspiders.taskapi.error.InvalidMobileException;
import com.jspiders.taskapi.error.InvalidNameException;
import com.jspiders.taskapi.error.InvalidPasswordException;
import com.jspiders.taskapi.services.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.*;

//@Component
@Service
@Slf4j
public class AppUserServiceimpl implements AppUserService
{

    private static Map<Long,AppUser> userDb = new HashMap();
    @Override
    public ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest)
    {

        log.info("inside createUser() {}",createUserRequest);

        //1. execute business logic

        //2. perfrom db operations (CRUD)
        Long userId = saveUser(createUserRequest);

        //3. build response object
        CreateUserResponse response = new CreateUserResponse();
        response.setMessage("User Created");
        response.setUserId(userId);
        //System.out.println("this is AppUserServiceImpl --> createUser()");


        //*********************
        //validation calls : This is not required as we dont want manual validation, instead we awant Bean validation by Spring Boot FrameWork
        //*********************

//        validateName(createUserRequest);
//        validateEmail(createUserRequest);
//        validateMobile(createUserRequest);
//        validatePassword(createUserRequest);

        //*********************
        //Validation calls ends
        //*********************

        //logics

//        ResponseEntity<String> response = ResponseEntity.ok("User created ");
//        return response;
        log.info("inside createUser() : User created");

        //4. return response object
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
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
        //System.out.println("this is AppUserServiceImpl --> getAllUsers()");

        //database ops(GET all users from db
        Collection<AppUser> values = userDb.values();
        List<AppUser> users = new ArrayList<>(values);


        //business logics(ReMOVE Password DATA from Response


        //build the response


        //return the response object
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }

    @Override
    public ResponseEntity<AppUserDTO> getUserById(Long userId)
    {
        //System.out.println("this is AppUserServiceImpl --> getUserById()");

        log.info("inside getUserById()");

        //1. execute business logic

        //2. perform db operation
        AppUser appUser = userDb.get(userId);

        //3. build resonpse object
        AppUserDTO response = new AppUserDTO();
        response.setName(appUser.getName());
        response.setEmail(appUser.getEmail());
        response.setMobile(appUser.getMobile());
        response.setActive(appUser.isActive());
        response.setUserId(appUser.getUserId());


        // 4. return response object
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
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

            InvalidPasswordException ex = new InvalidPasswordException("Invalid Password");
            throw ex;
        }
    }

    //*******************************************
    //Validaition Logic ends
    //*******************************************


        private Long saveUser(CreateUserRequest createUserRequest){
        AppUser appUser = new AppUser(); //create a row or record in db
            appUser.setName(createUserRequest.getName());
            appUser.setEmail(createUserRequest.getEmail());
            appUser.setMobile(createUserRequest.getMobile());
            appUser.setPassword(createUserRequest.getPassword());

            Random random = new Random();
            Long userId = random.nextLong();

            appUser.setUserId(userId);
            appUser.setActive(true);
            userDb.put(userId,appUser); //save data to db
            return userId;
        }
}
