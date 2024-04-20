package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.service.ITeacherServcie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeacherController {
    ITeacherServcie teacherServcie;
    @GetMapping("/teachers")
    public String listStudents( )
    {
        return "teachers";
    }
}
