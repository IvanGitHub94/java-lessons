package hw_2;

public class Task_1 {
    public static void main(String[] args) {
        int count = 89;

        if (count <= 100) {
            if (count >= 90) {
                System.out.println("Отлично");
            }
            else if (count >= 60) {
                System.out.println("Хорошо");
            }
            else if (count >= 40) {
                System.out.println("Удовлетворительно");
            }
            else {
                System.out.println("Попробуйте еще раз");
            }
        }
    }
}
