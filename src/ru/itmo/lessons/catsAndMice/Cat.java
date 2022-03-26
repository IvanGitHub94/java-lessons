package ru.itmo.lessons.catsAndMice;

import java.util.Arrays;

public class Cat {
    private String name;
    private int speed;
    private int weight;
    private Mouse[] caughtMice = new Mouse[10];

    // Constructors
    public Cat(String name, int speed, int weight) {
        setName(name);
        setSpeed(speed);
        setWeight(weight);
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Значение name должно быть не менее 2 символов");
        }
        this.name = name;
    }

    public void setSpeed(int speed) {
        if (speed < 1) {
            throw new IllegalArgumentException("Скорость не может быть меньше 1.");
        }
        this.speed = speed;
    }

    public void setWeight(int weight) {
        if (weight < 1) {
            throw new IllegalArgumentException("Вес не может быть меньше 1.");
        }
        this.weight = weight;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public Mouse[] getCaughtMice() {
        return caughtMice;
    }


    // Methods
    public void addMouse(Mouse mouse) {
            for (int i = 0; i < caughtMice.length; i++) {
                if (mouse.getSpeed() >= this.speed) {
                    System.out.println("Мышка " + mouse.getName() + " ускользнула!");
                    return;
                }
                if (caughtMice[i] == null) {
                    caughtMice[i] = mouse;
                    System.out.println("Мышка " + mouse.getName() + " поймана!");
                    return;
                }
            }
            System.out.println("Мышей слишком много - больше поймать нельзя.");
    }

    public void addMouse(Mouse... mice){
        for (Mouse m : mice) {
            if (m.getSpeed() >= this.speed) {
                System.out.println("Мышка " + m.getName() + " ускользнула!");
            }
            else addMouse(m);
        }
    }

    public void catConflict(Cat enemy) {
        if (this.weight > enemy.weight) {
            System.out.println("Кот " + this.name + " победил соперника.");
            for (int i = 0; i < enemy.getCaughtMice().length; i++) {
                if (enemy.getCaughtMice()[i] != null) {
                    this.addMouse(enemy.getCaughtMice()[i]);
                    enemy.getCaughtMice()[i] = null;
                }
            }
        }
        else if (this.weight < enemy.weight) {
            System.out.println("Кот " + enemy.name + " победил соперника.");
            for (int i = 0; i < this.getCaughtMice().length; i++) {
                if (this.getCaughtMice()[i] != null) {
                    enemy.addMouse(this.getCaughtMice()[i]);
                    this.getCaughtMice()[i] = null;
                }
            }
        }
        else {
            System.out.println("Вес котов равен - победителей нет.");
            System.out.println("Пока коты были заняты, все мыши разбежались.");
            Arrays.fill(this.caughtMice, null);
            Arrays.fill(enemy.caughtMice, null);
        }
    }
}
