package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Abonement {
    private LocalDate dateRegistration;
    private LocalDate dateRegEnd;
    private LocalTime morning;
    private LocalTime evening;
    private Zones[] zoneType;
    private Client client;
    private AbonTypes abonType;

    // ------------------------------------------------------ Constructors

    public Abonement(Client client, AbonTypes abonType, LocalDate dateRegistration, LocalDate dateRegEnd) {
        setClient(client);
        setAbonType(abonType);
        setDateRegistration(dateRegistration);
        setDateRegEnd(dateRegEnd);
    }


    // ------------------------------------------------------ Setters

    public void setDateRegistration(LocalDate dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public void setDateRegEnd(LocalDate dateRegEnd) {
        this.dateRegEnd = dateRegEnd;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAbonType(AbonTypes abonType) {
        this.abonType = abonType;
    }


    // ------------------------------------------------------ Getters
    // ------------------------------------------------------ Methods
}
