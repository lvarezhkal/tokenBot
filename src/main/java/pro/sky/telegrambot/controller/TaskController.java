package pro.sky.telegrambot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.telegrambot.notification_task.NotificationTask;
import pro.sky.telegrambot.repositories.TaskRepository;

import java.util.List;

@RestController
public class TaskController {
    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/user/all")
    public List<NotificationTask> allTask() {
        return taskRepository.findAll();
     }
}
