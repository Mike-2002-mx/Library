package com.libraryproject.dto;

public class AuthorRequestDTO {

    private String authorName;
    private String surname;
    private String nationality;

    public AuthorRequestDTO() {
    }

    public AuthorRequestDTO(String authorName, String surname, String nationality) {
        this.authorName = authorName;
        this.surname = surname;
        this.nationality = nationality;
    }
    
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "AuthorRequestDTO [authorName=" + authorName + ", surname=" + surname + ", nationality=" + nationality
                + "]";
    }
}
