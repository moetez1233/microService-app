package com.micro.student.controller;

import com.micro.student.entity.Student;
import com.micro.student.repository.StudentRepository;
import com.micro.student.service.StudentImplement;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentImplement studentImplement;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        studentImplement.addStudent(student);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(){
        return studentImplement.getStudents();
    }
}
