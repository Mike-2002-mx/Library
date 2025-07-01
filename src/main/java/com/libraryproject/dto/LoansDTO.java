package com.libraryproject.dto;

import java.util.Date;


public class LoansDTO {

    private Integer idUser;

    private Integer idBook;

    private Date loanDate;

    private Date estimatedReturnDate;

    private Date realReturnDate;

    private StatusType loanStatus;

    public LoansDTO(){
    }

    public LoansDTO(Integer idUser, Integer idBook, Date loanDate, Date estimatedReturnDate,
    Date realReturnDate, StatusType loanStatus){
        this.idUser=idUser;
        this.idBook=idBook;
        this.loanDate=loanDate;
        this.estimatedReturnDate=estimatedReturnDate;
        this.realReturnDate=realReturnDate;
        this.loanStatus=loanStatus;
    }


    public Integer getIdUser(){
        return idUser;
    }

    public void setIdUser(Integer idUser){
        this.idUser=idUser;
    }

    public Integer getIdBook(){
        return idBook;
    }

    public void setidBook(Integer idBook){
        this.idBook=idBook;
    }

    public Date getLoanDate(){
        return loanDate;
    }

    public void setLoanDate(Date loanDate){
        this.loanDate=loanDate;
    }

    public Date getEstimatedReturnDate(){
        return estimatedReturnDate;
    }

    public void setEstimatedReturnDate(Date estimatedReturnDate){
        this.estimatedReturnDate=estimatedReturnDate;
    }

    public Date getRealReturnDate(){
        return estimatedReturnDate;
    }

    public void setRealReturnDate(Date realReturnDate){
        this.realReturnDate=realReturnDate;
    }

    public StatusType getLoanStatus(){
        return loanStatus;
    }

    public void setLoanStatus(StatusType loanStatus){
        this.loanStatus=loanStatus;
    }

    @Override
    public String toString() {
        return "IdLoan [User=" + idUser + ", Book=" + idBook + ", loanDate=" + loanDate
                + ", estimatedReturnDate=" + estimatedReturnDate + ", realReturnDate=" + realReturnDate + ", loanStatus=" + loanStatus
                + "]";
    }

    public enum StatusType {
        active,
        returned,
        delayed,
        not_returned
    }
}
