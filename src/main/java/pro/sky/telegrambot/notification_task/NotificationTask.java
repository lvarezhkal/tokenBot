package pro.sky.telegrambot.notification_task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class NotificationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long chatId;
    private String taskMessage;
    private LocalDateTime taskTime;

    public NotificationTask() {
    }

    public NotificationTask(final Long id, final Long chatId, final String taskMessage, final LocalDateTime taskTime) {
        this.id = id;
        this.chatId = chatId;
        this.taskMessage = taskMessage;
        this.taskTime = taskTime;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(final Long chatId) {
        this.chatId = chatId;
    }

    public String getTaskMessage() {
        return taskMessage;
    }

    public void setTaskMessage(final String taskMessage) {
        this.taskMessage = taskMessage;
    }

    public LocalDateTime getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(final LocalDateTime taskTime) {
        this.taskTime = taskTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final NotificationTask that = (NotificationTask) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NotificationTask{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", taskText='" + taskMessage + '\'' +
                ", taskTime=" + taskTime +
                '}';
    }
}
