package com.company.JavaCore.Lesson9.implementations;

import com.company.JavaCore.Lesson9.interfaces.Course;

public class CourseImpl implements Course {
    private final String name;

    public CourseImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
