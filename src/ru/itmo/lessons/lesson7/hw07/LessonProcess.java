package ru.itmo.lessons.lesson7.hw07;

abstract public class LessonProcess extends People{
    protected String subject;

    // Конструкторы
    public LessonProcess(String name, int age, String subject) {
        super(name, age);
        setSchoolSubject(subject);
    }

    // Сеттеры
    public void setSchoolSubject(String subject) {
        if (subject == null || subject.length() < 2) {
            throw new IllegalArgumentException("Значение schoolSubject должно быть не менее 2 символов.");
        }
        this.subject = subject;
    }

    // Геттеры
    public String getSubject() {
        return subject;
    }
}
