public class FirstLesson {
    public static void main(String[] args) {
        System.out.println("Примитивные типы:");

        int size; // объявление переменной
        size = 1; // инициализация переменной значением "1"

        // System.out.println(size); !!!
        // примитивные типы нужно инициализировать,
        // иначе будет ошибка

        int len = 15, wid = 100; // объявление и инициализация нескольких переменных
        size = 20; // присвоение нового значения

        // long veryBig = 67_000_000_000; ошибка!
        // так как необходимо в конце ставить l
        // integer number too large - компилятор считает, что работаем с int,
        // пока не добавим в конец l, обозначив тем самым, что работаем с long (можно с L)

        // деление целых чисел на 0 (ArithmeticException)
        // System.out.println( size / 0 );

        double price = 56.7;
        float temp = -78.3f;

        System.out.println( price / 0 ); // для чисел с плавающей точкой ошибки нет, результат либо Infinity,
        // либо -Infinity (зависит от знаков чисел в выражении)

        size = 8700; // int
        price = size; // double
        System.out.println(price); // 8700.0
        // произошло автоматическое приведение типов
        // диапазон int включен в диапазон double
        // наоборот не сработало бы (int в byte не привести без явногоприведения через скобки () )
        byte small = (byte) size;
        System.out.println(small); // может произойти потеря данных и число изменится

        // операторы
        int a = 9, b = 4;
        int c = a / b; // сначала деление, потом присваивание (!!!) - очередность
        System.out.println(c); // 2 при делении целых чисел будет результат без остатка
        // только целое число в итоге

        double x = a / b; // сначала деление, потом приведение к double, потом присвоение
        System.out.println(x);

        byte q = 6, w = 12;
        byte e = (byte) (q + w); // будет ошибка при byte e = q + w;
        // так как получится int при сложении данных

        // у операции явного приведения (byte) приоритет !!!

        // %
        len = 9;
        wid = 2;
        System.out.println(len % wid); // 1
        // 4.5   4.5
        // 0.5 + 0.5 = 1

        // операторы присваивания
        int num = 10;
        num = num + 10; // сначала к num прибавляется 10,
        // затем присваивается новое значение (num = 20)
        // можно и так: num += 10;
        num -= 10; // num = num - 10;
        // остальные операторы так же
        System.out.println(num);
///////////////////////////////////////////////
        System.out.println(num > 2);
        System.out.println(num == 4);

        // тернарный оператор
        int start = 3, end = 5000;
        int res = start > end ? end - start : 0;
        System.out.println(res);
    }
}
