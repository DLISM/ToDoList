package com.example.todolist.service;

import com.example.todolist.domain.Task;
import com.example.todolist.domain.User;
import com.example.todolist.repository.TaskRepo;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepo taskRepo;


    public Task create(Task task, User user) {
        task.setAuthor(user);
        return taskRepo.save(task);
    }

    public void delete(Task task) {
        taskRepo.delete(task);
    }

    public Task update(Task taskFromDB, Task task) {

        taskFromDB.setText(task.getText());
        taskFromDB.setDone(task.getDone());

        return taskRepo.save(taskFromDB);
    }
}