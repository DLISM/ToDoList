package com.example.todolist.controller;

import com.example.todolist.domain.TaskList;
import com.example.todolist.repository.TaskListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private TaskListRepo dolistRepo;

    @GetMapping
    public List<TaskList> main(){
        TaskList taskList = new TaskList();
        taskList.setDone(true);
        taskList.setText("Create controller");
        dolistRepo.save(taskList);
        return dolistRepo.findAll();
    }

    @GetMapping("{id}")
    public TaskList getTask(@PathVariable("id") TaskList task){
        return task;
    }
}
