package MultyThread.SynchronizedCounterExam;

import java.util.concurrent.atomic.AtomicInteger;
public class AtomicIntegerExample { private final AtomicInteger counter = new AtomicInteger(0);
    public void increment() {
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }

    public static void main(String[] args) {
        AtomicIntegerExample example = new AtomicIntegerExample();
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
