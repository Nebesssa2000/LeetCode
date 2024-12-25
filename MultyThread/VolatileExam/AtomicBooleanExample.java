package MultyThread.VolatileExam;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {
    private final AtomicBoolean running = new AtomicBoolean(true);

    public void stop() {
        running.set(false);
    }

    public void run() {
        while (running.get()) {
            // Выполнение задачи
        }
    }

    public static void main(String[] args) {
        AtomicBooleanExample example = new AtomicBooleanExample();
        Thread thread = new Thread(example::run);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        example.stop();
    }
}
