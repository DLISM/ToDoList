package com.example.todolist.controller;

import com.example.todolist.domain.User;
import com.example.todolist.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping
    @JsonView(Views.FullProfile.class)
    public User main(@AuthenticationPrincipal User user){
        return user;
    }
}
