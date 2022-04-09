package com.company.JavaCore.Lesson1;

import java.util.Arrays;

public class Team  {
    private String name;
    private People[] peoples = new People[4];

    public Team(String name, People people1, People people2, People people3, People people4) {
        this.name = name;
        this.peoples[0] = people1;
        this.peoples[1] = people2;
        this.peoples[2] = people3;
        this.peoples[3] = people4;
    }

    public String getName() {
        return name;
    }

    public People[] getPeoples() {
        return peoples;
    }

    public People[] getSuccessPeoples() {
        return  Arrays.stream(peoples).filter(people -> people.getStamina() >= 0).toArray(People[]::new);
    }

    public String showResults() {
        return "Прошли полосу в команде " + name + ":\r\n" +
                Arrays.toString(getSuccessPeoples());
    }

    @Override
    public String toString() {
        return "Команда " + name + ":\r\n" + Arrays.toString(peoples);
    }
}
