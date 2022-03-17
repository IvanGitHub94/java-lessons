package ru.itmo.lessons.lesson6.hw06;

public class App {
    public static void main(String[] args) {
// Горы
        Mountain mountain1 = new Mountain("Казбек", "Грузия", 2353);
        Mountain mountain2 = new Mountain("Эльбрус", "Россия", 5642);
        Mountain mountain3 = new Mountain("Олимп", "Греция", 2917);

        // Массивы
        Alpinist[] arr1 = new Alpinist[3];
        arr1[0] = new Alpinist("Петр Волков");
        arr1[1] = new Alpinist("Отомура Такэда");
        arr1[2] = new Alpinist("Лиза Маркс");

        Alpinist[] arr2 = new Alpinist[3];
        arr2[0] = new Alpinist("Джеки Чан");
        arr2[1] = new Alpinist("Жан Жак Пьемонт");

        Alpinist[] arr3 = new Alpinist[3];
        arr3[0] = new Alpinist("Ли Хон Ми");
        arr3[1] = new Alpinist("Анастасия Петрова");

        // Группы
        Group group1 = new Group(false, arr1);
            group1.setGroupName("Группа 1");
            group1.setTargetMountain(mountain1);
            group1.addAlpinist(new Alpinist("Ли Хон Ми"));
            // пробуем добавить альпиниста при закрытом наборе

        Group group2 = new Group(true, arr2);
            group2.setGroupName("Группа 2");
            group2.setTargetMountain(mountain2);
            if (group2.isOpenGroup()) {
                group2.addAlpinist(new Alpinist("Принц Конго"),
                        new Alpinist("Анастасия Петрова"));
            }
            // пробуем добавить больше альпинистов,
            // чем свободных мест в группе

        Group group3 = new Group(true, arr3);
            group3.setGroupName("Группа 3");
            group3.setTargetMountain(mountain3);
            group3.addAlpinist(new Alpinist("Принц Конго"));

/////////////////////////////////////////// ТЕСТ ///////////////////////////////////////////////////////////////

        System.out.println("----------");
        Group test = group2;

        System.out.println("Группа " + test.getGroupName() + " состоит из альпинистов: ");
        for (Alpinist a : test.getAlpArr()) {
            if (a != null) {
                System.out.print(a.getName() + ", ");
            }
        }
        System.out.print("\n");
        System.out.println("Группа совершает восхождение на гору "
                + test.getTargetMountain().getMountainName()
                + " высотой " + test.getTargetMountain().getHeight()
                + " м.");
        System.out.println("Гора находится в стране " + test.getTargetMountain().getCountry() + ".");
    }
}

// Альпинисты
        /*Alpinist person1 = new Alpinist("Петр Волков");
        Alpinist person2 = new Alpinist("Отомура Такэда");
        Alpinist person3 = new Alpinist("Лиза Маркс");
        Alpinist person4 = new Alpinist("Ли Хон Ми");
        Alpinist person5 = new Alpinist("Джеки Чан");
        Alpinist person6 = new Alpinist("Жан Жак Пьемонт");
        Alpinist person7 = new Alpinist("Принц Конго");
        Alpinist person8 = new Alpinist("Марио Гетти");
        Alpinist person9 = new Alpinist("Анастасия Петрова");*/
