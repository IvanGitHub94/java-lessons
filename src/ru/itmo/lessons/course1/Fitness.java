package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Fitness {
    public static final int arraySize = 20;

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
            System.out.println("-----------------------------------------------------------------------------------------");
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
            System.out.println("-----------------------------------------------------------------------------------------");
            return;
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < arraySize; i++) {
            if (abonGym[i] == null) {
                abonGym[i] = abonement;
                break;
            }
            else {
                if (i == arraySize - 1) {
                    messageForClient(abonement.getClient(), Zones.GUM);
                    return; // если клиенту нехватило места хотя бы в одной из зон его абонемента,
                    // то его абонемент не регистрируется нигде
                }
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
                    addAbonInfo(abonement);
                    return;
                }
                else {
                    if (abonPool[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }
            messageForClient(abonement.getClient(), Zones.POOL);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (abonement.getAbonType().equals(AbonTypes.FULL)) {
            for (int i = 0; i < arraySize; i++) {
                if (abonPool[i] == null) {
                    abonPool[i] = abonement;
                    break;
                }
                else {
                    if (i == arraySize - 1) {
                        messageForClient(abonement.getClient(), Zones.GUM);
                        return;
                    }
                    if (abonPool[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }

            for (int i = 0; i < arraySize; i++) {
                if (abonGroup[i] == null) {
                    abonGroup[i] = abonement;
                    addAbonInfo(abonement);
                    return;
                }
                else {
                    if (abonGroup[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }
            messageForClient(abonement.getClient(), Zones.GROUPS);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if (abonement.getAbonType().equals(AbonTypes.EVERYDAY)) {
            for (int i = 0; i < arraySize; i++) {
                if (abonGroup[i] == null) {
                    abonGroup[i] = abonement;
                    addAbonInfo(abonement);
                    return;
                }
                else {
                    if (abonGroup[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }
            messageForClient(abonement.getClient(), Zones.GROUPS);
        }
    }

    public void addAbon(Abonement... abonements){
        for (Abonement abonement : abonements) {
            addAbon(abonement);
        }
    }

    public void messageForClient(Client client, Zones zones) {
        System.out.println(
                "Сообщение для клиента "
                        + client.getName() + " " + client.getLastName()
                        + ": в одной из зон вашего абонемента нет свободных мест (" + zones.name() + ")."
        );
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void aboutZonesClients () {
        System.out.println("Посетители зоны GYM: ");
        for (Abonement a : abonGym) {
            if (a != null) System.out.println(a.getClient().toString());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Посетители зоны POOL: ");
        for (Abonement a : abonPool) {
            if (a != null) System.out.println(a.getClient().toString());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Посетители зоны GROUPS: ");
        for (Abonement a : abonGroup) {
            if (a != null) System.out.println(a.getClient().toString());
        }
    }

    public void addAbonInfo (Abonement abonement) {
        System.out.println("Добавлен абонемент.");
        System.out.println("Клиент: " + abonement.getClient().getName() + " " + abonement.getClient().getLastName() + ".");
        switch (abonement.getAbonType()) {
            case ONEDAY:
                System.out.println("Зоны: " + Zones.GUM.name() + ", " + Zones.POOL.name() + ".");
                break;
            case FULL:
                System.out.println("Зоны: " + Zones.GUM.name() + ", " + Zones.POOL.name() + ", " + Zones.GROUPS.name() + ".");
                break;
            case EVERYDAY:
                System.out.println("Зоны: " + Zones.GUM.name() + ", " + Zones.GROUPS.name() + ".");
                break;
        }
        System.out.println("Дата и время посещения: " + LocalDateTime.now());
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
