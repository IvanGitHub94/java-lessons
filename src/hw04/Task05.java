package hw04;

import java.util.Arrays;

public class Task05 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -5, 0, 9, 5, -3, -1, -5, 8};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        int count = 0;
        for (int el : arr) {
            if (el < 0) count++;
        }
        System.out.println("Размер целевого массива: " + count);

        int[] target = new int[count];
        int temp = 0;
        int temp2 = 0;
        for (int el : arr) {
            if (el < 0) {
                target[temp] = el;
                arr[temp2] = 0; // так как в задании указано "Отрицательные элементы массива
                // перенести(!) в новый массив", а не скопировать, значит
                // этих элементов больше в исходном массиве быть не должно
                // - заменяю на ноль, к примеру
                temp++;
            }
            temp2++;
        }
        System.out.println("Исходный массив после преобразований: " + Arrays.toString(arr));
        System.out.println("Целевой массив: " + Arrays.toString(target));
    }
}
