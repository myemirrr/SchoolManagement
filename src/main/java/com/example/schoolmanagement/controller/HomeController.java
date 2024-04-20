package com.example.schoolmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index()
    {
        return "index"; // Döndürülen değer, dönülecek view adını belirtir.
    }
}
