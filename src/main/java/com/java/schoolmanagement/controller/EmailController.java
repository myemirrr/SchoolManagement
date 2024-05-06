package com.java.schoolmanagement.controller;

import com.java.schoolmanagement.service.EmailSenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @GetMapping("/communication")
    public String showCommunication() {
        return "/communication";
    }

    @PostMapping("/student/communication")
    public String sendEmail(@RequestParam("to") String to,
                            @RequestParam("subject") String subject,
                            @RequestParam("message") String message) {
        this.emailSenderService.sendEmail(to, subject, message);

        return "redirect:/student/home";
    }
}
