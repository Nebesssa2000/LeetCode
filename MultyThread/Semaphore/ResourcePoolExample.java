package MultyThread.Semaphore;

import java.util.concurrent.Semaphore;

/**
 *Проблема:
 * В многопоточных приложениях может потребоваться ограничение количества потоков, которые могут одновременно
 * использовать пул ресурсов. Без такого ограничения может возникнуть перегрузка пула ресурсов, что приведет к снижению
 * производительности или сбоям.
 * Решение:
 * Использование Semaphore позволяет ограничить количество потоков, которые могут одновременно использовать пул ресурсов.
 * В данном примере семафор с 5 разрешениями позволяет только пяти потокам одновременно использовать ресурс.
 * Где может встречаться:
 * В системах управления подключениями для ограничения количества одновременных подключений к серверу.
 * В системах управления задачами для ограничения количества одновременно выполняемых задач из пула задач.
 */
public class ResourcePoolExample {
    private static final int MAX_AVAILABLE = 5;
    private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true);

    public void useResource() {
        try {
            semaphore.acquire(); // Захват семафора
            System.out.println(Thread.currentThread().getName() + " использует ресурс");
            Thread.sleep(1000); // Симуляция работы с ресурсом
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " освобождает ресурс");
            semaphore.release(); // Освобождение семафора
        }
    }

    public static void main(String[] args) {
        ResourcePoolExample example = new ResourcePoolExample();
        Runnable task = example::useResource;

        for (int i = 0; i < 10; i++) {
            new Thread(task, "Поток " + i).start();
        }
    }
}
