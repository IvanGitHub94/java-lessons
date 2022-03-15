package hw05;

import java.util.Locale;

public class Task04 {
    public static void main(String[] args) {
        //String str = "а роза упала на лапу Азора";
        String str = "Анна";
        String newStr = str.toLowerCase().replace(" ", "");
        String[] arr = newStr.split("");

        System.out.println(newStr);

        int left = 0, right = newStr.length() - 1, middle = newStr.length() / 2;

        int d = newStr.length() - 1;;
        if (newStr.length() % 2 == 0) {
            right = newStr.length();
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
        }
    }
