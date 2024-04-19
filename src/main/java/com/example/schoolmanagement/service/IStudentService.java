package com.example.schoolmanagement.service;

import java.util.List;

import com.example.schoolmanagement.model.Student;

public interface IStudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}