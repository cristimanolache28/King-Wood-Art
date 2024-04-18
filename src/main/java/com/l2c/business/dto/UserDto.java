package com.l2c.business.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String username;
    private String email;
    private String phoneNumber;
    private String city;
    private String password;

}
