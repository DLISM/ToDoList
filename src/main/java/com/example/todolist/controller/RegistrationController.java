package com.example.todolist.controller;

import com.example.todolist.domain.User;
import com.example.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, @RequestParam("password2") String passwordConfirm, Model model){

        boolean isConfirm = StringUtils.hasText(passwordConfirm);
        if(!isConfirm){
            model.addAttribute("password2Error", "Password confirmation empty");
            return "index";
        }

        if(user.getPassword()!=null && !user.getPassword().equals(passwordConfirm)){
            model.addAttribute("passwordError", "Password are different");
            return "index";
        }

        if(!userService.addUser(user)){
            model.addAttribute("usernameError", "User exists!");
            return "index";
        }
        return "redirect:/login";
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
