package ru.itmo.lessons.lesson7.hw07;

public class Director {
    private String name;
    private int age;

    // Конструкторы
    public Director(String name, int age) {
        setName(name);
        setAge(age);
    }

    // Сеттеры
    public void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Значение name должно быть не менее 2 символов.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 25 || age > 99) {
            throw new IllegalArgumentException("В школе не может быть директором человек " +
                    "возрастом меньше 25 и больше 99 лет.");
        }
        this.age = age;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Методы
    public void announceStart() {
        System.out.println("Директор " + getName() + " объявляет начало занятий.");
    }

    public void announceEnd() {
        System.out.println("Директор " + getName() + " объявляет окончание занятий.");
    }
}
