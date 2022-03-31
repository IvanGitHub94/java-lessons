package ru.itmo.lessons.catsandmice;

public class CatApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Васька", 26, 5);
        Cat cat2 = new Cat("Пушок", 24, 6);

        Mouse mouse1 = new Mouse("№1",25);
        Mouse mouse2 = new Mouse("№2",24);
        Mouse mouse3 = new Mouse("№3",23);
        Mouse mouse4 = new Mouse("№4",22);
        Mouse mouse5 = new Mouse("№5",21);
        Mouse mouse6 = new Mouse("№6",20);

        System.out.println("Кот " + cat1.getName() + " охотится.");
            cat1.addMouse(mouse1, mouse2, mouse3);
            System.out.println();

        System.out.println("Кот " + cat2.getName() + " охотится.");
            cat2.addMouse(mouse4, mouse5, mouse6);
            System.out.println();

////////////////////////////////////////////////////////////////////
        System.out.println("Коты подрались.");
            cat1.catConflict(cat2);
            System.out.println();
////////////////////////////////////////////////////////////////////

        System.out.println("Мыши у кота " + cat1.getName() + " :");
        for (Mouse mouse : cat1.getCaughtMice()) {
            if (mouse != null) {
                System.out.println("Мышь " + mouse.getName());
            }
        }

            System.out.println();

        System.out.println("Мыши у кота " + cat2.getName() + " :");
        for (Mouse mouse : cat2.getCaughtMice()) {
            if (mouse != null) {
                System.out.println("Мышь " + mouse.getName());
            }
        }
    }
}
