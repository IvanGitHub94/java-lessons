package ru.itmo.lessons.lesson7.hw07;

public class Student {
    private String name;
    private int age;
    private String schoolSubject;
    private int levelKnowlege;

    // Конструкторы
    public Student(String name, int age) {
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
        if (age < 6 || age > 19) {
            throw new IllegalArgumentException("В школе не учатся люди возрастом меньше 6 и больше 19 лет.");
            // не учитываем ситуацию, когда ученик может остаться на второй год,
            // а возраст все равно увеличивается
        }
        this.age = age;
    }

    public void setSchoolSubject(String schoolSubject) {
        if (schoolSubject == null || schoolSubject.length() < 2) {
            throw new IllegalArgumentException("Значение schoolSubject должно быть не менее 2 символов.");
        }
        this.schoolSubject = schoolSubject;
    }

    public void setLevelKnowlege(int levelKnowlege) {
        if (age < 0) {
            throw new IllegalArgumentException("Уровень знаний не может быть отрицательным.");
        }
        this.levelKnowlege = levelKnowlege;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSchoolSubject() {
        return schoolSubject;
    }

    public int getLevelKnowlege() {
        return levelKnowlege;
    }

    // Метод
    public int studentToStudy(int teacherLevel) {
        int bottom = 1;
        // не 0, так как уровень знаний ученика должен увеличиваться,
        // при 0 есть вероятность получить рандомное значение тоже 0
        int res = bottom + (int) (Math.random() * (teacherLevel - bottom + 1));
        this.levelKnowlege = this.levelKnowlege + res;
        return this.levelKnowlege;
    }
}
