package com.libraryproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "collections")
public class Collections {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCollection")
    private int idCollection;

    
    @Column(name = "collectionTitle", nullable = false)
    private String collectionTitle;


    public Collections() {
    }

    public Collections(int idCollection, String collectionType) {
        this.idCollection = idCollection;
        this.collectionTitle = collectionType;
    }

    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public String getCollectionTitle() {
        return collectionTitle;
    }

    public void setCollectionTitle(String collectionType) {
        this.collectionTitle = collectionType;
    }

    @Override
    public String toString() {
        return "Collections [idCollection=" + idCollection +
        ", collection=" + collectionTitle + "]"; 

    }
}
