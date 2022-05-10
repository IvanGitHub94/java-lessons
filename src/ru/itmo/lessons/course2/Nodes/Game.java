package ru.itmo.lessons.course2.Nodes;

import ru.itmo.lessons.course2.Menu;
import ru.itmo.lessons.course2.QuestApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Game {
    // статик блок необходим для инициализации переменной forSave из файла properties заранее каждый раз
    // иначе может возникнуть ситуация, когда ее значение затирается и она заново инициализируется значением по умолчанию
    static {
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(Menu.PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            forSave = Integer.parseInt(prop.getProperty("key"));
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int forSave;

    public static void startGame(int downloadKey) {
        Tree tree = new Tree();
        tree.insert(50, Paragraphs.start);
        tree.insert(51, Paragraphs.backHome);
        tree.insert(10, Paragraphs.search1);
        tree.insert(5, Paragraphs.searchAlone);
        tree.insert(14, Paragraphs.forestResidents);
        tree.insert(17, Paragraphs.askOwl);
        tree.insert(12, Paragraphs.askWolf);
        tree.insert(11, Paragraphs.searchAlone);
        tree.insert(13, Paragraphs.backHome);
        tree.insert(19, Paragraphs.trustOwl);
        tree.insert(16, Paragraphs.searchAlone);
        tree.insert(18, Paragraphs.searchAlone);
        tree.insert(21, Paragraphs.honeyChance);
        tree.insert(20, Paragraphs.honeyNow);
        tree.insert(24, Paragraphs.waitBees);
        tree.insert(23, Paragraphs.eatAndRelax);
        tree.insert(26, Paragraphs.honeyToBear);
        tree.insert(25, Paragraphs.searchAlone);
        tree.insert(27, Paragraphs.backHome);

        Node targetNode = tree.find(downloadKey);
        System.out.println("Выбор действия: 1 или 2. 0 - выход в меню.");
        System.out.println("==========");
        targetNode.printNode();

        Scanner scanner = new Scanner(System.in);
        int choose;

        boolean b = true;
        while (b) {
            if (targetNode.leftChild == null || targetNode.rightChild == null) break;

            try {
                choose = scanner.nextInt();
                switch (choose) {
                    case 0:
                        QuestApplication.menuMethod(false);
                        forSave = targetNode.key;
                        b = false;
                        scanner.close();
                        return;
                    case 1:
                        targetNode.leftChild.printNode();
                        targetNode = targetNode.leftChild;
                        forSave = targetNode.key;
                        break;
                    case 2:
                        targetNode.rightChild.printNode();
                        targetNode = targetNode.rightChild;
                        forSave = targetNode.key;
                        break;
                    default:
                        System.out.println("Можно ввести только 1, 2 или 0.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Введено неверное значение.");
                scanner.next();
            }
        }
        scanner.close();
    }
}
