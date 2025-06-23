package com.libraryproject.dto;

import lombok.Data;

@Data
public class RegisterUserDTO {
    
    private String name;
    private String lastName;
    private String phone;
    private String password;
    private String userType;
    private String address;
    private boolean active;

}
