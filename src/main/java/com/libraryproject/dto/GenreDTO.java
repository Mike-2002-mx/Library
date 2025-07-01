package com.libraryproject.dto;

public class GenreDTO {
    
    private String nameGenre;

    public GenreDTO(String nameGenre){
        this.nameGenre = nameGenre;
    }
    
    public GenreDTO(){

    }

    public void setNameGenre(String nameGenre){
        this.nameGenre = nameGenre;
    }

    public String getNameGenre(){
        return nameGenre;
    }
}