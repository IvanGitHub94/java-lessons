package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Client {
    private String name;
    private String lastName;
    LocalDate yearBirth;

    // ------------------------------------------------------ Constructors

    public Client(String name, String lastName, LocalDate yearBirth) {
        setName(name);
        setLastName(lastName);
        setYearBirth(yearBirth);
    }

    // ------------------------------------------------------ Setters

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


}
