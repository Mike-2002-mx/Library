package com.libraryproject.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="libraryPenalty")
public class LibraryPenalty {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlibraryPenalty")
    private Integer idlibraryPenalty;
    
    @Column(name = "amountPenalty", nullable = false)
    private BigDecimal amountPenalty;

    @Column(name = "emisionDate", nullable = false)
    private String emisionDate;

    @Column(name = "penaltyDescription", columnDefinition = "TEXT", nullable = false)
    private String penaltyDescription;

    public LibraryPenalty() {
    }

    public LibraryPenalty(Integer idlibraryPenalty, BigDecimal amountPenalty, String emisionDate,
            String penaltyDescription) {
        this.idlibraryPenalty = idlibraryPenalty;
        this.amountPenalty = amountPenalty;
        this.emisionDate = emisionDate;
        this.penaltyDescription = penaltyDescription;
    }

    public Integer getIdlibraryPenalty() {
        return idlibraryPenalty;
    }

    public BigDecimal getAmountPenalty() {
        return amountPenalty;
    }

    public String getEmisionDate() {
        return emisionDate;
    }

    public String getPenaltyDescription() {
        return penaltyDescription;
    }

    public void setIdlibraryPenalty(Integer idlibraryPenalty) {
        this.idlibraryPenalty = idlibraryPenalty;
    }

    public void setAmountPenalty(BigDecimal amountPenalty) {
        this.amountPenalty = amountPenalty;
    }

    public void setEmisionDate(String emisionDate) {
        this.emisionDate = emisionDate;
    }

    public void setPenaltyDescription(String penaltyDescription) {
        this.penaltyDescription = penaltyDescription;
    }

    @Override
    public String toString() {
        return "LibraryPenalty [idlibraryPenalty=" + idlibraryPenalty + ", amountPenalty=" + amountPenalty
                + ", emisionDate=" + emisionDate + ", penaltyDescription=" + penaltyDescription + "]";
    }

}