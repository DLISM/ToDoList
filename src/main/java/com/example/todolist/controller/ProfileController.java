package com.example.todolist.controller;

import com.example.todolist.domain.User;
import com.example.todolist.domain.Views;
import com.example.todolist.repository.UserRepo;
import com.example.todolist.service.UserService;
import com.example.todolist.util.UpdatePassword;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping
    @JsonView(Views.FullProfile.class)
    public User main(@AuthenticationPrincipal User user){
        return user;
    }

    @PutMapping
    @JsonView(Views.FullProfile.class)
    public User update(@AuthenticationPrincipal User userFromDB, @RequestBody User user){
        return userService.update(userFromDB, user);
    }

    @PutMapping("/update-password")
    public boolean updatePassword(@AuthenticationPrincipal User userFromDB,
                                  @RequestBody UpdatePassword updatePassword
                                  ){
        return userService.updatePassword(userFromDB, updatePassword);
    }
}
