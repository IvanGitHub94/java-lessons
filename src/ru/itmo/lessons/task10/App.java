package ru.itmo.lessons.task10;

public class App {
    public static void main(String[] args) {
        Macine m1 = new Macine("Red", "VW", 9);
            m1.setNumber("Q123");
        Macine m2 = new Macine("Black", "BMW", 9);
            m2.setNumber("Q123");
        Macine m3 = new Macine("Black", "Fiat", 5);

        Velo v1 = new Velo("Blue", "Аист", 10);
            v1.setType("Горный");
        Velo v2 = new Velo("White", "Lacoste", 7);
            v2.setType("Горный");

        Train train1 = new Train("Metallic", "Siemens", 9);

        Transport[] arrTr = new Transport[5];

        Workshop workshop = new Workshop();
            workshop.setTransport(arrTr);
            workshop.addTransport(v1, v2, m1, m3, train1);

            workshop.setAerosolCount(1);
////////////////////////////////////////////////////////////////////////
            workshop.doRepair();
                System.out.println("---------------------------------------------------------------------------------");
            workshop.newColorWorkshop();
////////////////////////////////////////////////////////////////////////
        /*System.out.println(v1.getColor());
        System.out.println(v2.getColor());
        System.out.println(m1.getColor());
        System.out.println(m3.getColor());
        System.out.println(train1.getColor());*/
    }
}
