package MultyThread.SynchronizedMethodExam;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMethodExample {
    private final ReentrantLock lock = new ReentrantLock();
    private int counter = 0;

    public void increment() {
        lock.lock(); // Захват блокировки
        try {
            counter++;
        } finally {
            lock.unlock(); // Освобождение блокировки
        }
    }

    public int getCounter() {
        lock.lock(); // Захват блокировки
        try {
            return counter;
        } finally {
            lock.unlock(); // Освобождение блокировки
        }
    }

    public static void main(String[] args) {
        ReentrantLockMethodExample example = new ReentrantLockMethodExample();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
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

        System.out.println("Final counter value: " + example.getCounter());
    }
}
