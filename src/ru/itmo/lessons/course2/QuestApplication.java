package ru.itmo.lessons.course2;

public class QuestApplication {
        public static void main(String[] args){

            // создаем объект, который будет использоваться
                Slider slider = new Slider();

            // создаем объекты для всех умений объекта Light:
                Command first = new ChooseOneCommand(slider);
                Command second = new ChooseTwoCommand(slider);

            // Создаемтся invoker, с которым мы будем непосредственно контактировать:
                InvokerClass invoker = new InvokerClass(first, second);

            // вот проверка этого, используем методы:
                invoker.flipOne();
                invoker.flipTwo();
        }
}
