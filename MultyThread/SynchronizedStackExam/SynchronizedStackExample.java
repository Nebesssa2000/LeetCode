package MultyThread.SynchronizedStackExam;

import java.util.Stack;

/**
 * Проблема:
 * Использование synchronized для доступа к стеку может быть неэффективным и сложным в управлении, так как блокировка
 * применяется ко всему методу или блоку кода, что может привести к узким местам и снижению производительности.
 * synchronized не предоставляет гибкости для управления доступом к стеку, например, для итерации по стеку или для
 * выполнения сложных операций.
 * Где может встречаться:
 * В многопоточных приложениях, где требуется синхронизация доступа к стекам, например, в системах обработки данных для
 * синхронизации доступа к стекам данных или в системах управления задачами для синхронизации доступа к стекам задач.
 * В веб-приложениях, где требуется синхронизация доступа к стекам запросов или ответов.
 */
public class SynchronizedStackExample {
    private final Stack<Integer> stack = new Stack<>();

    public synchronized void pushItem(int item) {
        stack.push(item);
    }

    public synchronized int popItem() {
        return stack.pop();
    }

    public static void main(String[] args) {
        SynchronizedStackExample example = new SynchronizedStackExample();
        Runnable producer = () -> {
            for (int i = 0; i < 1000; i++) {
                example.pushItem(i);
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 1000; i++) {
                example.popItem();
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

        System.out.println("Final stack size: " + example.stack.size());
    }
}
