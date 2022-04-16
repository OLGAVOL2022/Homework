package com.company.JavaCore.lesson3;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Apple> apples = new ArrayList<>(10);
        ArrayList<Orange> oranges = new ArrayList<>(10);


        for (int i = 0; i < 10; i++) {
            apples.set(i, new Apple(1.0));
        }


        for (int i = 0; i < 10; i++) {
            oranges.set(i, new Orange(1.5));
        }

        Box<Apple> box = new Box<>(apples);
        Box<Orange> box1 = new Box<>(oranges);
    }

}

