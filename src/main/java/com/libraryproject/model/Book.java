package com.libraryproject.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(
        name = "books_genres",
        joinColumns = @JoinColumn(name="id_book"),
        inverseJoinColumns = @JoinColumn(name =  "id_genre")
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "books_authors",
        joinColumns = @JoinColumn(name="id_book"),
        inverseJoinColumns = @JoinColumn(name =  "id_author")
    )
    private Set<Author> authors = new HashSet<>();

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
