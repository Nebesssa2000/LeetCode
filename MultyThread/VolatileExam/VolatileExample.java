package MultyThread.VolatileExam;

/**
 * Проблема:
 * volatile обеспечивает видимость изменений переменной между потоками, но не гарантирует атомарность операций.
 * Это может привести к некорректному поведению в многопоточном окружении, особенно при выполнении сложных операций,
 * таких как инкремент или декремент.
 * volatile не подходит для синхронизации сложных операций, так как не обеспечивает блокировку и не предотвращает race-condition.
 * Где может встречаться:
 * В системах реального времени, где требуется быстрое обновление состояния, например, в системах мониторинга или управления.
 * В игровых приложениях, где требуется синхронизация состояния игры между потоками.
 */
public class VolatileExample {
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public void run() {
        while (running) {
            // Выполнение задачи
        }
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        Thread thread = new Thread(example::run);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        example.stop();
    }
}
