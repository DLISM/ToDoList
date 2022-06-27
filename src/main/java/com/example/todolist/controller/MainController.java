package com.example.todolist.controller;

import com.example.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public String main(){
        System.out.println(userRepo.findAll());
        return "index";
    }
}
