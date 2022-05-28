package com.company.JavaCore.Lesson9.implementations;

import com.company.JavaCore.Lesson9.interfaces.Course;
import com.company.JavaCore.Lesson9.interfaces.Student;

import java.util.List;

public class StudentImpl implements Student {
    private final String name;
    private final List<Course> courses;

    public StudentImpl(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}
