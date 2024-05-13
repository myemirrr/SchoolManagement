package com.example.schoolmanagement.controller;

import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "e", required = false) Boolean error){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Giriş Yap");
        if (error != null){

            LoggerFactory.getLogger(LoggerFactory.class).warn("Sayfa Hatası");
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
            LoggerFactory.getLogger(LoggerFactory.class).error("Kimlik Doğrulama Hatası");
            return "redirect:/logout";
        }
    }
}
