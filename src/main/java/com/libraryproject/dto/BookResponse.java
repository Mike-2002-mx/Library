package com.libraryproject.dto;

import java.util.Set;

import lombok.Data;

@Data
public class BookResponse {
    
    private String collectionTitle;
    private String title;
    private Set<String> authorNames;
    private Set<String> genreTitles;
    private String publisherTitle;
    private Integer publicationYear;
    private String summary;
    private Integer numberPages;
    private Integer totalCopies;
    

}
