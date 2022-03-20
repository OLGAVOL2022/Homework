package com.company.Lesson6;

public class Dog extends Animal {
    @Override
    public void swim(int length) {
        if (length <= 10 && length >= 0) {
            System.out.println("Собака проплыла " + length + "м");
        } else {
            System.out.println("Собака проплыть не может ");
        }
    }

    @Override
    public void run(int length) {
        if (length <= 500 && length >= 0) {
            System.out.println("Собака пробежала " + length + "м");
        } else {
            System.out.println("Собака пробежать не может ");
        }
    }
}
