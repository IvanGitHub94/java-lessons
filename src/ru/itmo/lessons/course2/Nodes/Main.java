package ru.itmo.lessons.course2.Nodes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static final String PATH_TO_PROPERTIES = "src\\ru\\itmo\\lessons\\course2\\Nodes\\keyPages.properties";

    public static void main(String[] args) {
        String findFoxAlone = "Искать бельчонка в одиночку";
        String backHome = "Вернуться домой";

        Properties prop = new Properties();
        int forSave = 0;
        String prp = "";

        try {
            //обращаемся к файлу и получаем данные
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);

            prp = prop.getProperty("key");

            //печатаем полученные данные в консоль
            System.out.println(prp);

            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружен");
            e.printStackTrace();
        }

        Tree tree = new Tree();

        tree.insert(50, "Старт");
        tree.insert(51, backHome);
        tree.insert(10, "Основа 1");
        tree.insert(5, findFoxAlone);
        tree.insert(14, "Основа 2");
        tree.insert(17, "Основа 3");
        tree.insert(12, "Волк");
        tree.insert(11, findFoxAlone);
        tree.insert(13, backHome);
        tree.insert(19, "Основа 4");
        tree.insert(16, findFoxAlone);
        tree.insert(18, findFoxAlone);
        tree.insert(21, "Основа 5");
        tree.insert(20, "Выкрасть мед");
        tree.insert(24, "Основа 6");
        tree.insert(23, "Поесть немного и отдохнуть");
        tree.insert(26, "Основа 7");
        tree.insert(25, findFoxAlone);
        tree.insert(27, backHome);


        Node targetNode = tree.find(Integer.parseInt(prp));
        targetNode.printNode();

        Scanner scanner = new Scanner(System.in);
        String choose;

        while (true) {
            if (targetNode.leftChild == null || targetNode.rightChild == null) break;
            else System.out.println("Выбор действия: 1 или 2. 0 - выход.");

            choose = scanner.nextLine();
            
            try {
                if (Integer.parseInt(choose) == 0) break;

                if (Integer.parseInt(choose) == 1) {
                    targetNode.leftChild.printNode();
                    targetNode = targetNode.leftChild;
                    forSave = targetNode.key;

                } else if (Integer.parseInt(choose) == 2) {
                    targetNode.rightChild.printNode();
                    targetNode = targetNode.rightChild;
                    forSave = targetNode.key;

                } else System.out.println("Можно ввести только 1, 2 или 0.");

            } catch (Exception e) {
                System.out.println("Введено неверное значение.");
            }
        }
        System.out.println("После while");
        System.out.println("Save: " + forSave);

        prop.setProperty("key", "19");
        System.out.println("----------");
        System.out.println(prop.getProperty("key"));
    }

}


/*tree.insert(3, "John");
        tree.insert(8, "T1000");
        tree.insert(1, "Sara");
        tree.insert(2, "T800");
        //
        tree.insert(0, "TT");

        Node findJohn = tree.find(1);
        findJohn.leftChild.printNode();
        System.out.println("====");
        tree.print(findJohn);*/

/*Node targetNode = tree.find(51);
        targetNode.leftChild.printNode();*/

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод ключа из пропертис");
        int propInt;
        while (true) {
            try {
                String propIntstr = scanner.nextLine();
                propInt = Integer.parseInt(propIntstr);
                if (propInt == 1) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Необходимо ввести корректную цифру.");
            }
        }*/