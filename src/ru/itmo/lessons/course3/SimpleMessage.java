package ru.itmo.lessons.course3;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SimpleMessage implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;
    private Double IDConnection;

    public SimpleMessage(String sender, String text, Double IDConnection) {
        this.sender = sender;
        this.text = text;
        this.IDConnection = IDConnection;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(){
        dateTime = LocalDateTime.now();
    }

    public void setIDConnection(Double IDConnection) {
        this.IDConnection = IDConnection;
    }

    public Double getIDConnection() {
        return IDConnection;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                ", IDConnection=" + IDConnection +
                '}';
    }

    public static SimpleMessage getMessage(String sender, String text, Double IDConnection){
        return new SimpleMessage(sender, text, IDConnection);
    }
}
