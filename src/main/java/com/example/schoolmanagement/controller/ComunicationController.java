package com.example.schoolmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComunicationController {

        @GetMapping("/comunication")
        public String comunication() {
            return "comunication"; // Döndürülen değer, dönülecek view adını belirtir.
        }
    }
