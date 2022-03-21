package ru.itmo.lessons.lesson7.hw07;

public class Director extends People{
    // Конструкторы
    public Director(String name, int age) {
        super(name, age);
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
