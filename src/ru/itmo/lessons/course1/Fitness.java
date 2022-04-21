package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.util.Arrays;

public class Fitness {

    private Abonement[] abonGym;
    private Abonement[] abonPool;
    private Abonement[] abonGroup;

    // ------------------------------------------------------ Constructors

    public Fitness(Abonement[] abonGym, Abonement[] abonPool, Abonement[] abonGroup) {
        setArrGym(abonGym, abonPool, abonGroup);
    }

    // ------------------------------------------------------ Setters

    public void setArrGym(Abonement[] abonGym, Abonement[] abonPool, Abonement[] abonGroup) {
        if (abonGym.length == 0 || abonPool.length == 0 || abonGroup.length == 0) {
            throw new IllegalArgumentException("Массив должен иметь минимум 1 элемент.");
        }
        else if (abonGym.length > 20 || abonPool.length > 20 || abonGroup.length > 20) {
            throw new IllegalArgumentException("Массив не может содержать более 20 элементов.");
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

        Zones.GUM.setPeople(0);
        Zones.POOL.setPeople(0);
        Zones.GROUPS.setPeople(0);
    }

    public void addAbon(Abonement abonement) {
        //System.out.println(abonement.getClient().getWantZone());
        if (abonement.getDateRegEnd().isBefore(LocalDate.now())) {
            System.out.println("Абонемент просрочен.");
            return;
        }

        boolean b = false;
        for (Zones z : abonement.getZone()) {
            if (abonement.getClient().getWantZone().equals(z)) {
                b = true;
            }
        }
        if (!b) {
            System.out.println("Желаемая зона отсутствует в абонементе клиента.");
            return;
        }
// так как любой тип абонемента включает в себя зону тренажерный зал,
// то этот массив будет заполнятся в любом случае независимо от типа абонемента
// и именно поэтому нет смысла проверять клиентов по equals везде - если не пройдет проверка на заполнении в тренажерном зале,
// то такой абонемент и другие зоны не займет
            for (int i = 0; i < abonGym.length; i++) {
                if (abonGym[i] == null) {
                    abonGym[i] = abonement;
                    return;
                } else {
                    if (abonGym[i].getClient().equals(abonement.getClient())) {
                        System.out.println("Нельзя добавлять абонементы с одинаковыми клиентами.");
                        return;
                    }
                }
            }
            if (abonement.getAbonType().equals(AbonTypes.ONEDAY)) {
                for (int i = 0; i < abonPool.length; i++) {
                    if (abonPool[i] == null) {
                        abonPool[i] = abonement;
                        return;
                    }
                }
            }
            else if (abonement.getAbonType().equals(AbonTypes.FULL)) {
                for (int i = 0; i < abonPool.length; i++) {
                    if (abonPool[i] == null) {
                        abonPool[i] = abonement;
                        return;
                    }
                }
                for (int i = 0; i < abonGroup.length; i++) {
                    if (abonGroup[i] == null) {
                        abonGroup[i] = abonement;
                        return;
                    }
                }
            }
            else if (abonement.getAbonType().equals(AbonTypes.EVERYDAY)) {
                for (int i = 0; i < abonGroup.length; i++) {
                    if (abonGroup[i] == null) {
                        abonGroup[i] = abonement;
                        return;
                    }
                }
            }
    }

    public void addAbon(Abonement... abonements){
        for (Abonement abonement : abonements) {
            addAbon(abonement);
        }
    }
}
