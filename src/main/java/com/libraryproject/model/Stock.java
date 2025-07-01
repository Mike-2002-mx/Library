package com.libraryproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStock")
    private Integer idStock;

    @Column(name = "bookLocation", length = 200, nullable = false)
    private String bookLocation;

    @Column(name = "totalBooks", nullable = false)
    private Integer totalBooks;

    @Column(name = "availableBooks", nullable = false)
    private Integer availableBooks;

        public void setAvailableBooks(Integer availableBooks) {
        this.availableBooks = availableBooks;
    }
    
    public Stock() {
    }

    public Stock(Integer idStock, String bookLocation, Integer totalBooks, Integer availableBooks) {
        this.idStock = idStock;
        this.bookLocation = bookLocation;
        this.totalBooks = totalBooks;
        this.availableBooks = availableBooks;
    }

    public Integer getIdStock() {
        return idStock;
    }

    public void setIdStock(Integer idStock) {
        this.idStock = idStock;
    }

    public String getBookLocation() {
        return bookLocation;
    }

    public void setBookLocation(String bookLocation) {
        this.bookLocation = bookLocation;
    }

    public Integer getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(Integer totalBooks) {
        this.totalBooks = totalBooks;
    }

    public Integer getAvailableBooks() {
        return availableBooks;
    }

    @Override
    public String toString() {
        return "Stock [idStock=" + idStock + ", bookLocation=" + bookLocation + ", totalBooks=" + totalBooks
                + ", availableBooks=" + availableBooks + "]";
    }
}