package com.libraryproject.model;

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
    @Column(name = "id_book", nullable = false)
    private Integer idBook;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_author", nullable = false)
    @JsonIgnore
    private Author author;

    @ManyToOne
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "id_publisher", nullable = false)
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "id_collection", nullable = false)
    private Collection collection;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column
    private String summary;

    @Column(name = "number_pages")
    private Integer numberPages;

    @Column(name = "total_copies")
    private Integer totalCopies;

}
