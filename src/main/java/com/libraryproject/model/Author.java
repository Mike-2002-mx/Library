package com.libraryproject.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="authors")
public class Author {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, unique = true)
    private Integer idAuthor;

    @Column(nullable=false)
    private String authorName;

    @Column(nullable=false)
    private String surname;
    
    @Column(nullable=false)
    private String nationality;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;

    public Author(Integer idAuthor, String authorName, String surname, String nationality, List<Book> books) {
      this.idAuthor = idAuthor;
      this.authorName = authorName;
      this.surname = surname;
      this.nationality = nationality;
      this.books = books;
    }

    public Author() {
    }

    public Integer getIdAuthor() {
      return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
      this.idAuthor = idAuthor;
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

    public List<Book> getBooks() {
      return books;
    }

    public void setBooks(List<Book> books) {
      this.books = books;
    }

    @Override
    public String toString() {
      return "Author [idAuthor=" + idAuthor + ", authorName=" + authorName + ", surname=" + surname + ", nationality="
          + nationality + "]";
    }
}
