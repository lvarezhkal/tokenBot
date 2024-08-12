package pro.sky.telegrambot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.telegrambot.notification_task.NotificationTask;
import pro.sky.telegrambot.repositories.TaskRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static pro.sky.telegrambot.constants.TaskConstants.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService service;

    @Test
    void createNotificationTaskTest() {
        NotificationTask task1 = new NotificationTask();
        task1.setChatId(1L);
        LocalDateTime dateTime = LocalDateTime.parse("2024-08-12 18:37:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        task1.setTaskTime(dateTime);
        task1.setTaskMessage("Текст задания");

        when(repository.save(task1)).thenReturn(task1);

        assertThat(task1).isSameAs(service.create(1L, "12.08.2024 18:37", "Текст"));

        verify(repository).save(task1);
        verify(repository, times(1)).save(task1);
    }

    @Test
    void getNotificationTasksByTaskTime() {
        LocalDateTime dateTime = LocalDateTime.parse("2024-08-12 18:37:00",
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        when(repository.getNotificationTasksByTaskTime(dateTime))
                .thenReturn(TASK_LIST);

        assertThat(repository.getNotificationTasksByTaskTime(dateTime))
                .hasSize(3)
                .containsExactlyInAnyOrder(TASK_3, TASK_1, TASK_2);
     }

}
