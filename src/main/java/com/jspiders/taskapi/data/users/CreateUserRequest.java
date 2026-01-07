package com.jspiders.taskapi.data.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


//DTO class
/*DTO is required to transfer data between layers while hiding
database structure and controlling input/output. */

@Data
public class CreateUserRequest {

    @Length(min = 3, max = 45 , message = "Name should be min-3 char and max - 45 char only")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Length(min = 10 , max = 10 , message = "Mobile number should be 10-digits only")
    @NotBlank(message = "Mobile number cannot be blank")
    private String mobile;

    @Length(min = 6 , max = 10 , message = "Password should be min-6 char and max-15 char only")
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
