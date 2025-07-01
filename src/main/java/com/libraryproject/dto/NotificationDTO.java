package com.libraryproject.dto;

import java.time.LocalDateTime;

public class NotificationDTO {

    private Integer idUser;

    private TypeNotification typeNotification;

    private String message;

    private LocalDateTime sentdate;

    public NotificationDTO() {
    }

    public NotificationDTO(Integer idUser, TypeNotification typeNotification, String message,
            LocalDateTime sentdate) {
        this.idUser = idUser;
        this.typeNotification = typeNotification;
        this.message = message;
        this.sentdate = sentdate;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public TypeNotification getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(TypeNotification typeNotification) {
        this.typeNotification = typeNotification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getSentdate() {
        return sentdate;
    }

    public void setSentdate(LocalDateTime sentdate) {
        this.sentdate = sentdate;
    }

    public enum TypeNotification {
        loan_due_date,
        fine_pending_payment
    }

    @Override
    public String toString() {
        return "Notification [idUser=" + idUser + ", typeNotification="
                + typeNotification + ", message=" + message + ", sentdate=" + sentdate + "]";
    }
    
}