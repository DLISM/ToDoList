package com.example.todolist.util;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UpdatePassword {
    private String newPassword;
    private String newPasswordConfirmed;
}
