package com.example.schoolmanagement.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "e", required = false) Boolean error){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Log in");
        if (error != null){

            LoggerFactory.getLogger(LoggerFactory.class).warn("PAGE ERROR :: Check on how to sort and add custom page for general app");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/login/success", method = RequestMethod.GET)
    public String loginSuccess(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            LoggerFactory.getLogger(LoggerFactory.class).warn("AUTH :: " + auth.getAuthorities().toString());
            Object[] authorities = auth.getAuthorities().toArray();
            String authy = null;
            if (authorities.length == 1){ for (Object authority: authorities) { authy = String.valueOf(authority); } }
            if (authy != null && authy.equals("STUDENT")){
                return "redirect:/student/home";
            } else if (authy != null && authy.equals("TEACHER")){
                return "redirect:/teacher/home";
            } else {
                return "redirect:/logout";
            }
        } else {
            LoggerFactory.getLogger(LoggerFactory.class).error("AUTH ERROR :: Auth is null");
            return "redirect:/logout";
        }
    }
}
