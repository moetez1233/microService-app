package com.micro.school.service;

import com.micro.school.entity.School;
import com.micro.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImplement implements SchoolImplement {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public void addSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }
}
