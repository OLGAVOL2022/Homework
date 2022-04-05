package com.company.Lesson6;

public class Cat extends Animal {

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать");
    }

    @Override
    public void run(int length) {
        if (length <= 200 && length >= 0) {
            System.out.println("Кот пробежал" + length + "м");
        } else {
            System.out.println("Кот пробежать не может");
        }
    }
}
