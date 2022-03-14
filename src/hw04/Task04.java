package hw04;

import java.util.Arrays;

public class Task04 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 4, 3, 8, 2, 7, 6, 9};
        int leng = arr.length - arr.length / 2;

        int leng1 = 0, leng2 = 0;

        if (arr.length % 2 != 0) {
            leng1 = leng;
            leng2 = arr.length - leng;
            //int[] arrNeCh = new int[len];
            //int[] arrCh = new int[arr.length - arrNeCh.length];
            //System.out.println("Длина четного массива: " + arrCh.length);
            //System.out.println("Длина нечетного массива: " + arrNeCh.length);
        }
        else {
            leng1 = arr.length - leng;
            leng2 = leng;
            //int[] arrCh = new int[len];
            //int[] arrNeCh = new int[arr.length - arrCh.length];
            //System.out.println("Длина четного массива: " + arrCh.length);
            //System.out.println("Длина нечетного массива: " + arrNeCh.length);
        }

        int[] arrNeCh = new int[leng1];
        int[] arrCh = new int[leng2];

        System.out.println("Длина четного массива: " + arrCh.length);
        System.out.println("Длина нечетного массива: " + arrNeCh.length);

        Arrays.sort(arr);

        int countCh = 0;
        int countNech = 0;
        for (int el : arr) {
            if (el % 2 == 0) {
                arrCh[countCh] = el;
                countCh++;
            }
            else {
                arrNeCh[countNech] = el;
                countNech++;
            }
        }

        System.out.println("Мессив с четными числами: " + Arrays.toString(arrCh));
        System.out.println("Мессив с нечетными числами: " + Arrays.toString(arrNeCh));
    }
}
