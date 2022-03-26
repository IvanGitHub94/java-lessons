package ru.itmo.lessons.task10;

import java.util.Objects;

public class Macine extends Transport implements Repair, ColorChange {
    private String number;

    // ----------------------------------------- Constructors
    public Macine(String color, String brandName, int state) {
        super(color, brandName, state);
    }

    // ----------------------------------------- Setters
    public void setNumber(String number) {
        if (number == null || number.length() < 2) {
            throw new IllegalArgumentException("Значение number должно быть не менее 2 символов.");
        }
        this.number = number;
    }

    // ----------------------------------------- Getters
    public String getNumber() {
        return number;
    }

    // ----------------------------------------- Methods


    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Macine macine = (Macine) o;
        return Objects.equals(number, macine.number);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Macine macine = (Macine) o;
        return super.getState() == macine.getState() && Objects.equals(super.getColor(), macine.getColor())
                && Objects.equals(super.getBrandName(), macine.getBrandName())
                && Objects.equals(this.getNumber(), macine.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number);
    }

    @Override
    public void doRepair() {
        if (this.getState() == 10) {
            System.out.println("Машина не нуждается в ремонте.");
            System.out.println("__________");
        }
        else if (this.getState() == 10 - 1) {
            System.out.println("О, да тут только масло заменить и как новая! " +
                    "(Состояние машины изменено с " +
                    this.getState() +
                    " до " + (this.getState() + 1) + ").");
            super.setState(this.getState() + 1);
            System.out.println("Рабочие отдыхают.");
            System.out.println("__________");
        }
        else {
            System.out.println("Пришлось повозиться. (Ремонт произведен. " +
                    "Состояние машины изменено с " +
                    this.getState() +
                    " до " + (this.getState() + 2) + ").");
            super.setState(this.getState() + 2);
            System.out.println("Рабочие отдыхают.");
            System.out.println("__________");
        }
    }

    @Override
    public void newColor(String color) {

    }
}
