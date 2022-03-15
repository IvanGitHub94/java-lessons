package hw05;

import java.util.Locale;

public class Task04 {
    public static void main(String[] args) {
        //String str = "а роза упала на лапу Азора";
        String str = "Анна";
        String newStr = str.toLowerCase().replace(" ", "");
        String[] arr = newStr.split("");

        System.out.println(newStr);
        System.out.println(newStr.length());
        //System.out.println(newStr.length() / 2);

        int left = 0, right = newStr.length() - 1, middle = newStr.length() / 2;

        int d = 0;
        if (newStr.length() % 2 != 0) {
            d = newStr.length() - 1;
        }
        else {
            right = newStr.length(); // 6
            d = newStr.length() - 1;
        }

            while (left < middle && right > middle) {
                if (!arr[left].equals(arr[d])) {
                    System.out.println("Слово не является палиндромом.");
                    break;
                }
                else {
                    left++;
                    right--;
                    d--;
                }
            }
            if (left == right) System.out.println("Слово является палиндромом.");
            System.out.println(left);
            System.out.println(right);
        }
        /*else { // четная
            System.out.println("----" + middle);

            while (left < middle && right > middle) {
                if (!arr[left].equals(arr[d])) {
                    System.out.println("Слово не является палиндромом.");
                    break;
                }
                else {
                    left++;
                    right--; // 6 - 1
                    d--;
                }
            }
            if (left == right) System.out.println("Слово является палиндромом.");
            System.out.println(left);
            System.out.println(right);
        }*/
    }
