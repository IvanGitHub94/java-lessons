package ru.itmo.lessons.course1;

import java.time.LocalDate;
public class App {
    public static void main(String[] args) {

        Client client = new Client("Jack", "Smith", LocalDate.of(2004, 4, 8), Zones.GUM);
        Client client1 = new Client("Jo", "Braun", LocalDate.of(2002, 9, 16), Zones.GROUPS);
        Client client2 = new Client("Din", "Smith", LocalDate.of(1997, 2, 21), Zones.GUM);
        Client client3 = new Client("Tom", "Smith", LocalDate.of(1989, 11, 5), Zones.GUM);

        Abonement[] gym = new Abonement[Fitness.arraySize];
        Abonement[] pool = new Abonement[Fitness.arraySize];
        Abonement[] groups = new Abonement[Fitness.arraySize];

        Fitness fitness = new Fitness(gym, pool, groups);
        fitness.addAbon(new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 3)),
                new Abonement(client1, AbonTypes.ONEDAY, LocalDate.of(2022, 7, 20)),
                new Abonement(client2, AbonTypes.FULL, LocalDate.of(2022, 7, 20)),
                new Abonement(client3, AbonTypes.FULL, LocalDate.of(2022, 7, 20)) );

        fitness.aboutZonesClients();
        fitness.fitnessClose();

    }
}
