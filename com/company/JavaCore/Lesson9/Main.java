package com.company.JavaCore.Lesson9;

import com.company.JavaCore.Lesson9.implementations.CourseImpl;
import com.company.JavaCore.Lesson9.implementations.StudentImpl;
import com.company.JavaCore.Lesson9.interfaces.Course;
import com.company.JavaCore.Lesson9.interfaces.Student;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course course1 = new CourseImpl("course1");
        Course course2 = new CourseImpl("course2");
        Course course3 = new CourseImpl("course3");

        Student student1 = new StudentImpl("student1", Arrays.asList(course1, course3));
        Student student2 = new StudentImpl("student2", Collections.singletonList(course2));
        Student student3 = new StudentImpl("student3", Collections.singletonList(course3));
        Student student4 = new StudentImpl("student4", Collections.singletonList(course3));

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        System.out.println(uniqueCourses(students));
        System.out.println(smartStudents(students));
        System.out.println(filterByCourse(students, course3));
    }

    public static List<Course> uniqueCourses(List<Student> students) {
        return students
                .stream()
                .map(Student::getAllCourses)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Student> smartStudents(List<Student> students) {
        return students
                .stream()
                .sorted(Comparator.comparingInt((Student o) -> o.getAllCourses().size())
                        .reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> filterByCourse(List<Student> students, Course course) {
        return students
                .stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}
