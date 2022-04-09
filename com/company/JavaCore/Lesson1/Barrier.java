package com.company.JavaCore.Lesson1;

enum Barrier {
    HEIGHT_JUMP("Прыжки в высоту", 3), SWIMMING("Плавание", 2), STEEPLECHASE("Бег с препятствиями", 4);

    private String name;
    private int stamina;

    Barrier(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public int getStamina() {
        return stamina;
    }

    @Override
    public String toString() {
        return "Barrier{" +
                "name='" + name + '\'' +
                ", stamina=" + stamina +
                '}';
    }
}
