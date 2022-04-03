package ru.itmo.lessons.course1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Client client = new Client("Jack", "Smith", LocalDate.of(2004, 4, 1));
            Abonement abonement = new Abonement(client, AbonTypes.ONEDAY, LocalDate.of(2022, 4, 3));

        System.out.println("Дата окончания абонемента: " + abonement.getDateRegEnd());
        System.out.println(abonement.getAbonType());
        System.out.println(abonement.getMorning());
        System.out.println(abonement.getEvening());
        System.out.println(Arrays.toString(abonement.getZone()));

        //////////////
        System.out.println("------------------------------------------");
        Client client11 = new Client("Jay", "Sim", LocalDate.of(2004, 4, 1));
            Abonement abonement11 = new Abonement(client11, AbonTypes.EVERYDAY, LocalDate.of(2022, 4, 3));

        System.out.println("Дата окончания абонемента: " + abonement11.getDateRegEnd());
        System.out.println(abonement11.getAbonType());
        System.out.println(abonement11.getMorning());
        System.out.println(abonement11.getEvening());
        System.out.println(Arrays.toString(abonement11.getZone()));

        System.out.println(Zones.GUM.getPeople());

    }
}
