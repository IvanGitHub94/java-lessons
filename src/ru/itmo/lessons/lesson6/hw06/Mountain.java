package ru.itmo.lessons.lesson6.hw06;

public class Mountain {
    private String mountainName; // не менее 4 символов
    private String country; // не менее 4 символов
    private int height; // не менее 100 метров

    public Mountain(String mountainName, String country, int height) {
        setMountainName(mountainName);
        setCountry(country);
        setHeight(height);
    }

    // Cеттеры
    public void setMountainName(String mountainName) {
        if (mountainName == null || mountainName.length() < 4) {
            throw new IllegalArgumentException("Значение mountainName должно быть не менее 4 символов");
        }
        this.mountainName = mountainName;
    }

    public void setCountry(String country) {
        if (country == null || country.length() < 4) {
            throw new IllegalArgumentException("Значение country должно быть не менее 4 символов");
        }
        this.country = country;
    }

    public void setHeight(int height) {
        if (height < 100) {
            throw new IllegalArgumentException("Значение height должно быть не менее 100 метров");
        }
        this.height = height;
    }

    // Геттеры
    public String getMountainName() {
        return mountainName;
    }

    public String getCountry() {
        return country;
    }

    public int getHeight() {
        return height;
    }
}
