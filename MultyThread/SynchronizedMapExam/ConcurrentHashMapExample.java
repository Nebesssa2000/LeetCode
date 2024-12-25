package MultyThread.SynchronizedMapExam;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    private final Map<Integer, String> map = new ConcurrentHashMap<>();

    public void putItem(int key, String value) {
        map.put(key, value);
    }

    public String getItem(int key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        ConcurrentHashMapExample example = new ConcurrentHashMapExample();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                example.putItem(i, "Value " + i);
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

        System.out.println("Final map size: " + example.map.size());
    }
}
