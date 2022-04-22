package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Abonement {
    private final LocalDate dateRegistration = LocalDate.now();
    private final LocalTime morning = LocalTime.of(8, 0);
    private LocalDate dateRegEnd;

    // Данные приватные переменные не должны изменяться вне класса,
    // поэтому их сеттеры так же приватные и вызыватся могут
    // только после соответствующих проверок на тип абонемента в сеттере setAbonType
    private LocalTime evening;
    private Zones[] zoneTypeOneDay = new Zones[] {Zones.POOL, Zones.GUM};
    private Zones[] zoneTypeEveryDay = new Zones[] {Zones.GUM, Zones.GROUPS};
    private Zones[] zoneTypeFull = new Zones[] {Zones.GUM, Zones.POOL, Zones.GROUPS};
    /////////////////////////////////////////////////////////////////////////////////

    private Client client;
    private AbonTypes abonType;

// ------------------------------------------------------ Constructors

    public Abonement(Client client, AbonTypes abonType, LocalDate dateRegEnd) {
        setClient(client);
        setAbonType(abonType);
        setDateRegEnd(dateRegEnd);
    }

    // ------------------------------------------------------ Setters
    public void setClient(Client client) {
        this.client = client;
    }

    public void setAbonType(AbonTypes abonType) {
        this.abonType = abonType;
        if (abonType.equals(AbonTypes.ONEDAY) || abonType.equals(AbonTypes.FULL)) {
            this.setEvening(LocalTime.of(22, 0));
        }
        else {
            this.setEvening(LocalTime.of(16, 0));
        }
////////////////////////////////////////////////////////////////////////////////////////
        if (abonType.equals(AbonTypes.ONEDAY)) {
            this.setZoneTypeOneDay(zoneTypeOneDay);
        }
        else if (abonType.equals(AbonTypes.EVERYDAY)) {
            this.setZoneTypeEveryDay(zoneTypeEveryDay);
        }
        else {
            this.setZoneTypeFull(zoneTypeFull);
        }
////////////////////////////////////////////////////////////////////////////////////////
    }

    public void setDateRegEnd(LocalDate dateRegEnd) {
        this.dateRegEnd = dateRegEnd;
    }

    ////////////// Приватные сеттеры
    private void setEvening(LocalTime evening) {
        this.evening = evening;
    }

    private void setZoneTypeOneDay(Zones[] zoneTypeOneDay) {
        this.zoneTypeOneDay = zoneTypeOneDay;
    }

    private void setZoneTypeEveryDay(Zones[] zoneTypeEveryDay) {
        this.zoneTypeEveryDay = zoneTypeEveryDay;
    }

    private void setZoneTypeFull(Zones[] zoneTypeFull) {
        this.zoneTypeFull = zoneTypeFull;
    }

// ------------------------------------------------------ Getters

    public LocalDate getDateRegEnd() {
        return dateRegEnd;
    }

    public Client getClient() {
        return client;
    }

    public AbonTypes getAbonType() {
        return abonType;
    }

    public LocalDate getDateRegistration() {
        return dateRegistration;
    }

    public LocalTime getMorning() {
        return morning;
    }

    public LocalTime getEvening() {
        return evening;
    }

    public Zones[] getZone() {
        if (abonType.equals(AbonTypes.ONEDAY)) {
            return zoneTypeOneDay;
        }
        else if (abonType.equals(AbonTypes.EVERYDAY)) {
            return zoneTypeEveryDay;
        }
        else {
            return zoneTypeFull;
        }
    }

    public Zones[] getZoneTypeOneDay() {
        return zoneTypeOneDay;
    }

    public Zones[] getZoneTypeEveryDay() {
        return zoneTypeEveryDay;
    }

    public Zones[] getZoneTypeFull() {
        return zoneTypeFull;
    }

    // ------------------------------------------------------ Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonement abonement = (Abonement) o;
        return Objects.equals(dateRegistration, abonement.dateRegistration) && Objects.equals(morning, abonement.morning) && Objects.equals(dateRegEnd, abonement.dateRegEnd) && Objects.equals(evening, abonement.evening) && Objects.equals(client, abonement.client) && abonType == abonement.abonType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateRegistration, morning, dateRegEnd, evening, client, abonType);
    }

    @Override
    public String toString() {
        return "Abonement{" +
                "client= " + client.getName() + " " + client.getLastName() +
                ", dateRegistration=| " + dateRegistration +
                " | , dateRegEnd=| " + dateRegEnd +
                " | , evening=" + evening +
                ", abonType=" + abonType +
                '}';
    }
}
