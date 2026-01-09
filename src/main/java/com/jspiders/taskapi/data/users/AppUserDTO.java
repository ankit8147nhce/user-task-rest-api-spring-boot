package com.jspiders.taskapi.data.users;

import lombok.Data;


//Domain Model or Entity
/*
A Domain Model (Entity) is a Java class that represents
a real-world object and its data, usually stored in a database.
*/

@Data
public class AppUserDTO {
    private Long userId;
    private String name;
    private String email;
    private String mobile;
    private boolean isActive;
}
