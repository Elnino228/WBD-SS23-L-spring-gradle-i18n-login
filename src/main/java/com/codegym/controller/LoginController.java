package com.codegym.controller;


import com.codegym.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/")
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView("login");
        modelAndView.addObject("login",new Login());
        return modelAndView;
    }

    @PostMapping("/")
    public String dashboard(@ModelAttribute("login") Login login) {
        return "dashboard";
    }
}
