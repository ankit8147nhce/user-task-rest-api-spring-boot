package com.jspiders.taskapi.data.users;

import lombok.Data;


//DTO class
/*DTO is required to transfer data between layers while hiding
database structure and controlling input/output. */

@Data
public class CreateUserRequest {
    private String name;
    private String email;
    private String mobile;
    private String password;
}
