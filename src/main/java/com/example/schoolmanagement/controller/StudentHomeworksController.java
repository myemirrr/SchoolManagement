package com.example.schoolmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentHomeworksController
{
    @GetMapping("/student/homeworks")
    public String Homeworks() {
        return "student/homeworks";
    }
}
