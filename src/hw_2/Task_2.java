package hw_2;

public class Task_2 {
    public static void main(String[] args) {
        int first = 12;
        int second = 6;
        int operator = 9;

        switch (operator) {
            case 3:
                System.out.println(first + second);
                break;
            case 5:
                System.out.println(first - second);
                break;
            case 7:
                System.out.println(first * second);
                break;
            case 9:
                System.out.println((double) first / second);
                break;
        }
    }
}
