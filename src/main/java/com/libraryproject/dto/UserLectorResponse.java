package com.libraryproject.dto;

import lombok.Data;

@Data
public class UserLectorResponse {
    
    private Integer idLector;
    private String name;
    private String lastName;
    private String phone;
    private String password;
    private String address;
    private String userType;
    private boolean active;
}
