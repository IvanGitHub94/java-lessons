package hw_2;

public class Task_4 {
    public static void main(String[] args) {
        int age = 25;
        int exp = 5;

        if (age > 100) {
            System.out.println("Мы вам перезвоним");
        }
        else {
            if (exp < 5) {
                System.out.println("Вы подходите на должность стажера");
            }
            else if (exp >= 5) {
                System.out.println("Вы подходите на должность разработчика");
            }
        }
    }
}
