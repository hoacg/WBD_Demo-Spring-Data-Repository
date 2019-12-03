package com.codegym.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest req, HttpServletResponse resp) {

        Object getLogin = req.getSession().getAttribute("isLogin");

        boolean isLogin = false;

        if (getLogin != null) {
            isLogin = (boolean) getLogin;
        }

        if (isLogin)
            return "index";
        else
            return "error";
    }

    @GetMapping("/user")
    public String getUserView() {
        return "user";
    }
}
