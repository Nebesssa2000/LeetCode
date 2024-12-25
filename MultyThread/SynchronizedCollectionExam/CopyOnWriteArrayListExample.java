package MultyThread.SynchronizedCollectionExam;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    private final List<Integer> list = new CopyOnWriteArrayList<>();

    public void addItem(int item) {
        list.add(item);
    }

    public int getItem(int index) {
        return list.get(index);
    }

    public static void main(String[] args) {
        CopyOnWriteArrayListExample example = new CopyOnWriteArrayListExample();
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
