package ru.itmo.lessons.lesson6.hw06;

public class Alpinist {
    private String name; // не менее 3 символов
    private String adress; // не менее 5 символов

    public Alpinist(String name) {
        setName(name);
    }

    // Сеттеры
    public void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Значение name должно быть не менее 3 символов");
        }
        this.name = name;
    }

    public void setAdress(String adress) {
        if (adress == null || adress.length() < 5) {
            throw new IllegalArgumentException("Значение adress должно быть не менее 5 символов");
        }
        this.adress = adress;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }
}
