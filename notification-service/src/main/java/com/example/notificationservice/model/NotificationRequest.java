package com.example.notificationservice.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "notification")
public class NotificationRequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String recipient;
    private String message;

    private String number;

    public String getNumber() {
        return number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public NotificationRequest() {}

    public NotificationRequest(String recipient, String message, String number) {
        this.recipient = recipient;
        this.message = message;
        this.number = number;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
