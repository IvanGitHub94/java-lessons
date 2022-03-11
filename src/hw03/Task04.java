package hw03;

import java.util.Scanner;

// 87
public class Task04 {
    public static void main(String[] args) {
        //int target = 2 + Math.random() * 3;
        boolean b = true;
        int bottom = 2;
        int top = 100;

        System.out.println("Вами загадано число в диапазоне [2;100].");
        System.out.println("Варианты ответа: \"0\" - \"Нет\", \"1\" - \"Да\".");
        System.out.println("--------------------");

        int num = bottom + (int) (Math.random() * (top - bottom + 1));

        System.out.println("Число равно " + num + " ?");
        while (b) {
            Scanner scanner = new Scanner(System.in);
            byte answer = scanner.nextByte();
            if (answer != 0 && answer != 1) {
                System.out.println("Некорректный ввод, введите \"0\" или \"1\":");
            }
            else { //////////////////////////////////////////////////////////////
                if (answer == 1) {
                    System.out.println("Программа угадала число. Работа завершена.");
                    b = false;
                }
                else {
                    int temp = 0;
                    System.out.println("Число больше " + num + " ?");
                    answer = scanner.nextByte();

                    if (answer == 1) {
                        temp = num;
                        temp = temp + (int) (Math.random() * (top - temp + 1));
                        System.out.println("Число равно " + temp + " ?");
                        //answer = scanner.nextByte();
                    }
                    else {
                        temp = num;
                        temp = bottom + (int) (Math.random() * (temp - bottom + 1));
                        System.out.println("Число равно " + temp + " ?");
                        //answer = scanner.nextByte();
                    }
                }
            }
        }
    }
}
