package com.libraryproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
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

}