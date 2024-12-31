package MultyThread.Semaphore;

import java.util.concurrent.Semaphore;

/**
 * Проблема:
 * В многопоточных приложениях может потребоваться синхронизация доступа к критической секции, чтобы предотвратить
 * одновременное выполнение критической секции несколькими потоками. Без такой синхронизации может возникнуть
 * race-condition, что приведет к некорректному поведению программы.
 * Решение:
 * Использование Semaphore с одним разрешением позволяет синхронизировать доступ к критической секции, гарантируя, что
 * только один поток может выполнять критическую секцию в любой момент времени.
 * Где может встречаться:
 * В банковских системах для синхронизации доступа к счетам клиентов.
 * В системах управления запасами для синхронизации доступа к складам.
 */
public class CriticalSectionExample {
    private final Semaphore semaphore = new Semaphore(1);

    public void accessCriticalSection() {
        try {
            semaphore.acquire(); // Захват семафора
            System.out.println(Thread.currentThread().getName() + " вошел в критическую секцию");
            Thread.sleep(1000); // Симуляция работы в критической секции
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " выходит из критической секции");
            semaphore.release(); // Освобождение семафора
        }
    }

    public static void main(String[] args) {
        CriticalSectionExample example = new CriticalSectionExample();
        Runnable task = example::accessCriticalSection;

        for (int i = 0; i < 10; i++) {
            new Thread(task, "Поток " + i).start();
        }
    }
}
