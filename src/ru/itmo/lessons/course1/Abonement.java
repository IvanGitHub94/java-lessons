package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

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
        if (dateRegEnd.isBefore(dateRegistration)) {
            throw new IllegalArgumentException("Дата окончания абонемента не может быть раньше даты регистрации.");
        }
        this.dateRegEnd = dateRegEnd;
    }

////////////// Приватные сеттеры
    private void setEvening(LocalTime evening) {
        this.evening = evening;
    }

    private void setZoneTypeOneDay(Zones[] zoneTypeOneDay) {
        this.zoneTypeOneDay = zoneTypeOneDay;
        this.fillZone(zoneTypeOneDay);
    }

    private void setZoneTypeEveryDay(Zones[] zoneTypeEveryDay) {
        this.zoneTypeEveryDay = zoneTypeEveryDay;
        this.fillZone(zoneTypeEveryDay);
    }

    private void setZoneTypeFull(Zones[] zoneTypeFull) {
        this.zoneTypeFull = zoneTypeFull;
        this.fillZone(zoneTypeFull);
    }
//////////////// Добавление по 1 человеку в соответствующую зону
    private void fillZone (Zones[] zonesType) {
        for (Zones zones : zonesType) {
            zones.addPeople();
        }
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

// ------------------------------------------------------ Methods

    @Override
    public String toString() {
        return "Abonement{" +
                "zoneTypeOneDay=" + Arrays.toString(zoneTypeOneDay) +
                ", zoneTypeEveryDay=" + Arrays.toString(zoneTypeEveryDay) +
                ", zoneTypeFull=" + Arrays.toString(zoneTypeFull) +
                '}';
    }
}
