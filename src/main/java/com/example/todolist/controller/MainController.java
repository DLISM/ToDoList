package com.example.todolist.controller;

import com.example.todolist.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${spring.profile.active}")
    private String profile;

    @GetMapping
    public String main(@AuthenticationPrincipal User user, Model model){
        if(user!=null){
            model.addAttribute("profile", true);
        }
        else {
            model.addAttribute("profile", false);
        }
        model.addAttribute("isDevMode", true);
        return "index";
    }
}
