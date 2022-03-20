package ru.itmo.lessons.lesson7.hw07;

public class SchoolApp {
    public static void main(String[] args) {
        // Директор
        Director d = new Director("Геннадий Александрович", 54);

        // Учителя
        Teacher t1 = new Teacher("Варвара Петровна", 51);
        t1.setTeachSubject("География");
        t1.setTeacherLevel(7);

        Teacher t2 = new Teacher("Валерий Николаевич", 44);
        t2.setTeachSubject("История");
        t2.setTeacherLevel(6);

        Teacher t3 = new Teacher("Людмила Алексеевна", 37);
        t3.setTeachSubject("Математика");
        t3.setTeacherLevel(8);

        // Студенты
        Student s1 = new Student("Петров", 12);
        s1.setSchoolSubject("География");
        s1.setLevelKnowlege(2);

        Student s2 = new Student("Иванова", 14);
        s2.setSchoolSubject("География");
        s2.setLevelKnowlege(3);

        Student s3 = new Student("Сидоров", 9);
        s3.setSchoolSubject("Математика");
        s3.setLevelKnowlege(1);

        Student s4 = new Student("Смирнов", 8);
        s4.setSchoolSubject("Математика");
        s4.setLevelKnowlege(0);

        Student s5 = new Student("Николаева", 10);
        s5.setSchoolSubject("История");
        s5.setLevelKnowlege(4);

        // Массив учителей
        Teacher[] teachArr = new Teacher[3];
        // Массив учеников
        Student[] studentsArr = new Student[2];

        // Школа
        School school = new School("Средняя школа №1", d);
        school.setTeachers(teachArr);
        school.addTeacher(t1, t2, t3);

        school.setStudents(studentsArr);
        school.addStudent(s4, s5);
///////////////////////////////////////////////////
        school.schoolDay(d, teachArr, studentsArr);

        for (Student st : studentsArr) {
            System.out.println(st.getName() + " " + st.getLevelKnowlege() + " " + st.getSchoolSubject());
        }

        /*System.out.println("учителя: ");
        for (Teacher tea : teachArr) {
            if (tea != null) {
                System.out.print(tea.getName() + ", ");
                System.out.println("Предмет " + tea.getTeachSubject());
            }
        }
        System.out.println();
        System.out.println("ученики: ");
        for (Student stu : studentsArr) {
            if (stu != null) {
                System.out.print(stu.getName() + ", ");
                System.out.println("Предмет " + stu.getSchoolSubject());
            }
        }*/
    }
}
