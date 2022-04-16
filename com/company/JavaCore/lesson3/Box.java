package com.company.JavaCore.lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits;


    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public double getWeight() {
        double sum = 0;
        for (int i = 0; i < fruits.size(); i++) {
            sum += fruits.get(i).getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> o) {
        if (this == o) return true; //если переданный параметр- это та же коробка
        if (o == null || getClass() != o.getClass())
            return false;//если переданный параметр не существует или не тот класс

        return fruits.equals(o.fruits);//если фрукты не равны
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void sprinkle(Box<T> other) {
        if (other == null) return;

        //перебираем все фрукты и каждый фрукт добавляем в другую корзину

        for (T fruit : fruits) {
            other.add((fruit));
        }

        fruits.clear();// текущая коробка стала пустой
    }
}

