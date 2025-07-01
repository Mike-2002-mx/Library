package com.libraryproject.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLoan")
    private int idLoan;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idBook", nullable = false)
    private Book book;

    @Column(name="loanDate", nullable = false)
    private Date loanDate;

    @Column(name="estimatedReturnDate")
    private Date estimatedReturnDate;

    @Column(name="realReturnDate")
    private Date realReturnDate;

    @Enumerated(EnumType.STRING)
    @Column (name = "loanStatus", length = 12, nullable =  false)
    private StatusType loanStatus;

    public Loans(){
    }

    public Loans(int idLoan, User user, Book book, Date loanDate, Date estimatedReturnDate,
    Date realReturnDate, StatusType loanStatus){
    this.idLoan=idLoan;
        this.user=user;
        this.book=book;
        this.loanDate=loanDate;
        this.estimatedReturnDate=estimatedReturnDate;
        this.realReturnDate=realReturnDate;
        this.loanStatus=loanStatus;
    }

    public int getIdLoan(){
        return idLoan;
    }

    public void setIdLoan(int idLoan){
        this.idLoan=idLoan;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user=user;
    }

    public Book getBook(){
        return book;
    }

    public void setBook(Book book){
        this.book=book;
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
        return "IdLoan [idLoan=" + idLoan + ", User=" + user + ", Book=" + book + ", loanDate=" + loanDate
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
