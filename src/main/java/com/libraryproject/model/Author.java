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
@Table(name="Authors")
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

}

