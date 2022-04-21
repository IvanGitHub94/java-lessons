package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Client client = new Client("Jack", "Smith", LocalDate.of(2004, 4, 1), Zones.GUM);
        Client client1 = new Client("Jo", "Braun", LocalDate.of(2004, 4, 1), Zones.GUM);
        Client client2 = new Client("Din", "Smith", LocalDate.of(2004, 4, 1), Zones.GUM);
        Client client3 = new Client("Tom", "Smith", LocalDate.of(2004, 4, 1), Zones.GUM);
        //client.setWantZone(Zones.GROUPS);
        Abonement[] gym = new Abonement[Fitness.arraySize];
        Abonement[] pool = new Abonement[Fitness.arraySize];
        Abonement[] groups = new Abonement[Fitness.arraySize];

        Fitness fitness = new Fitness(gym, pool, groups);
        fitness.addAbon(new Abonement(client, AbonTypes.FULL, LocalDate.of(2022, 7, 3)),
                new Abonement(client1, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 20)),
                new Abonement(client2, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 20)),
                new Abonement(client3, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 20)) );

        System.out.println("GYM");
        for (Abonement a : fitness.getAbonGym()) {
            System.out.println(a);
        }
        System.out.println("--------------------------------------");
        System.out.println();

        System.out.println("POOL");
        for (Abonement a : fitness.getAbonPool()) {
            System.out.println(a);
        }
        System.out.println("--------------------------------------");
        System.out.println();

        System.out.println("GROUPS");
        for (Abonement a : fitness.getAbonGroup()) {
            System.out.println(a);
        }


    }
}
