package com.codegym.controller;


import com.codegym.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class LoginController {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @GetMapping("/")
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("login1");
        Locale locale=localeResolver.resolveLocale(request);
        modelAndView.addObject("login",new Login());
        modelAndView.addObject("locale",locale);
        modelAndView.addObject("messageSource",messageSource);
        return modelAndView;
    }

    @PostMapping("/")
    public String dashboard(@ModelAttribute("login") Login login) {
        return "dashboard";
    }
}
