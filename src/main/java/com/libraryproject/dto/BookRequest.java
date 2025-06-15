package com.libraryproject.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookRequest {
    
    private Integer idCollection;
    private Integer idAuthor;
    private Integer idGenre;
    private Integer idPublisher;
    private String title;
    private Integer publicationYear;
    private String summary;
    private Integer numberPages;
    private String bookStatus;
    private LocalDateTime acquisitionDate;

}
