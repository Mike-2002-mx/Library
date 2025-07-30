package com.libraryproject.dto;


import java.util.Set;

import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private Set<Integer> idAuthors;
    private Set<Integer> idGenres;
    private Integer idPublisher;
    private Integer idCollection;
    private Integer publicationYear;
    private String summary;
    private Integer numberPages;
    private Integer totalCopies;

}
