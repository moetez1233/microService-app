package com.micro.student.repository;

import com.micro.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
   @Query(value = "select * from student where school_id=:schoolId",nativeQuery = true)
    List<Student> findStudentBySchoolId(@Param("schoolId") Integer schoolId);
}
