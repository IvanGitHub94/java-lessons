package hw_2;

public class Task_3 {
    public static void main(String[] args) {
        int bottom = 10;
        int top = 500;
        double x = bottom + Math.random() * (top - bottom);

        if (x >= 25 && x <= 200) {
            System.out.println("Число " + x + " содержится в интервале (25;200)");
        }
        else System.out.println("Число " + x + " не содержится в интервале (25;200)");
    }
}
