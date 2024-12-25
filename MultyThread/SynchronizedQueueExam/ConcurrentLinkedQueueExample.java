package MultyThread.SynchronizedQueueExam;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    private final Queue<Integer> queue = new ConcurrentLinkedQueue<>();

    public void addItem(int item) {
        queue.add(item);
    }

    public int removeItem() {
        return queue.poll();
    }

    public static void main(String[] args) {
        ConcurrentLinkedQueueExample example = new ConcurrentLinkedQueueExample();
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
