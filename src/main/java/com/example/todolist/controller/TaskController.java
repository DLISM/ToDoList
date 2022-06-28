package com.example.todolist.controller;

import com.example.todolist.domain.Task;
import com.example.todolist.repository.TaskListRepo;
import com.example.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskListRepo taskListRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<Task> main(){
        return taskListRepo.findAll();
    }

    @GetMapping("{id}")
    public Task getTask(@PathVariable("id") Task task){
        return task;
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskListRepo.save(task);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") Task task){
        taskListRepo.delete(task);
    }

    @PutMapping
    public Task updateTask(
            @RequestParam("id") Task task,
            @RequestParam("text") String text,
            @RequestParam("done") boolean done
    ){
            task.setText(text);
            task.setDone(done);
            return taskListRepo.save(task);
    }
}
