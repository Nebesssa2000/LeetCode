package MultyThread;

public class WaitNotifyExample {
    private final Object lock = new Object();
    private boolean condition = false;

    public void waitingMethod() {
        synchronized (lock) {
            while (!condition) { // Проверка условия в цикле для избежания ложных пробуждений
                try {
                    System.out.println("Waiting...");
                    lock.wait(); // Освобождение блокировки и ожидание
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Condition met, proceeding...");
        }
    }

    public void notifyingMethod() {
        synchronized (lock) {
            condition = true;
            lock.notify(); // Уведомление одного ожидающего потока
            System.out.println("Notified waiting thread...");
        }
    }

    public static void main(String[] args) {
        WaitNotifyExample example = new WaitNotifyExample();
        Thread t1 = new Thread(example::waitingMethod);
        Thread t2 = new Thread(example::notifyingMethod);

        t1.start();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        t2.start();
    }
}
