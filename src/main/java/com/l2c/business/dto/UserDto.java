package com.l2c.business.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

//    @NotEmpty
//    @Size(min = 3, message = "Post description should have at least four characters.")
    private String firstName;

//    @NotEmpty
//    @Size(min = 3, message = "Post description should have at least four characters.")
    private String secondName;

//    @NotEmpty
//    @Size(min = 3, message = "Post description should have at least four characters.")
    private String username;

//    @NotEmpty
    private String email;

//    @NotEmpty
    private String phoneNumber;

    private String city;

//    @NotEmpty
//    @Size(min = 7, message = "Post description should have at least seven characters.")
    private String password;
    // TODO: add two fields of password and check them

}
