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

    @Autowired
    IUserService userService;

    @GetMapping("/login")
    public ModelAndView getLoginForm() {
        return new ModelAndView("login", "user", new User());
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute User user, HttpServletRequest req) {

        boolean isLogin = userService.login(user.getEmail(), user.getPassword());

        String message;
        if (isLogin) {
            message = "Đăng nhập thành công";
            req.getSession(true).setAttribute("isLogin", true);
        } else {
            message = "Đăng nhập thất bại";
            req.getSession(true).setAttribute("isLogin", false);
        }

        return new ModelAndView("login", "message", message);
    }
}
