package com.libraryproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
    private Integer idBook;

    @ManyToOne
    @JoinColumn(name = "idCollection",nullable = false)
    private Collections collection;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "idAuthor", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "idGenre", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "idPublisher" ,nullable = false)
    private Publisher publisher;

    @Column(nullable = false)
    private int publicationYear;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private int numberPages;

    @Column(nullable = false)
    private String bookStatus;

    @Column(nullable = false)
    private String acquisitionDate;

    public Book(Integer idBook, Collections collection, String title, Author author, Genre genre, Publisher publisher,
            int publicationYear, String summary, int numberPages, String bookStatus, String acquisitionDate) {
        this.idBook = idBook;
        this.collection = collection;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.summary = summary;
        this.numberPages = numberPages;
        this.bookStatus = bookStatus;
        this.acquisitionDate = acquisitionDate;
    }

    public Book() {
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Collections getCollection() {
        return collection;
    }

    public void setCollection(Collections collection) {
        this.collection = collection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }
    
    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    @Override
    public String toString() {
        return "Book [idBook=" + idBook + ", idCollection=" + collection + ", title=" + title + ", author=" + author
                + ", idGenre=" + genre + ", idPublisher=" + publisher + ", publicationYear=" + publicationYear
                + ", summary=" + summary + ", numberPages=" + numberPages + ", bookStatus=" + bookStatus
                + ", acquisitionDate=" + acquisitionDate + "]";
    }
}