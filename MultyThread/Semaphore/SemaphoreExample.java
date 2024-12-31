package MultyThread.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Проблема:
 * В многопоточных приложениях может потребоваться ограничение количества потоков, которые могут одновременно получить
 * доступ к ресурсу. Без такого ограничения может возникнуть перегрузка ресурса, что приведет к снижению производительности или сбоям.
 * Решение:
 * Использование Semaphore позволяет ограничить количество потоков, которые могут одновременно получить доступ к ресурсу.
 * В данном примере семафор с 3 разрешениями позволяет только трем потокам одновременно получить доступ к ресурсу.
 * Где может встречаться:
 * В веб-серверах для ограничения количества одновременных подключений к базе данных.
 * В системах управления задачами для ограничения количества одновременно выполняемых задач.
 */
public class SemaphoreExample {
    private static final int MAX_CONCURRENT_THREADS = 3;
    private final Semaphore semaphore = new Semaphore(MAX_CONCURRENT_THREADS);

    public void accessResource() {
        try {
            semaphore.acquire(); // Захват семафора
            System.out.println(Thread.currentThread().getName() + " получил доступ к ресурсу");
            Thread.sleep(2000); // Симуляция работы с ресурсом
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " освобождает ресурс");
            semaphore.release(); // Освобождение семафора
        }
    }

    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();
        Runnable task = example::accessResource;

        for (int i = 0; i < 10; i++) {
            new Thread(task, "Поток " + i).start();
        }
    }
}
