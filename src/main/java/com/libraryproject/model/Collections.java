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

    @Column(name = "collection", length = 50, nullable = false)
    private String collection;

    public Collections() {
    }

    public Collections(int idCollection, String collection) {
        this.idCollection = idCollection;
        this.collection = collection;
    }

    public int getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(int idCollection) {
        this.idCollection = idCollection;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection){
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "Collections [idCollection=" + idCollection +
        ", collection=" + collection + "]";
    }
}
