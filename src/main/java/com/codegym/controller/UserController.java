package com.codegym.controller;

import com.codegym.Service.UserService;
import com.codegym.model.Login;
import com.codegym.model.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = UserService.checkLogin(login);
        if (user == null) {
            return new ModelAndView("error");
        } else {
            ModelAndView modelAndView = new ModelAndView("helloUser");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
