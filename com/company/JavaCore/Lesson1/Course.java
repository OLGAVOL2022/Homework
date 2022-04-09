package com.company.JavaCore.Lesson1;

public class Course {
    private Barrier[] barriers;

    public Course(Barrier[] barriers) {
        this.barriers = barriers;
    }

    void doIt(Team team) {
        for (People people: team.getPeoples()) {
            people.doIt(barriers);
        }
    }
}
