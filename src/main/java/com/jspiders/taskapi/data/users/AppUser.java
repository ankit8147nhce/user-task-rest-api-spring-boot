package com.jspiders.taskapi.data.users;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;


//Domain Model or Entity
/*
A Domain Model (Entity) is a Java class that represents
a real-world object and its data, usually stored in a database.
*/

@Data
@Entity
@Table(name = "appusers")
public class AppUser {

    @Id
    @Column(name="userid" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Mysql will create and manage ID
    private Long userId;

    @Column(name="name" , nullable = false , length=45)
    private String name;

    @Column(name="email" , nullable = false , unique = true, length=50)
    private String email;

    @Column(name="mobile" , nullable = false , unique = true , length = 10)
    private String mobile;

    @Column(name="password" , nullable = false , length=20)
    private String password;

    @Column(name="isActive" , nullable = false)
    private boolean isActive;
}
