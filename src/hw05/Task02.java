package hw05;

import java.util.Arrays;
import java.util.Scanner;

/** строки с комментариями - альтернативный вариант решения */

public class Task02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //String str = "helLo";
        String[] words = str.split("", 2);

        words[0] = words[0].toUpperCase();
        words[1] = words[1].toLowerCase();

        String res = words[0] + words[1];
        System.out.println(res);

        //System.out.println(Arrays.toString(words));

        //StringBuilder sb = new StringBuilder();
        //sb.append(words[0]).append(words[1]);

        //System.out.println(sb);
    }
}
