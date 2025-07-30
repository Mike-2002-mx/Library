package com.libraryproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan")
    private int idLoan;

    @Column(name="id_user")
    private int idUser;

    @Column(name="id_book")
    private int idBook;

    @Column(name="loan_date", nullable = false)
    private Date loanDate;
    
    @Column(name="estimatedReturnDate")
    private Date estimatedReturnDate;

    @Column(name="realReturnDate")
    private Date realReturnDate;

    @Enumerated(EnumType.STRING)
    @Column (name = "loanStatus", length = 12, nullable =  false)
    private EnumType loanStatus;

    public enum loanStatus {
        active,
        returned,
        delayed,
        not_returned
    }

}
