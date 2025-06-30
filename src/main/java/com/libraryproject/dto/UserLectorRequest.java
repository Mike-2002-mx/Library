package com.libraryproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLectorRequest {
    
    @NotBlank(message = "Name is mandatory field")
    @Size(min = 3, max = 50, message = "name must be between 3 and 50 characters.")
    private String name;

    @NotNull(message = "name cannot be null")
    @Size(min = 3, max = 100, message = "lastname must be between 3 and 100 characters.")
    private String lastName;

    @NotNull(message = "phone cannot be null")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must have exactly 10 digits")
    private String phone;

    @NotNull(message = "name cannot be null")
    @Size(min = 6, max = 255, message = "password must be between 6 and 255 characters.")
    private String password;

    @NotNull(message = "address cannot be null")
    private String address;

}
