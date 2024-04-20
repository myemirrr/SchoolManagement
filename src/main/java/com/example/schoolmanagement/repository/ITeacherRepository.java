package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<Student, Long> {

}
