package MultyThread.SynchronizedCounterExam;

/**
 * Проблема:
 * Использование synchronized для доступа к счетчику может быть неэффективным и сложным в управлении, так как блокировка
 * применяется ко всему методу или блоку кода, что может привести к узким местам и снижению производительности.
 * synchronized не предоставляет гибкости для управления доступом к счетчику, например, для выполнения атомарных
 * операций инкремента и декремента.
 * Где может встречаться:
 * В многопоточных приложениях, где требуется синхронизация доступа к счетчикам, например, в системах мониторинга для
 * синхронизации доступа к счетчикам событий или в системах управления ресурсами для синхронизации доступа к счетчикам ресурсов.
 * В веб-приложениях, где требуется синхронизация доступа к счетчикам запросов или ответов.
 */
public class SynchronizedCounterExample { private int counter = 0;
    public synchronized void increment() {
        counter++;
    }

    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        SynchronizedCounterExample example = new SynchronizedCounterExample();
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
