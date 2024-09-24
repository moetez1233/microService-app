package com.micro.school.entity;

import java.util.ArrayList;
import java.util.List;

public class FullSchoolResponce {
    private String name;
    private String email;
    List<Student> students = new ArrayList<>();

    public FullSchoolResponce() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
