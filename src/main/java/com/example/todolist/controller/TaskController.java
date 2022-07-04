package com.example.todolist.controller;

import com.example.todolist.domain.Task;
import com.example.todolist.domain.User;
import com.example.todolist.domain.Views;
import com.example.todolist.repository.TaskRepo;
import com.example.todolist.repository.UserRepo;
import com.example.todolist.service.TaskService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private UserRepo userRepo;


    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Task> list(@AuthenticationPrincipal User user){
        return taskRepo.findAll();
    }

    @GetMapping("{id}")
    public Task getTask(@PathVariable("id") Task task){
        return task;
    }

    @PostMapping
    @JsonView(Views.IdName.class)
    public Task addTask(@AuthenticationPrincipal User user, @RequestBody Task task){

       return taskService.create(task, user);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Task task){

        taskService.delete(task);
    }

    @PutMapping("{id}")
    public Task updateTask(@PathVariable("id") Task taskFromDB, @RequestBody Task task){

        return taskService.update(taskFromDB, task);
    }
}
