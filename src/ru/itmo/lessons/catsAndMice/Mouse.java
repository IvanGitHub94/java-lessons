package ru.itmo.lessons.catsAndMice;

public class Mouse {
    private String name;
    private int speed;

    // Constructors
    public Mouse(String name, int speed) {
        setName(name);
        setSpeed(speed);
    }

    // Setters
    public void setSpeed(int speed) {
        if (speed < 1) {
            throw new IllegalArgumentException("Скорость не может быть меньше 1.");
        }
        this.speed = speed;
    }

    public void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Значение name должно быть не менее 2 символов.");
        }
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
