package com.jspiders.taskapi.services.impl;

import com.jspiders.taskapi.data.users.*;
import com.jspiders.taskapi.error.InvalidEmailException;
import com.jspiders.taskapi.error.InvalidMobileException;
import com.jspiders.taskapi.error.InvalidNameException;
import com.jspiders.taskapi.error.InvalidPasswordException;
import com.jspiders.taskapi.services.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import tools.jackson.databind.ObjectMapper;

import java.util.*;

//@Component or @Service
@Service
@Slf4j
@RequiredArgsConstructor
public class AppUserServiceimpl implements AppUserService
{

    // DB
    private static Map<Long,AppUser> userDb = new HashMap();

    // ObjectMapper to map the dto fields
    private final ObjectMapper mapper;

    //since we are using AppUserRepository interface, hence we need objects here
    private final AppUserRepository appUserRepository;

    //create user api
    @Override
    public ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest)
    {

        log.info("inside createUser() {}",createUserRequest);

        //1. execute business logic

        //2. perfrom db operations (CRUD)
        //Long userId = saveUser(createUserRequest);

        //saving data in actual DataBase(MySql)
        AppUser appUser = mapper.convertValue(createUserRequest, AppUser.class);
        appUser.setActive(true);

        AppUser appUser1 = appUserRepository.save(appUser);
        Long userId = appUser.getUserId();

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


    //update user api
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
        List<AppUser> appUserList = new ArrayList<>(values);
        List<AppUserDTO> appUserDTOList = new ArrayList<>();

        //have defined this ObjectMapper as Global Varibale above and created the object using @RequiredArgsConstructor
        //ObjectMapper mapper = new ObjectMapper();


        //business logics(ReMOVE Password DATA from Response


        //build the response

        //this is manual mapping
//        for(AppUser appUser : appUserList){
//            AppUserDTO appUserDTO = new AppUserDTO();
//
//            appUserDTO.setName(appUser.getName());
//            appUserDTO.setEmail(appUser.getEmail());
//            appUserDTO.setMobile(appUser.getMobile());
//            appUserDTO.setUserId(appUser.getUserId());
//            appUserDTO.setActive(appUser.isActive());
//            appUserDTOList.add(appUserDTO);
//        }

        //lets maps through ObjectMapper

        for(AppUser appUser : appUserList){
            AppUserDTO appUserDTO = mapper.convertValue(appUser, AppUserDTO.class);
            appUserDTOList.add(appUserDTO);
        }


        //return the response object
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(appUserList);
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
        //this is manual process
//        AppUserDTO response = new AppUserDTO();
//        response.setName(appUser.getName());
//        response.setEmail(appUser.getEmail());
//        response.setMobile(appUser.getMobile());
//        response.setActive(appUser.isActive());
//        response.setUserId(appUser.getUserId());

        //lets do it using Spring ObjectMapper class
        //have defined ObjectMapper as Global variable above
        //ObjectMapper mapper = new ObjectMapper();
        AppUserDTO response = mapper.convertValue(appUser, AppUserDTO.class);


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


    //******************************************************
    //Adding data to the userDb table that was created globally using Map
    // private static Map<Long,AppUser> userDb = new HashMap();
    //********************************************************
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
