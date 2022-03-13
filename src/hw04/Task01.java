package hw04;

import java.util.Arrays;

public class Task01 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        int bottom = 1, top = 10;

// заполнение массива случайными целыми числами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = bottom + (int) (Math.random() * (top - bottom + 1));
        }
        System.out.println("Массив: " + Arrays.toString(arr));

        int res = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int el : arr) {
            sum = sum + el;
            res = el < res ? el : res;
            max = el > max ? el : max;
        }
        System.out.println("Минимальное значение: " + res);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее арифметическое значение элементов массива: " + sum / arr.length);
    }
}
