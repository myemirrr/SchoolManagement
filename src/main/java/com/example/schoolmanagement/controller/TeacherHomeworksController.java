package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Homework;
import com.example.schoolmanagement.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher/homeworks")
public class TeacherHomeworksController {

    private final HomeworkService homeworkService;

    @Autowired
    public TeacherHomeworksController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping
    public String getAllHomeworks(Model model) {
        model.addAttribute("homeworks", homeworkService.getAllHomeworks());
        return "teacher/homeworks";
    }

    @GetMapping("/{id}")
    public String getHomeworkById(@PathVariable("id") Long id, Model model) {
        Homework homework = homeworkService.getHomeworkById(id);
        model.addAttribute("homework", homework);
        return "homework-details";
    }

    @PostMapping
    public String addHomework(@ModelAttribute("homework") Homework homework) {
        homeworkService.addHomework(homework);
        return "redirect:/teacher/homeworks";
    }

    @PutMapping("/{id}")
    public String updateHomework(@PathVariable("id") Long id, @ModelAttribute("homework") Homework homework) {
        homework.setId(id);
        homeworkService.updateHomework(homework);
        return "redirect:/teacher/homeworks";
    }

    @DeleteMapping("/{id}")
    public String deleteHomework(@PathVariable("id") Long id) {
        homeworkService.deleteHomework(id);
        return "redirect:/teacher/homeworks";
    }
}
