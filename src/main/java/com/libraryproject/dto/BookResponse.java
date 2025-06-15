package com.libraryproject.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BookResponse {
    
    private String collectionTitle;
    private String title;
    private String authorName;
    private String genreTitle;
    private String publisherTitle;
    private Integer publicationYear;
    private String summary;
    private Integer numberPages;
    private String bookStatus;
    private LocalDateTime acquisitionDate;
    

}
