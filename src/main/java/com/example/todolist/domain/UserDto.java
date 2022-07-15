package com.example.todolist.domain;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String passwordConfirm;
}
