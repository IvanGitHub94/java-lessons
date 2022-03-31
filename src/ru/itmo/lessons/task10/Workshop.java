package ru.itmo.lessons.task10;

public class Workshop implements Repair, ColorChange {
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

    public int getAerosolCount() {
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
                if (tran instanceof Repair) {
                    ((Repair) tran).doRepair();
                } else System.out.println("Данный транспорт не ремонтируется в мастерской.");
            }
        }
    }

    @Override
    public void newColor() {
        for (Transport tran : this.getTransport()) {
            if (tran != null) {
                if (getAerosolCount() == 0) {
                    System.out.println("Краска закончилась. Ни одно транспортное средство не может быть окрашено.");
                    return;
                } else {
                    if (tran instanceof ColorChange) {
                        if ((tran instanceof Macine && getAerosolCount() < 10)
                                || (tran instanceof Train && getAerosolCount() < 50)) {
                            System.out.println("Нехватка краски. Данное транспортное средство (" + tran.getBrandName() + ") не может быть окрашено.");
                        } else {
                            ((ColorChange) tran).newColor();
                            System.out.println("Аэрозоль до: " + getAerosolCount());
                                if (tran instanceof Velo) setAerosolCount(getAerosolCount() - 1);
                                if (tran instanceof Macine) setAerosolCount(getAerosolCount() - 10);
                                if (tran instanceof Train) setAerosolCount(getAerosolCount() - 50);
                            System.out.println("Аэрозоль после: " + getAerosolCount());
                            System.out.println("==========================================");
                        }
                    }
                    else System.out.println("Данный объект не подлежит покраске.");
                }
            }
        }
    }
}
