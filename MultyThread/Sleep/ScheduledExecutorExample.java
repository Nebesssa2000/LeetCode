package MultyThread.Sleep;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Task started");
            System.out.println("Task completed");
        };

        scheduler.schedule(task, 5, TimeUnit.SECONDS); // Планирование задачи через 5 секунд
        scheduler.shutdown();
    }
}
