package com.micro.school.controller;

import com.micro.school.entity.School;
import com.micro.school.service.SchoolImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
    @Autowired
    private SchoolImplement schoolImplement;

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
}
