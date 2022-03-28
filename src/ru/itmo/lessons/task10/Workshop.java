package ru.itmo.lessons.task10;

import ru.itmo.lessons.lesson7.hw07.Teacher;

import java.util.Scanner;

public class Workshop implements Repair {
    private Transport[] tr;
    private int aerosolCount;

    // ----------------------------------------- Setters
    public void setTransport(Transport[] tr) {
        if (tr.length == 0) {
            throw new IllegalArgumentException("Массив должен иметь минимум 1 элемент");
        }
        this.tr = tr;
    }

    public void setAerosolCount(int aerosolCount) {
        if (aerosolCount < 0) {
            throw new IllegalArgumentException("Количество краски не может быть отрицательным.");
        }
        this.aerosolCount = aerosolCount;
    }

    // ----------------------------------------- Getters
    public Transport[] getTransport() {
        return tr;
    }

    public int getWhiteAerosolCount() {
        return aerosolCount;
    }

    // ----------------------------------------- Methods
    public void addTransport(Transport t) {
        for (int i = 0; i < tr.length; i++) {
            if (tr[i] != null && tr[i].equals(t)) {
                System.out.println("Транспорт не может быть добавлен, так как он уже есть в мастерской.");
                return;
            }
            if (tr[i] == null) {
                tr[i] = t;
                return;
            }
        }
        System.out.println("В мастерской больше нет места.");
    }

    public void addTransport(Transport... t) {
        for (Transport transport : t) {
            addTransport(transport);
        }
    }

    @Override
    public void doRepair() {
        for (Transport tran : this.getTransport()) {
            if (tran != null) {
                if (tran instanceof Macine) {
                    Macine mac = (Macine) tran;
                    mac.doRepair();
                }
                else if (tran instanceof Velo) {
                    Velo velo = (Velo) tran;
                    velo.doRepair();
                }
                else System.out.println("Данный транспорт не ремонтируется в мастерской.");
            }
        }
    }

    public void newColorWorkshop() {
        Scanner scanner = new Scanner(System.in);
        for (Transport tran : this.getTransport()) {
            if (tran != null) {
                if (aerosolCount == 0) {
                    System.out.println("Краска закончилась. Ни одно транспортное средство не может быть окрашено.");
                    return;
                } else {
                    if (tran instanceof Velo) {
                        Velo velo = (Velo) tran;
                            System.out.println("Введите цвет, которым вы хотите окрасить велосипед " + velo.getBrandName() + ":");
                        velo.newColor(scanner.nextLine());
                            System.out.println("Аэрозоль до: " + aerosolCount);
                        setAerosolCount(aerosolCount - 1);
                            System.out.println("Аэрозоль после: " + aerosolCount);
                            System.out.println("==========================================");
                        // минус 1 краска
                    } else if (tran instanceof Macine) {
                        Macine mac = (Macine) tran;
                        if (aerosolCount < 10) {
                            System.out.println("Нехватка краски. Данное транспортное средство (" + mac.getBrandName() + ") не может быть окрашено.");
                        } else {
                                System.out.println("Введите цвет, которым вы хотите окрасить машину " + mac.getBrandName() + ":");
                            mac.newColor(scanner.nextLine());
                                System.out.println("Аэрозоль до: " + aerosolCount);
                            setAerosolCount(aerosolCount - 10);
                                System.out.println("Аэрозоль после: " + aerosolCount);
                                System.out.println("==========================================");
                        }
                    } else {
                        Train train = (Train) tran;
                        if (aerosolCount < 50) {
                            System.out.println("Нехватка краски. Данное транспортное средство (" + train.getBrandName() + ") не может быть окрашено.");
                        } else {
                                System.out.println("Введите цвет, которым вы хотите окрасить поезд " + train.getBrandName() + ":");
                            train.newColor(scanner.nextLine());
                                System.out.println("Аэрозоль до: " + aerosolCount);
                            setAerosolCount(aerosolCount - 50);
                                System.out.println("Аэрозоль после: " + aerosolCount);
                                System.out.println("==========================================");
                        }
                    }
                }
            }
        }
    }
}
