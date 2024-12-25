package MultyThread.SynchronizedQueueExam;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Проблема:
 * Использование synchronized для доступа к очереди может быть неэффективным и сложным в управлении, так как блокировка
 * применяется ко всему методу или блоку кода, что может привести к узким местам и снижению производительности.
 * synchronized не предоставляет гибкости для управления доступом к очереди, например, для итерации по очереди или для
 * выполнения сложных операций.
 * Где может встречаться:
 * В многопоточных приложениях, где требуется синхронизация доступа к очередям, например, в системах обработки сообщений
 * для синхронизации доступа к очередям сообщений или в системах управления задачами для синхронизации доступа к очередям задач.
 * В веб-приложениях, где требуется синхронизация доступа к очередям запросов или ответов.
 */
public class SynchronizedQueueExample {
    private final Queue<Integer> queue = new LinkedList<>();

    public synchronized void addItem(int item) {
        queue.add(item);
    }

    public synchronized int removeItem() {
        return queue.poll();
    }

    public static void main(String[] args) {
        SynchronizedQueueExample example = new SynchronizedQueueExample();
        Runnable producer = () -> {
            for (int i = 0; i < 1000; i++) {
                example.addItem(i);
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 1000; i++) {
                example.removeItem();
            }
        };

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final queue size: " + example.queue.size());
    }
}
