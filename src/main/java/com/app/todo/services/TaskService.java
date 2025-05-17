package com.app.todo.services;


import com.app.todo.models.Task;
import com.app.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskrepo;

    public TaskService(TaskRepository taskrepo) {
        this.taskrepo = taskrepo;
    }

    public List<Task> getAllTasks() {
        return taskrepo.findAll();
    }

    public void creatTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setComplete(false);
        taskrepo.save(task);
    }

    public void deleteTask(Long id) {
        taskrepo.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskrepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));

        task.setComplete(!task.isComplete());
        taskrepo.save(task);



    }
}
