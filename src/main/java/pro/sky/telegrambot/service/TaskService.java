package pro.sky.telegrambot.service;

import org.springframework.stereotype.Service;
import pro.sky.telegrambot.notification_task.NotificationTask;
import pro.sky.telegrambot.repositories.TaskRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(final TaskRepository repository) {
        this.repository = repository;
    }

    public NotificationTask create(Long chatId, String taskTime, String text) {
        LocalDateTime dateTime = LocalDateTime.parse(taskTime, DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm"));

        NotificationTask task = new NotificationTask();
        task.setChatId(chatId);
        task.setTaskTime(dateTime);
        task.setTaskMessage(text);

        return repository.save(task);
    }

    public List<NotificationTask> getNotificationTasksByTaskTime(LocalDateTime time) {
        return repository.getNotificationTasksByTaskTime(time);
     }

}
