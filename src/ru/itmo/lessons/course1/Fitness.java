package ru.itmo.lessons.course1;

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
        Arrays.fill(abonGym, null);
        Arrays.fill(abonPool, null);
        Arrays.fill(abonGroup, null);
    }

    public void addAbon(Abonement abonement) {
            for (int i = 0; i < abonGym.length; i++) {
                if (abonGym[i] == null) {
                    abonGym[i] = abonement;
                    return;
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
