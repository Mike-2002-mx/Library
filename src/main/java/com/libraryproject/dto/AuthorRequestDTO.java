package com.libraryproject.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class AuthorRequestDTO {

    private String authorName;
    private String lastName;
    private String nationality;

}
