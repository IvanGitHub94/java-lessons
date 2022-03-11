package hw03;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        int bottom = 1;
        int top = 9;
        int num = bottom + (int) (Math.random() * (top - bottom + 1)); // 1 и 9 включены, так как скобки диапазона []
        //System.out.println(num);
        boolean b = true;

        System.out.println("Введите число от 1 до 9 включительно: ");
        while (b) {
            Scanner scanner = new Scanner(System.in);
            int userNum = scanner.nextInt();

            if (userNum >= 1 && userNum <= 9) {
                if (num > userNum) {
                    System.out.println("Загаданное число больше");
                } else if (num < userNum) {
                    System.out.println("Загаданное число меньше");
                } else {
                    System.out.println("Вы угадали!");
                    b = false;
                }
            } else {
                System.out.println("Введено некорректное число, попробуйте еще раз:");
            }
        }
    }
}
