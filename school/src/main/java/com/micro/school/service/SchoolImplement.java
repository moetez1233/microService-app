package com.micro.school.service;

import com.micro.school.entity.School;

import java.util.List;

public interface SchoolImplement {
    public void addSchool(School school);
    public List<School> getSchools();
}
