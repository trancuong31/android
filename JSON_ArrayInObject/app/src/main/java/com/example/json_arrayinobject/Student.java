package com.example.json_arrayinobject;

import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<Course> courseList;

    public Student(String name, int age, List<Course> courseList) {
        this.name = name;
        this.age = age;
        this.courseList = courseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
