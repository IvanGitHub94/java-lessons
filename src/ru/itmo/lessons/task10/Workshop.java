package ru.itmo.lessons.task10;

import ru.itmo.lessons.lesson7.hw07.Teacher;

public class Workshop implements Repair {
    private Transport[] tr;

    // ----------------------------------------- Setters
    public void setTransport(Transport[] tr) {
        if (tr.length == 0) {
            throw new IllegalArgumentException("Массив должен иметь минимум 1 элемент");
        }
        this.tr = tr;
    }

    // ----------------------------------------- Getters
    public Transport[] getTransport() {
        return tr;
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
}
