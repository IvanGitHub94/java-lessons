package ru.itmo.lessons.lesson7.hw07;

public class School {
    private String schoolName; // без сеттера
    private Director director;
    private Teacher[] teachers;
    private Student[] students;

    public School(String schoolName, Director director) {
        if (schoolName == null || schoolName.length() < 2) {
            throw new IllegalArgumentException("Значение schoolName должно быть не менее 2 символов.");
        }
        this.schoolName = schoolName;
        this.director = director;
    }

    // Сеттеры
    public void setTeachers(Teacher[] teachers) {
        if (teachers.length == 0) {
            throw new IllegalArgumentException("Массив должен иметь минимум 1 элемент");
        }
        this.teachers = teachers;
    }

    public void setStudents(Student[] students) {
        if (students.length == 0) {
            throw new IllegalArgumentException("Массив должен иметь минимум 1 элемент");
        }
        this.students = students;
    }

    // Геттеры (не используются)
    public String getSchoolName() {
        return schoolName;
    }

    public Director getDirector() {
        return director;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public Student[] getStudents() {
        return students;
    }

    // Методы
    public void schoolDay() {
        director.announceStart();
        System.out.println("-----------------------");

        for (Teacher teacher : teachers) {
            for (Student student : students) {
                if (teacher != null && student != null) {
                    if (teacher.getSubject().equalsIgnoreCase(student.getSubject())) {
                        System.out.println("==========");
                        System.out.println("Уровень навыка учителя " + teacher.getName()
                                + " равен " + teacher.getTeacherLevel());
                        System.out.println("Уровень знаний ученика " + student.getName()
                                + " равен " + student.getLevelKnowlege());
                        System.out.println("==========");
                        System.out.println("Учитель " + teacher.getName()
                                + " обучает ученика " + student.getName()
                                + " предмету " + teacher.getSubject());
                        System.out.println("Уровень знаний ученика вырос до значения " +
                                teacher.teach(student));
                    } else {
                        System.out.println("( Школьные предметы учителя " + teacher.getName()
                                + " и ученика " + student.getName() + " не совпадают ).");
                    }
                }
            }
            System.out.println("-----------------------");
        }

        director.announceEnd();
    }

    public void addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                return;
            }
        }
        System.out.println("Штат учителей в данной школе укомплектован.");
    }

    public void addTeacher(Teacher... teachers){
        for (Teacher t : teachers) {
            addTeacher(t);
        }
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        System.out.println("Класс укомплектован.");
    }

    public void addStudent(Student... students){
        for (Student s : students) {
            addStudent(s);
        }
    }
}
