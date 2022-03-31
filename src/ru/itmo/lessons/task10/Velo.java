package ru.itmo.lessons.task10;

import java.util.Objects;
import java.util.Scanner;

public class Velo extends Transport implements Repair, ColorChange {
    private String type;

    // ----------------------------------------- Constructors
    public Velo(String color, String brandName, int state) {
        super(color, brandName, state);
    }

    // ----------------------------------------- Setters
    public void setType(String type) {
        if (type == null || type.length() < 2) {
            throw new IllegalArgumentException("Значение type должно быть не менее 2 символов.");
        }
        this.type = type;
    }

    // ----------------------------------------- Getters
    public String getType() {
        return type;
    }

    // ----------------------------------------- Methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Velo velo = (Velo) o;
        return super.getState() == velo.getState() && Objects.equals(super.getColor(), velo.getColor())
                && Objects.equals(super.getBrandName(), velo.getBrandName())
                && Objects.equals(this.getType(), velo.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public void doRepair() {
        if (this.getState() == 10) {
            System.out.println("Велосипед не нуждается в ремонте.");
        }
        else {
            System.out.println("Ремонт произведен. " +
                    "(Состояние велосипеда изменено с " +
                    this.getState() +
                    " до " + (this.getState() + 1) + ").");
        super.setState(this.getState() + 1);
            System.out.println("Рабочие отдыхают.");
            System.out.println("__________");
        }
    }

    @Override
    public void newColor() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите цвет, которым вы хотите окрасить велосипед " + this.getBrandName() + ":");
        setColor(scanner.nextLine());
            System.out.println("Велосипед покрашен! Цвет - " + getColor());
    }
}
