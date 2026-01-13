package com.jspiders.taskapi.services;

import com.jspiders.taskapi.data.users.AppUser;
import com.jspiders.taskapi.data.users.AppUserDTO;
import com.jspiders.taskapi.data.users.CreateUserRequest;
import com.jspiders.taskapi.data.users.CreateUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service : @Service means “this class CONTAINS logic”
//Interface contains NO logic
//Therefore NEVER write @Service annotation for interfaces.
public interface AppUserService {

    ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest);
    ResponseEntity<String> updateUser();
    ResponseEntity<String> deleteUser(String email,String mobile,String password);
    ResponseEntity<List<AppUser>> getAllUsers();
    ResponseEntity<AppUserDTO> getUserById(Long userId);

}
