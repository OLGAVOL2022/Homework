package com.company.Lesson5;

public class Employee {

    public String name;
    public String prof;
    public String email;
    public String phoneNumber;
    public int salary;
    public int age;


    public int getAge() {
        return age;
    }

    public Employee(String name, String prof, String email, String phoneNumber, int salary, int age) {
        this.name = "name";
        this.prof = "prof";
        this.email = "email";
        this.phoneNumber = "phoneNumber";
        this.salary = salary;
        this.age = age;
    }

    public void print() {
        System.out.println("Имя: " + name + " | " + " Должность: " + prof + " | " + " e-mail: " + email + " | " +
                " Тел.: " + phoneNumber + " | " + " ЗП: " + salary + " | " + " Возраст: " + age);


    }
}
