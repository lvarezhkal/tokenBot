package pro.sky.telegrambot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.notification_task.NotificationTask;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<NotificationTask, Long> {

    List<NotificationTask> getNotificationTasksByTaskTime(final LocalDateTime time);

 }
