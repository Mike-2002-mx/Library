package com.libraryproject.dto;

import java.util.Date;

public class LoansResponseDTO {
    private int idLoan;
    private Date loanDate;
    private Date estimatedReturnDate;
    private Date realReturnDate;
    private String loanStatus;
    private String bookTitle;
    private String userName;
    
    public LoansResponseDTO() {
    }
    public LoansResponseDTO(int idLoan, Date loanDate, Date estimatedReturnDate, Date realReturnDate, String loanStatus,
            String bookTitle, String userName) {
        this.idLoan = idLoan;
        this.loanDate = loanDate;
        this.estimatedReturnDate = estimatedReturnDate;
        this.realReturnDate = realReturnDate;
        this.loanStatus = loanStatus;
        this.bookTitle = bookTitle;
        this.userName = userName;
    }
    public int getIdLoan() {
        return idLoan;
    }
    public void setIdLoan(int idLoan) {
        this.idLoan = idLoan;
    }
    public Date getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
    public Date getEstimatedReturnDate() {
        return estimatedReturnDate;
    }
    public void setEstimatedReturnDate(Date estimatedReturnDate) {
        this.estimatedReturnDate = estimatedReturnDate;
    }
    public Date getRealReturnDate() {
        return realReturnDate;
    }
    public void setRealReturnDate(Date realReturnDate) {
        this.realReturnDate = realReturnDate;
    }
    public String getLoanStatus() {
        return loanStatus;
    }
    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
