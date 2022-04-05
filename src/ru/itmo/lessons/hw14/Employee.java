package ru.itmo.lessons.hw14;

// Создать список объектов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.*;

public class Employee implements Comparable<Employee>{
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры

    public Employee(String name, String company) {
        setName(name);
        setCompany(company);
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        Comparator<Employee> employeeComparator1 = new NameComparator();

        Comparator<Employee> employeeComparator2 = new NameComparator()
                .thenComparing(new SalaryComparator());

        Comparator<Employee> employeeComparator3 = new NameComparator()
                .thenComparing(new SalaryComparator()
                .thenComparing(new AgeComparator())
                .thenComparing(new CompanyComparator()));

            TreeSet<Employee> treeSet1 = new TreeSet<>(employeeComparator1);
            TreeSet<Employee> treeSet2 = new TreeSet<>(employeeComparator2);
            TreeSet<Employee> treeSet3 = new TreeSet<>(employeeComparator3);
        //
        for (int i = 0; i < num; i++) {
            // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
            Employee employee = new Employee(names[(int) (Math.random() * (names.length))], companies[(int) (Math.random() * (companies.length))]);
            employee.randomAgeAndSalary();

            employees.add(employee);
            treeSet1.add(employee);
            treeSet2.add(employee);
            treeSet3.add(employee);
        }

        for (Employee e : treeSet1) {
            System.out.println(e.toString());
        }
        System.out.println("*****************************************");
        for (Employee e : treeSet2) {
            System.out.println(e.toString());
        }
        System.out.println("*****************************************");
        for (Employee e : treeSet3) {
            System.out.println(e.toString());
        }
        System.out.println("*****************************************");

        return employees;
    }
//////////////////////////
    public static void main(String[] args) {
        int num = 12;
        for (Employee e : employeeGenerator(num)) {
            System.out.println("Имя : " + e.getName() + ", компания: " + e.getCompany() + ", возраст: " + e.getAge() + ", зп: " + e.getSalary());
        }
        System.out.println("=========================");
    }

//////////////////////////
    public void randomAgeAndSalary() {
        int topSalary = 5000;
        int bottomSalary = 1000;
        int salaryRes = bottomSalary + (int) (Math.random() * (topSalary - bottomSalary + 1));

        int topAge = 60;
        int bottomAge = 21;
        int ageRes = bottomAge + (int) (Math.random() * (topAge - bottomAge + 1));

        this.setSalary(salaryRes);
        this.setAge(ageRes);
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getAge(), o.getAge());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Имя должно содержать хотя бы 1 символ.");
        }
        this.name = name;
    }

    public void setCompany(String company) {
        if (company.length() < 1) {
            throw new IllegalArgumentException("Название должно содержать хотя бы 1 символ.");
        }
        this.company = company;
    }

    public void setSalary(int salary) {
        if (salary < 1) {
            throw new IllegalArgumentException("Сотрудник не может работать бесплатно.");
        }
        this.salary = salary;
    }

    public void setAge(int age) {
        if (age < 21 || age > 60) {
            throw new IllegalArgumentException("Возраст не должен быть меньше 21 и больше 60.");
        }
        this.age = age;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, salary, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", age=" + age +
                ", company='" + company +
                '}';
    }
}


class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getAge(), e2.getAge());
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class CompanyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getCompany().compareTo(e2.getCompany());
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getSalary(), e2.getSalary());
    }
}