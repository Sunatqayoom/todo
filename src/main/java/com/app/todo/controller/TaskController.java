package com.app.todo.controller;

import com.app.todo.models.Task;
import com.app.todo.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {

    public final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getasks(Model model){
        List<Task> tasks =  taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";

    }

    @PostMapping
    public String creatTasks(@RequestParam String title){
        taskService.creatTask(title);
        return "redirect:/";


    }
}
