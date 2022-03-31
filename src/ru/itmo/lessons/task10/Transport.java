package ru.itmo.lessons.task10;

import java.util.Objects;

abstract public class Transport {
    private String color;
    private String brandName;
    private int state;

    // ----------------------------------------- Constructors
    public Transport(String color, String brandName, int state) {
        setColor(color);
        setBrandName(brandName);
        setState(state);
    }

    // ----------------------------------------- Setters
    public void setColor(String color) {
        if (color == null || color.length() < 2) {
            throw new IllegalArgumentException("Значение color должно быть не менее 2 символов.");
        }
        this.color = color;
    }

    public void setBrandName(String brandName) {
        if (brandName == null || brandName.length() < 2) {
            throw new IllegalArgumentException("Значение brandName должно быть не менее 2 символов.");
        }
        this.brandName = brandName;
    }

    public void setState(int state) {
        if (state < 1 || state > 10) {
            throw new IllegalArgumentException("Состояние транспорта может быть только больше 0 или меньше 11");
        }
        this.state = state;
    }

    // ----------------------------------------- Getters
    public String getColor() {
        return color;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getState() {
        return state;
    }

    // ----------------------------------------- Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return state == transport.state && Objects.equals(color, transport.color)
                && Objects.equals(brandName, transport.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, brandName, state);
    }
}
