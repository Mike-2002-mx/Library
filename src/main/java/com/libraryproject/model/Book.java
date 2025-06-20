package com.libraryproject.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook", nullable = false)
    private Integer idBook;

    @ManyToOne
    @JoinColumn(name = "idCollection", nullable = false)
    private Collection collection;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "idAuthor", nullable = false)
    @JsonIgnore
    private Author author;

    @ManyToOne
    @JoinColumn(name = "idGenre", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "idPublisher", nullable = false)
    private Publisher publisher;

    @Column(nullable = false)
    private Integer publicationYear;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private Integer numberPages;

    @Column(nullable = false)
    private String bookStatus;

    @Column(nullable = false)
    private LocalDateTime acquisitionDate;
}
