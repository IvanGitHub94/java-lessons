package hw04;

import java.util.Arrays;

public class Task02 {
    public static void main(String[] args) {
        // task02
        int[] arr = new int[10];

        for (int i = 0, j = 2; i < arr.length; i++, j += 2) {
            arr[i] = j;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " | ");
        }
    }
}
