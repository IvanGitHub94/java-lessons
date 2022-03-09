package hw_2;

public class Task_5 {
    public static void main(String[] args) {
        int month = 6;

        if (month < 3 || month == 12) {
            System.out.println("Зима");
        } else if (month < 6) {
            System.out.println("Весна");
        } else if (month < 9){
            System.out.println("Лето");
        } else if (month < 12) {
            System.out.println("Осень");
        } else {
            System.out.println("Ошибка");
        }
    }
}
