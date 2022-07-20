package com.example.todolist.service;

import com.example.todolist.domain.Task;
import com.example.todolist.domain.User;
import com.example.todolist.repository.TaskRepo;
import com.example.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;


    public Task create(Task task, User user) {
        task.setAuthor(user);
        return taskRepo.save(task);
    }

    public void delete(Task task) {
        taskRepo.delete(task);
    }

    public Task update(Task taskFromDB, Task task) {

        if(StringUtils.hasText(task.getText())){
            taskFromDB.setText(task.getText());
        }

        taskFromDB.setDone(task.getDone());

        return taskRepo.save(taskFromDB);
    }
}
