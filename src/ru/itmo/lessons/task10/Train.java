package ru.itmo.lessons.task10;

import java.util.Scanner;

public class Train extends Transport implements ColorChange {
    private int wagons;

    // ----------------------------------------- Constructors
    public Train(String color, String brandName, int state) {
        super(color, brandName, state);
    }

    // ----------------------------------------- Setters
    public void setWagons(int wagons) {
        if (wagons < 0) {
            throw new IllegalArgumentException("Количество вагонов не может быть отрицательным.");
        }
        this.wagons = wagons;
    }

    // ----------------------------------------- Getters
    public int getWagons() {
        return wagons;
    }

    // ----------------------------------------- Methods
    @Override
    public void newColor() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите цвет, которым вы хотите окрасить поезд " + this.getBrandName() + ":");
        setColor(scanner.nextLine());
            System.out.println("Поезд покрашен! Цвет - " + getColor());
    }
}
