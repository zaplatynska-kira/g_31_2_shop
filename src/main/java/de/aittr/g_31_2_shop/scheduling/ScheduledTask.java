package de.aittr.g_31_2_shop.scheduling;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
@EnableScheduling
public class ScheduledTask {

    private final List<String> recentTasks = new ArrayList<>();

    //@Scheduled(cron = "*/30 * * * * *")
    @Scheduled(fixedRateString = "PT30S")
    public void scheduledTask() {
        String taskResult = performTask();
        addToRecentTasks(taskResult);

        if (recentTasks.size() == 5) {
            // Выводим в консоль, когда выполнены все пять задач
            System.out.println("Все пять задач выполнены.");
        }
    }

    private String performTask() {
        String result = "Задача выполнена в " + LocalDateTime.now();
        System.out.println(result);
        return result;
    }

    private void addToRecentTasks(String taskResult) {
        recentTasks.add(taskResult);
        if (recentTasks.size() > 5) {
            recentTasks.remove(0);
        }
    }

}





