package com.company.Lesson7;

public class Cat {
    private String name;
    private int appetit;
    private boolean satiety = false;

    public Cat(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
    }

    public void eat(Plate plate) {
        int newFood = plate.getFood() - appetit;
        if (plate.getFood() >= appetit) {
            plate.setFood(newFood);
            satiety = true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
