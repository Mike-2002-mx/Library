package com.libraryproject.dto;

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
    private Integer totalCopies;
    

}
