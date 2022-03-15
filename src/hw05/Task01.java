package hw05;

import java.util.Arrays;
import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        String[] words = new String[4];

        String msg = "Работа программы завершена (введена команда \"exit\").";

        Scanner scan = new Scanner(System.in);
        int count = 0;
        String str;
        boolean b;
        while (!(str = scan.nextLine()).equalsIgnoreCase("exit")) {
            b = false;
            for (String s : words) {
                if (str.equals(s)) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                words[count] = str;
                count++;
            }

            if (count == words.length) {
                msg = "Работа программы завершена (массив заполнен).";
                break;
            }
        }
        System.out.println(Arrays.toString(words));
        System.out.println(msg);
    }
}
