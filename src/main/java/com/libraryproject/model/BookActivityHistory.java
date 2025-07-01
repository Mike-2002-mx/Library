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
@Table(name = "bookActivityHistory")
public class BookActivityHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idBookActivityHistory;

    @ManyToOne()
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "idBook")
    private Book book;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ActionHistory actionHistory;

    @Column(nullable = false)
    private Date actionHistoryDate;

    @Column(nullable = false)
    private String historyDescription;

    public BookActivityHistory() {
    }

    public BookActivityHistory(int idBookActivityHistory, User user, Book book, ActionHistory actionHistory,
            Date actionHistoryDate, String historyDescription) {
        this.idBookActivityHistory = idBookActivityHistory;
        this.user = user;
        this.book = book;
        this.actionHistory = actionHistory;
        this.actionHistoryDate = actionHistoryDate;
        this.historyDescription = historyDescription;
    }

    public int getIdBookActivityHistory() {
        return idBookActivityHistory;
    }

    public void setIdBookActivityHistory(int idBookActivityHistory) {
        this.idBookActivityHistory = idBookActivityHistory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ActionHistory getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(ActionHistory actionHistory) {
        this.actionHistory = actionHistory;
    }

    public Date getActionHistoryDate() {
        return actionHistoryDate;
    }

    public void setActionHistoryDate(Date actionHistoryDate) {
        this.actionHistoryDate = actionHistoryDate;
    }

    public String getHistoryDescription() {
        return historyDescription;
    }

    public void setHistoryDescription(String historyDescription) {
        this.historyDescription = historyDescription;
    }

    @Override
    public String toString() {
        return "BookActivityHistory [idBookActivityHistory=" + idBookActivityHistory + ", user=" + user + ", book="
                + book + ", actionHistory=" + actionHistory + ", actionHistoryDate=" + actionHistoryDate
                + ", historyDescription=" + historyDescription + "]";
    }

    public enum ActionHistory{
        loan,
        returned
    }
}
