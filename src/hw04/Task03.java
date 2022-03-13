package hw04;

import java.util.Arrays;

public class Task03 {
    // код ужасный, но рабочий
    // постараюсь привести поскорее в нормальный вид

    public static void main(String[] args) {
        int[] arr = new int[11] /*{0, 0, 1, -1, -1, 1, 0, 1, 1, 0, -1}*/;
        int bottom = -1, top = 1;

// заполнение массива случайными целыми числами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = bottom + (int) (Math.random() * (top - bottom + 1));
        }

        System.out.println("Массив: " + Arrays.toString(arr));

        int[] arrayT = new int[arr.length]; // создаю вспомогательный массив
        Arrays.fill(arrayT, 7); // заполнение любым числом вне диапазона для удобства и наглядности

        int[] arrCount = new int[arr.length];
        int count = 0;

        for (int el = 0; el < arr.length; el++) {
            int a = 0;
            boolean found = false;
            int searchedValue = arr[el];

            for(int x : arrayT){ // проверяю наличие текущего элемента во вспомогательном массиве
                if(x == searchedValue){
                    found = true;
                    break;
                }
            }

            if (found == false) {
                for (int e : arr) {
                    if (arr[el] == e) {
                        arrayT[el] = arr[el];
                        // добавляю элемент во вспомогательный массив,
                        // чтобы потом проверять его наличие
                        // и тем самым избежать повторного увеличения счетчика "а"
                        // + чтобы лишний раз не срабатывал цикл
                        a++;
                    }
                }
            }
            //if (a > 0) System.out.println("Элемент " + arr[el] + " встречается " + a + " раз(а).");
            // как бонус можно сразу узнать какой элемент сколько раз выводился, если раскомментировать
            if (a > 0) {
                arrCount[count] = a; // count нужен просто для удобства, чтоб массив заполнялся по порядку
                count++;
            }
        }

        Arrays.sort(arrCount);
        //System.out.println(Arrays.toString(arrCount));

        if (arrCount[arrCount.length - 1] != arrCount[arrCount.length - 2]) { //
            // после сортировки на последней позиции оказывается максимальное значение
            // если предшествующее ему значение такое же, то нарушается условие вывода
            // ("Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего")
            int maxFrequent = 0;
            int num = 0;
            for (int i = 0; i < arr.length; i++) {
                int frequent = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j]) {
                        frequent++;
                    }
                    if (frequent > maxFrequent) {
                        maxFrequent = frequent;
                        num = arr[i];
                    }
                }
            }
            System.out.println(num);
        }
    }
}
