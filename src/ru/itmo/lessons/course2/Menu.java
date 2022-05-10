package ru.itmo.lessons.course2;

import ru.itmo.lessons.course2.Nodes.Game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class Menu {
    public Menu(){  }

    public static final String PATH_TO_PROPERTIES = "src\\ru\\itmo\\lessons\\course2\\Nodes\\keyPages.properties";
    Properties prop = new Properties();

    public void slideOne(){
        Game.startGame(50);
    }

    public void slideTwo(){
        System.out.println("Загрузка игры.");

        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            Game.startGame(Integer.parseInt(prop.getProperty("key")));
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружен");
            e.printStackTrace();
        }
    }

    public void slideThree(){
        System.out.println("Сохранение игры.");
        String download = String.valueOf(Game.forSave);

        try {
            //обращаемся к файлу и получаем данные
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_TO_PROPERTIES);
                prop.put("key", download);
                prop.store(fileOutputStream, null);

            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружен");
            e.printStackTrace();
        }

        System.out.println("Продолжить игру - 1, выйти из игры - 0");
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        while (b) {
            try {
                int binaryChoose = scanner.nextInt();
                switch (binaryChoose) {
                    case 1:
                        try {
                            FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
                                prop.load(fileInputStream);
                                Game.startGame(Integer.parseInt(prop.getProperty("key")));
                            fileInputStream.close();
                            b = false;
                            scanner.close();
                            return;
                        } catch (IOException e) {
                            System.out.println("Ошибка в программе: файл " + PATH_TO_PROPERTIES + " не обнаружен");
                            e.printStackTrace();
                        }
                    case 0:
                        slideFour();
                        b = false;
                        scanner.close();
                        return;
                    default:
                        System.out.println("Можно ввести только 1 или 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Из команды сохранения игры после продолжить.");
                scanner.next();
            }
        }
        scanner.close();
    }

    public void slideFour(){
        System.out.println("Выход из игры.");
        System.exit(0);
    }
}
