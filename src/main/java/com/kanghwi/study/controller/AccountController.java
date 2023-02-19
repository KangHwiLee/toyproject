package com.kanghwi.study.controller;

import com.kanghwi.study.Service.UserService;
import com.kanghwi.study.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account")
@Controller
public class AccountController {

    @Autowired private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "account/login";
    }


    @GetMapping("/register")
    public String register(){


        return "account/register";
    }

    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        return "redirect:/";
    }
}
