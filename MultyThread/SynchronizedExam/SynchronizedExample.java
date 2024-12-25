package MultyThread.SynchronizedExam;

/**
 * Проблема:
 * Использование synchronized для блокировки может быть неэффективным в высоконагруженных системах, так как блокировка
 * применяется ко всему методу или блоку кода, что может привести к узким местам и снижению производительности.
 * synchronized не предоставляет гибкости для управления блокировками, например, для попытки захвата блокировки с
 * таймаутом или для проверки состояния блокировки.
 * Где может встречаться:
 * В многопоточных приложениях, где требуется синхронизация доступа к общим ресурсам, например, в банковских системах
 * для синхронизации доступа к счетам или в системах управления запасами для синхронизации доступа к складам.
 * В веб-приложениях, где требуется синхронизация доступа к сессиям пользователей или кэшам.
 */
public class SynchronizedExample {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();
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

        System.out.println("Final counter value: " + example.counter);
    }
}
