package com.micro.school.service;

import com.micro.school.entity.FullSchoolResponce;
import com.micro.school.entity.School;
import com.micro.school.repository.SchoolRepository;
import com.micro.school.service.client.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImplement implements SchoolImplement {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public void addSchool(School school) {
        schoolRepository.save(school);
    }

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public FullSchoolResponce getSchoolWithStudents(Integer schoolId) {
        var school=schoolRepository.findById(schoolId.longValue()).orElse(
                null
        );
        var students = studentClient.findAllStudentBySchoolId(schoolId);
        FullSchoolResponce fullSchoolResponce=new FullSchoolResponce();
        fullSchoolResponce.setStudents(students);
        fullSchoolResponce.setEmail(school.getEmail());
        fullSchoolResponce.setName(school.getName());

        return fullSchoolResponce;
    }
}
