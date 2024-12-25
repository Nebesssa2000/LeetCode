package MultyThread.JoinExam;

/**
 * Проблема:
 * Использование Thread.join для ожидания завершения потока может быть неэффективным, так как основной поток блокируется
 * до завершения дочернего потока. Это может привести к снижению производительности и увеличению времени отклика.
 * Thread.join не предоставляет возможности для выполнения других задач во время ожидания или для обработки прерываний.
 * Где может встречаться:
 * В системах, где требуется ожидание завершения нескольких потоков, например, в системах обработки данных или в
 * системах тестирования.
 * В веб-приложениях, где требуется ожидание завершения асинхронных операций, таких как загрузка данных или выполнение запросов.
 */
public class JoinExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread completed");
        });

        thread.start();

        try {
            thread.join(); // Ожидание завершения потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed");
    }
}
