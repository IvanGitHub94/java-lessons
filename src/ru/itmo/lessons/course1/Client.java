package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Client {
    private String name;
    private String lastName;
    LocalDate yearBirth;
    private Zones wantZone;

    // ------------------------------------------------------ Constructors

    public Client(String name, String lastName, LocalDate yearBirth, Zones wantZone) {
        setName(name);
        setLastName(lastName);
        setYearBirth(yearBirth);
        setWantZone(wantZone);
    }

    // ------------------------------------------------------ Setters


    public void setWantZone(Zones wantZone) {
        this.wantZone = wantZone;
    }

    public void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Имя должно содержать хотя бы 1 символ.");
        }
        this.name = name;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 1) {
            throw new IllegalArgumentException("Фамилия должна содержать хотя бы 1 символ.");
        }
        this.lastName = lastName;
    }

    public void setYearBirth(LocalDate yearBirth) {
        LocalDate now = LocalDate.now();
        long diffYears = ChronoUnit.YEARS.between(yearBirth, now);
            if (diffYears < 18 || diffYears > 90) {
                throw new IllegalArgumentException("Абонемент не может быть продан несовершеннолетним или людям старше 90 лет.");
            }
        this.yearBirth = yearBirth;
    }

    // ------------------------------------------------------ Getters


    public Zones getWantZone() {
        return wantZone;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getYearBirth() {
        return yearBirth;
    }

    // ------------------------------------------------------ Methods


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(lastName, client.lastName) && Objects.equals(yearBirth, client.yearBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, yearBirth);
    }
}
