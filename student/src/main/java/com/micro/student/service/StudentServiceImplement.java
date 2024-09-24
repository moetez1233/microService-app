package com.micro.student.service;

import com.micro.student.entity.Student;
import com.micro.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplement implements StudentImplement{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllBySchoolId(Integer schoolId) {
        return studentRepository.findStudentBySchoolId(schoolId);
    }
}
