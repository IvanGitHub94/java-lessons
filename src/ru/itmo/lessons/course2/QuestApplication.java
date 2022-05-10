package ru.itmo.lessons.course2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestApplication {
        public static void main(String[] args){
                menuMethod(true);
        }

        public static void menuMethod(boolean isNewGame) {
                // создаем объект, который будет использоваться
                Menu menu = new Menu();

                // создаем объекты для всех умений объекта Menu:
                Command startGame = new ChooseOneCommand(menu);
                Command downloadGame = new ChooseTwoCommand(menu);
                Command saveGame = new ChooseThreeCommand(menu);
                Command exit = new ChooseFourCommand(menu);

                // Создается invoker, с которым мы будем непосредственно контактировать:
                InvokerClass invoker = new InvokerClass(startGame, downloadGame, saveGame, exit);

                // Меню игры
                if (isNewGame) {
                        System.out.println("Меню игры: " + "\n" +
                                "__________ " + "\n" +
                                "1. Начать игру. " + "\n" +
                                "2. Загрузить игру. " + "\n" +
                                "3. Выйти. " + "\n" +
                                "__________");

                        Scanner scanner = new Scanner(System.in);
                        int chooseMenuPoint;
                        boolean b = true;
                        while (b) {
                                try {
                                        chooseMenuPoint = scanner.nextInt();
                                        switch (chooseMenuPoint) {
                                                case 1: invoker.flipStart();
                                                        b = false;
                                                        scanner.close();
                                                        return;
                                                case 2: invoker.flipDownload();
                                                        b = false;
                                                        scanner.close();
                                                        return;
                                                case 3: invoker.flipExit();
                                                        b = false;
                                                        scanner.close();
                                                        return;
                                                default:
                                                        System.out.println("Данного пункта нет в меню.");
                                        }
                                } catch (InputMismatchException e) {
                                        System.out.println("Введите корректное значение.");
                                        scanner.next();
                                }
                        }
                        scanner.close();
                } else {
                        System.out.println("Меню игры: " + "\n" +
                                "__________ " + "\n" +
                                "1. Начать игру. " + "\n" +
                                "2. Загрузить игру. " + "\n" +
                                "3. Выйти. " + "\n" +
                                "4. Сохранить игру. " + "\n" +
                                "__________");

                        Scanner scanner = new Scanner(System.in);
                        int chooseMenuPoint;
                        boolean b = true;
                        while (b) {
                                try {
                                        chooseMenuPoint = scanner.nextInt();
                                        switch (chooseMenuPoint) {
                                                case 1: invoker.flipStart();
                                                        b = false;
                                                        scanner.close();
                                                        return;
                                                case 2: invoker.flipDownload();
                                                        b = false;
                                                        scanner.close();
                                                        return;
                                                case 3: invoker.flipExit();
                                                        b = false;
                                                        scanner.close();
                                                        return;
                                                case 4: invoker.flipSaveGame();
                                                        b = false;
                                                        scanner.close();
                                                        return;
                                                default:
                                                        System.out.println("Данного пункта нет в меню.");
                                                        //scanner.next();
                                        }
                                } catch (InputMismatchException e) {
                                        System.out.println("Введите корректное значение.");
                                        scanner.next();
                                }
                        }
                        scanner.close();

                        /*Scanner scanner = new Scanner(System.in);
                        int chooseMenuPoint;
                        boolean b = true;
                        while (b) {
                                try {
                                        chooseMenuPoint = scanner.nextInt();
                                        switch (chooseMenuPoint) {
                                                case 1: invoker.flipStart();
                                                        b = false;
                                                        scanner.close();
                                                        break;
                                                case 2: invoker.flipDownload();
                                                        b = false;
                                                        scanner.close();
                                                        break;
                                                case 3: invoker.flipExit();
                                                        b = false;
                                                        scanner.close();
                                                        break;
                                                case 4: invoker.flipSaveGame();
                                                        b = false;
                                                        scanner.close();
                                                        break;
                                                default:
                                                        System.out.println("Данного пункта нет в меню.");
                                        }
                                } catch (InputMismatchException e) {
                                        System.out.println("Введите корректное значение.");
                                        scanner.next();
                                }
                        }*/
                }
        }
}
