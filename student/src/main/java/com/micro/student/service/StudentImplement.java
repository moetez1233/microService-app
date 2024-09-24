package com.micro.student.service;

import com.micro.student.entity.Student;

import java.util.List;

public interface StudentImplement {
    public void addStudent(Student student);
    public List<Student> getStudents();
    public List<Student> findAllBySchoolId(Integer schoolId);
}
