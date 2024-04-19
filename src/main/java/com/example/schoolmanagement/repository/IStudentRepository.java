package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {

}
