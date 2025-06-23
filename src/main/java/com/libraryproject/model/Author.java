package com.libraryproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="authors")
public class Author {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Integer idAuthor;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "last_name")
    private String lastName;
    
    @Column
    private String nationality;

}

