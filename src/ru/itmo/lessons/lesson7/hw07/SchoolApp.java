package ru.itmo.lessons.lesson7.hw07;

public class SchoolApp {
    public static void main(String[] args) {
        // Директор
        Director d = new Director("Геннадий Александрович", 54);

        // Учителя
        Teacher t1 = new Teacher("Варвара Петровна", 51, "География");
            t1.setTeacherLevel(7);
        Teacher t2 = new Teacher("Валерий Николаевич", 44, "История");
            t2.setTeacherLevel(6);
        Teacher t3 = new Teacher("Людмила Алексеевна", 37, "Математика");
            t3.setTeacherLevel(8);

        // Студенты
        Student s1 = new Student("Петров", 12, "География");
        Student s2 = new Student("Иванова", 14, "География");
        Student s3 = new Student("Сидоров", 9, "Математика");
        Student s4 = new Student("Смирнов", 8, "Математика");
        Student s5 = new Student("Николаева", 10, "История");

        // Массив учителей
        Teacher[] teachArr = new Teacher[3];
        // Массив учеников
        Student[] studentsArr = new Student[2];

        // Школа
        School school = new School("Средняя школа №1", d);
            school.setTeachers(teachArr);
            school.addTeacher(t1, t2, t3);

            school.setStudents(studentsArr);
            school.addStudent(s1, s3);
///////////////////////////////////////////////////
            school.schoolDay();
///////////////////////////////////////////////////
        for (Student st : studentsArr) {
            if (st != null) {
                System.out.println(st.getName() + " " + st.getLevelKnowlege() + " " + st.getSchoolSubject());
            }
        }
    }
}
