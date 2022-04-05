package com.company.Lesson5;

public class Main {


    public static void main(String[] args) {


        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivanov@mail.ru", "89164523", 30000, 45);

        employeeArray[1] = new Employee("Sidorov Petr", "Welder", "sidorov@mail.ru", "89245789", 25000, 40);

        employeeArray[2] = new Employee("Belaya Elena", "Accountant", "belaya@mail.ru", "89545622", 35000, 35);

        employeeArray[3] = new Employee("Sergey Miheev", "Operator", "miheev2@mail.ru", "8984545", 27000, 35);

        employeeArray[4] = new Employee("Valentina Potapova", "Tech.staff", "potapova@mail.ru", "89845235", 15000, 54);


        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getAge() > 40) {
                employeeArray[i].print();
            }
        }
    }
}
