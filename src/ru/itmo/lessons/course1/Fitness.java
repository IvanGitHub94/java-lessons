package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.util.Arrays;

public class Fitness {
    public static final int arraySize = 3;

    private Abonement[] abonGym;
    private Abonement[] abonPool;
    private Abonement[] abonGroup;

    // ------------------------------------------------------ Constructors

    public Fitness(Abonement[] abonGym, Abonement[] abonPool, Abonement[] abonGroup) {
        setArrGym(abonGym, abonPool, abonGroup);
    }

    // ------------------------------------------------------ Setters

    public void setArrGym(Abonement[] abonGym, Abonement[] abonPool, Abonement[] abonGroup) {
        if (abonGym.length != arraySize || abonPool.length != arraySize || abonGroup.length != arraySize) {
            throw new IllegalArgumentException("Все массивы должны иметь стандартный размер " + arraySize + ".");
        }
        else {
            this.abonGym = abonGym;
            this.abonPool = abonPool;
            this.abonGroup = abonGroup;
        }
    }

    // ------------------------------------------------------ Getters

    public Abonement[] getAbonGym() {
        return abonGym;
    }

    public Abonement[] getAbonPool() {
        return abonPool;
    }

    public Abonement[] getAbonGroup() {
        return abonGroup;
    }

    // ------------------------------------------------------ Methods

    public void fitnessClose() {
        Arrays.fill(this.abonGym, null);
        Arrays.fill(this.abonPool, null);
        Arrays.fill(this.abonGroup, null);
    }

    public void addAbon(Abonement abonement) {
        // Проверки:
                if (abonement.getDateRegEnd().isBefore(LocalDate.now())) {
                    System.out.println("Абонемент просрочен.");
                    return;
                }

                boolean b = false;
                for (Zones z : abonement.getZone()) {
                    if (abonement.getClient().getWantZone().equals(z)) {
                        b = true;
                        break;
                    }
                }
                if (!b) {
                    System.out.println("Желаемая зона ("
                            + abonement.getClient().getWantZone().name()
                            + ") отсутствует в абонементе клиента "
                            + abonement.getClient().getName() + " "
                            + abonement.getClient().getLastName() + ".");
                    return;
                }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        for (int i = 0; i < arraySize; i++) {
            if (abonGym[i] == null) {
                abonGym[i] = abonement;
                break;
            }
            else {
                if (i == arraySize - 1) messageForClient(abonement.getClient());
                if (abonGym[i].getClient().equals(abonement.getClient())) {
                    System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                    return;
                }
            }
        }

        if (abonement.getAbonType().equals(AbonTypes.ONEDAY)) {
            for (int i = 0; i < arraySize; i++) {
                if (abonPool[i] == null) {
                    abonPool[i] = abonement;
                    return;
                }
                else {
                    if (abonPool[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }
            messageForClient(abonement.getClient());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (abonement.getAbonType().equals(AbonTypes.FULL)) {
            for (int i = 0; i < arraySize; i++) {
                if (abonPool[i] == null) {
                    abonPool[i] = abonement;
                    break;
                }
                else {
                    if (i == arraySize - 1) messageForClient(abonement.getClient());
                    if (abonPool[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }

            for (int i = 0; i < arraySize; i++) {
                if (abonGroup[i] == null) {
                    abonGroup[i] = abonement;
                    return;
                }
                else {
                    if (abonGroup[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }
            messageForClient(abonement.getClient());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (abonement.getAbonType().equals(AbonTypes.EVERYDAY)) {
            for (int i = 0; i < arraySize; i++) {
                if (abonGroup[i] == null) {
                    abonGroup[i] = abonement;
                    return;
                }
                else {
                    if (abonGroup[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }
            messageForClient(abonement.getClient());
        }
    }

    public void addAbon(Abonement... abonements){
        for (Abonement abonement : abonements) {
            addAbon(abonement);
        }
    }

    public void messageForClient(Client client) {
        System.out.println(
                "Сообщение для клиента "
                        + client.getName() + " " + client.getLastName()
                        + ": в одной из зон вашего абонемента нет свободных мест."
        );
    }
}
