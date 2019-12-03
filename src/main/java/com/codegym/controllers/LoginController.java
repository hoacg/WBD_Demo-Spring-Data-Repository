package com.codegym.controllers;

import com.codegym.models.User;
import com.codegym.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView getLoginForm() {
        return new ModelAndView("login", "user", new User());
    }

}
