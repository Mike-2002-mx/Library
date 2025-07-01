package com.libraryproject.dto;

public class PublisherDTO{

    private String namePublisher;

    private String country;

    public PublisherDTO(){

    }
    
    public PublisherDTO(String namePublisher, String country){
        this.namePublisher=namePublisher;
        this.country=country;
    }

    public String getNamePublisher(){
        return namePublisher;
    }

    public void setNamePublisher(String namePublisher){
        this.namePublisher=namePublisher;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    @Override
    public String toString(){
        return "Publisher [namePublisher=" + namePublisher +
        ", country=" + country + "]";
    }
}
