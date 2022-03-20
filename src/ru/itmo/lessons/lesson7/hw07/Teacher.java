package ru.itmo.lessons.lesson7.hw07;

import ru.itmo.lessons.lesson6.hw06.Alpinist;

public class Teacher {
    private String name;
    private int age;
    private String teachSubject;
    private int teacherLevel;

    // Конструкторы
    public Teacher(String name, int age) {
        setName(name);
        setAge(age);
    }

    // Сеттеры
    public void setName(String name) {
        if (name == null || name.length() < 2) {
            throw new IllegalArgumentException("Значение name должно быть не менее 2 символов.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 25 || age > 99) {
            throw new IllegalArgumentException("В школе не могут преподавать люди возрастом меньше 25 и больше 99 лет.");
            // учитываем, что преподавать люди могут
            // начиная с возраста после окончания университета (примерно),
            // не учитываем выход на пенсию
        }
        this.age = age;
    }

    public void setTeachSubject(String teachSubject) {
        if (teachSubject == null || teachSubject.length() < 2) {
            throw new IllegalArgumentException("Значение teachSubject должно быть не менее 2 символов.");
        }
        this.teachSubject = teachSubject;
    }

    public void setTeacherLevel(int teacherLevel) {
        if (age < 1) {
            throw new IllegalArgumentException("Уровень навыка не может быть менее 1.");
            // менее 1, а не менее 0, так как нет смысла держать в школе учителя с 0 уровнем навыка.
        }
        this.teacherLevel = teacherLevel;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeachSubject() {
        return teachSubject;
    }

    public int getTeacherLevel() {
        return teacherLevel;
    }

    // Методы
    public int teach(Student s, int teacherLevel) {
        return s.studentToStudy(teacherLevel);
    }
}
