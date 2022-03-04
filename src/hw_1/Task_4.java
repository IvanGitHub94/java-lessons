package hw_1;

public class Task_4 {
    public static void main(String[] args) {
        // Задача на арифметические операторы

// Даны длина, ширина и высота прямоугольного параллелепипеда.
// Найти и вывести в консоль его площадь.

        int length = 8;
        int width = 5;
        int height = 4;

        int square = 2 * (length * width + width * height + length * height);

        System.out.println("Задание 3");
        System.out.println( "Площадь прямоугольного параллелепипеда со сторонами "
                + length + ", " + width + ", " + height + " равна " + square);
    }
}
