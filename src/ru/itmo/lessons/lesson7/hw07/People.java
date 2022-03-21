package ru.itmo.lessons.lesson7.hw07;

abstract public class People {
    protected String name;
    protected int age;

    // Конструктор
    public People(String name, int age) {
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
        if (age < 6) {
            throw new IllegalArgumentException("В школе не учатся/не работают люди возрастом меньше 6 лет.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
