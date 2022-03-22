package ru.itmo.lessons.lesson7.hw07;

public class Teacher extends LessonProcess{
    private int teacherLevel;

    // Конструкторы
    public Teacher(String name, int age, String subject) {
        super(name, age, subject);
    }

    // Сеттеры
    public void setAge(int age) {
        if (age < 25 || age > 99) {
            throw new IllegalArgumentException("В школе не могут преподавать люди возрастом меньше 25 и больше 99 лет.");
            // учитываем, что преподавать люди могут
            // начиная с возраста после окончания университета (примерно),
            // не учитываем выход на пенсию
        }
        this.age = age;
    }

    public void setTeacherLevel(int teacherLevel) {
        if (age < 1) {
            throw new IllegalArgumentException("Уровень навыка не может быть менее 1.");
            // менее 1, а не менее 0, так как нет смысла держать в школе учителя с 0 уровнем навыка.
        }
        this.teacherLevel = teacherLevel;
    }

    // Геттеры
    public int getTeacherLevel() {
        return teacherLevel;
    }

    // Методы
    public int teach(Student s) {
        return s.studentToStudy(this.teacherLevel);
    }
}
