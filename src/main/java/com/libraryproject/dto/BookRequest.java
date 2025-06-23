package com.libraryproject.dto;


import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private Integer idAuthor;
    private Integer idGenre;
    private Integer idPublisher;
    private Integer idCollection;
    private Integer publicationYear;
    private String summary;
    private Integer numberPages;
    private Integer totalCopies;

}
