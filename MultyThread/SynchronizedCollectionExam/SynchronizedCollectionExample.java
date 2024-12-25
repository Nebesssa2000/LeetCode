package MultyThread.SynchronizedCollectionExam;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Проблема:
 Использование synchronized для доступа к коллекциям может быть неэффективным и сложным в управлении, так как блокировка
 применяется ко всему методу или блоку кода, что может привести к узким местам и снижению производительности.
 synchronized не предоставляет гибкости для управления доступом к коллекциям, например, для итерации по коллекции или
 для выполнения сложных операций.
 Где может встречаться:
 В многопоточных приложениях, где требуется синхронизация доступа к коллекциям, например, в системах управления заказами
 для синхронизации доступа к спискам заказов или в системах управления проектами для синхронизации доступа к задачам.
 В веб-приложениях, где требуется синхронизация доступа к сессиям пользователей или кэшам.
 */
public class SynchronizedCollectionExample {
    private final List<Integer> list = new ArrayList<>();

    public synchronized void addItem(int item) {
        list.add(item);
    }

    public synchronized int getItem(int index) {
        return list.get(index);
    }

    public static void main(String[] args) {
        SynchronizedCollectionExample example = new SynchronizedCollectionExample();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.addItem(i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final list size: " + example.list.size());
    }
}
