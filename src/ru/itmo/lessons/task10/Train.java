package ru.itmo.lessons.task10;

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
    public void newColor(String color) {
        setColor(color);
        System.out.println("Поезд покрашен! Цвет - " + color);
    }
}
