package com.example.todolist.controller;

import com.example.todolist.domain.User;
import com.example.todolist.domain.UserDto;
import com.example.todolist.domain.Views;
import com.example.todolist.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    @JsonView(Views.IdName.class)
    public UserDto addUser(@RequestBody UserDto user){

        if(user.getPassword()!=null && !user.getPassword().equals(user.getPasswordConfirm())){
            return user;
        }

        if(!userService.addUser(user)){
            return user;
        }
        return user;
    }

    @GetMapping("/activate/{code}")
    private String activate(@PathVariable String code, Model model){

        boolean isActivate = userService.activateUser(code);

        if(isActivate){
            model.addAttribute("message", "Профиль пользователя успешно активирован!");
        }else {
            model.addAttribute("message", "Код активации не найдено!");
        }
        return "login";
    }
}
