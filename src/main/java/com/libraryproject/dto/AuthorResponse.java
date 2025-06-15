package com.libraryproject.dto;

import java.util.List;

import com.libraryproject.repository.BookRepository.BookProjection;

import lombok.Data;

@Data
public class AuthorResponse {
    
    private String authorName;
    private String surname;
    private String nationality;
    private List<BookProjection> books;

}
