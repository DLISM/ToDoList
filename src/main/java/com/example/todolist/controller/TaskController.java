package com.example.todolist.controller;

import com.example.todolist.domain.Task;
import com.example.todolist.domain.User;
import com.example.todolist.repository.TaskRepo;
import com.example.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;


    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public List<Task> list(@AuthenticationPrincipal User user){
        return taskRepo.findAll();
    }

    @GetMapping("{id}")
    public Task getTask(@PathVariable("id") Task task){
        return task;
    }

    @PostMapping
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
