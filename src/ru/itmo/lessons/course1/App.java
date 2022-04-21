package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Client client = new Client("Jack", "Smith", LocalDate.of(2004, 4, 1), Zones.GUM);
        Client client1 = new Client("Jo", "Smith", LocalDate.of(2004, 4, 1), Zones.GROUPS);
        //client.setWantZone(Zones.GROUPS);
        Abonement[] gym = new Abonement[20];
        Abonement[] pool = new Abonement[20];
        Abonement[] groups = new Abonement[20];

        Fitness fitness = new Fitness(gym, pool, groups);
        fitness.addAbon(new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client1, AbonTypes.ONEDAY, LocalDate.of(2022, 4, 20)));

        for (Abonement a : fitness.getAbonGym()) {
            System.out.println(a);
        }

        /*Fitness fitness = new Fitness(gym, pool, groups);
        fitness.addAbon(new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),

            new Abonement(client, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 3)),

            new Abonement(client, AbonTypes.FULL, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.FULL, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.FULL, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.FULL, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.FULL, LocalDate.of(2022, 7, 3)),
                new Abonement(client, AbonTypes.FULL, LocalDate.of(2022, 7, 3))
                );

        System.out.println("GYM: " + Zones.GUM.getPeople());
        System.out.println("POOL: " + Zones.POOL.getPeople());
        System.out.println("GROUPS " + Zones.GROUPS.getPeople());

        for (Abonement a : fitness.getAbonGym()) {
            System.out.println(a);
        }
        System.out.println();

        fitness.fitnessClose();

        for (Abonement a : fitness.getAbonGym()) {
            System.out.print(a + " ");
        }

        System.out.println();
        System.out.println("GYM: " + Zones.GUM.getPeople());
        System.out.println("POOL: " + Zones.POOL.getPeople());
        System.out.println("GROUPS " + Zones.GROUPS.getPeople());*/

            /*Abonement abonement = new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3));

        System.out.println("Дата окончания абонемента: " + abonement.getDateRegEnd());
        System.out.println(abonement.getAbonType());
        System.out.println(abonement.getMorning());
        System.out.println(abonement.getEvening());
        System.out.println(Arrays.toString(abonement.getZone()));

        //////////////
        System.out.println("------------------------------------------");
        Client client11 = new Client("Jay", "Sim", LocalDate.of(2004, 4, 1));
            Abonement abonement11 = new Abonement(client11, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 3));

        System.out.println("Дата окончания абонемента: " + abonement11.getDateRegEnd());
        System.out.println(abonement11.getAbonType());
        System.out.println(abonement11.getMorning());
        System.out.println(abonement11.getEvening());
        System.out.println(Arrays.toString(abonement11.getZone()));

        System.out.println("------------------------------------------");

        Client client12 = new Client("Jay", "Sim", LocalDate.of(2004, 4, 1));
        Abonement abonement12 = new Abonement(client12, AbonTypes.EVERYDAY, LocalDate.of(2022, 7, 3));

        System.out.println("Дата окончания абонемента: " + abonement12.getDateRegEnd());
        System.out.println(abonement12.getAbonType());
        System.out.println(abonement12.getMorning());
        System.out.println(abonement12.getEvening());
        System.out.println(Arrays.toString(abonement12.getZone()));

        System.out.println("------------------------------------------");

        Client client13 = new Client("Jay", "Sim", LocalDate.of(2004, 4, 1));
        Abonement abonement13 = new Abonement(client13, AbonTypes.FULL, LocalDate.of(2022, 7, 3));

        System.out.println("Дата окончания абонемента: " + abonement13.getDateRegEnd());
        System.out.println(abonement13.getAbonType());
        System.out.println(abonement13.getMorning());
        System.out.println(abonement13.getEvening());
        System.out.println(Arrays.toString(abonement13.getZone()));

        System.out.println(Zones.GUM.getPeople());*/

    }
}
