package MultyThread.SynchronizedMapExam;

import java.util.HashMap;
import java.util.Map;

/**
 * Проблема:
 * Использование synchronized для доступа к карте может быть неэффективным и сложным в управлении, так как блокировка
 * применяется ко всему методу или блоку кода, что может привести к узким местам и снижению производительности.
 * synchronized не предоставляет гибкости для управления доступом к карте, например, для итерации по карте или для
 * выполнения сложных операций.
 * Где может встречаться:
 * В многопоточных приложениях, где требуется синхронизация доступа к картам, например, в системах управления
 * пользователями для синхронизации доступа к картам пользователей или в системах управления конфигурацией для
 * синхронизации доступа к картам конфигураций.
 * В веб-приложениях, где требуется синхронизация доступа к картам сессий пользователей или кэшам.
 */
public class SynchronizedMapExample {
    private final Map<Integer, String> map = new HashMap<>();

    public synchronized void putItem(int key, String value) {
        map.put(key, value);
    }

    public synchronized String getItem(int key) {
        return map.get(key);
    }

    public static void main(String[] args) {
        SynchronizedMapExample example = new SynchronizedMapExample();
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
