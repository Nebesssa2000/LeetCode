package MultyThread.JoinExam;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread completed");
            latch.countDown(); // Уменьшение счетчика
        });

        thread.start();

        try {
            latch.await(); // Ожидание уменьшения счетчика до нуля
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed");
    }
}
