package com.libraryproject.dto;

public class CollectionsDTO {

    private String collection;

    public CollectionsDTO() {
    }

    public CollectionsDTO(String collection) {
        this.collection = collection;
    }


    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection){
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "Collections [collection=" + collection + "]";
    }
}
