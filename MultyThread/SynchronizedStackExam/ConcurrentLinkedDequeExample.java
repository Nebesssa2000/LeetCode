package MultyThread.SynchronizedStackExam;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeExample {
    private final Deque<Integer> deque = new ConcurrentLinkedDeque<>();

    public void pushItem(int item) {
        deque.push(item);
    }

    public int popItem() {
        return deque.pop();
    }

    public static void main(String[] args) {
        ConcurrentLinkedDequeExample example = new ConcurrentLinkedDequeExample();
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

        System.out.println("Final deque size: " + example.deque.size());
    }
}
