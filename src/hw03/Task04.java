package hw03;

import java.util.Random;
import java.util.Scanner;

// 87
public class Task04 {
    public static void main(String args[]) {

        boolean b = true;
        int bottom = 2;
        int top = 100;

        System.out.println("Вами загадано число в диапазоне [2;100].");
        System.out.println("Варианты ответа: \"0\" - \"Нет\", \"1\" - \"Да\".");
        System.out.println("--------------------");

        int num = bottom + (int) (Math.random() * (top - bottom + 1));

        System.out.println("Число равно " + num + " ?");
        Scanner scanner = new Scanner(System.in);

        int tmin = bottom;
        int tmax = top;

        while (b) {
            byte command = scanner.nextByte();
            switch (command) {
                case 1:
                    System.out.println("Число угадано. Работа программы завершена.");
                    b = false;
                    break;
                case 0:
                    System.out.println("Число больше, чем " + num + " ?");
                    byte answer = scanner.nextByte();
                        switch (answer) {
                            case 1:
                            tmin = num;
                            num = num + (tmax - tmin) / 2;
                            System.out.println("Ваше число " + num + " ?");
                            break;
                            case 0:
                                tmax = num;
                                num = num - (tmax - tmin) / 2;
                                System.out.println("Ваше число " + num + " ?");
                                break;
                        }
            }
        }
    }
}
