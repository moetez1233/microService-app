package com.micro.school.controller;

import com.micro.school.entity.FullSchoolResponce;
import com.micro.school.entity.School;
import com.micro.school.service.SchoolImplement;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
    @Autowired
    private SchoolImplement schoolImplement;

    public static final String SCHOOL_service="schoolService";

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchool(@RequestBody School school) {
        schoolImplement.addSchool(school);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<School> getAllSchools(){

        return schoolImplement.getSchools();
    }
    @GetMapping("/with-students/{school-id}")
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = SCHOOL_service,fallbackMethod = "getSchoolWhenException")
    public Object getSchoolById(@PathVariable("school-id") Integer schoolId) {
       return schoolImplement.getSchoolWithStudents(schoolId);

    };
    public String getSchoolWhenException(Integer schoolId,Throwable throwable) {
        return "Student server is down ";
    }
}
