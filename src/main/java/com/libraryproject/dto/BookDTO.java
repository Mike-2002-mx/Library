package com.libraryproject.dto;

public class BookDTO {

    private Integer collection;

    private String title;

    private Integer author;

    private Integer genre;

    private Integer publisher;

    private int publicationYear;

    private String summary;

    private int numberPages;

    private String bookStatus;

    private String acquisitionDate;

    public BookDTO(Integer collection, String title, Integer author, Integer genre, Integer publisher,
                    int publicationYear, String summary, int numberPages, String bookStatus, String acquisitionDate) {
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

    public BookDTO() {
    }

    public Integer getCollection() {
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public Integer getPublisher() {
        return publisher;
    }

    public void setPublisher(Integer publisher) {
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
        return "Book [collection=" + collection + ", title=" + title + ", author=" + author
                + ", genre=" + genre + ", publisher=" + publisher + ", publicationYear=" + publicationYear
                + ", summary=" + summary + ", numberPages=" + numberPages + ", bookStatus=" + bookStatus
                + ", acquisitionDate=" + acquisitionDate + "]";
    }
}
