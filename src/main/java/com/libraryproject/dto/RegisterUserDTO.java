package com.libraryproject.dto;

import lombok.Data;

@Data
public class RegisterUserDTO {
    
    private String userName;
    private String firstSurmane;
    private String secondSurname;
    private String email;
    private String password;
    private String phone;
    private String userType;

}
