package MultyThread.DeadLock;

public class DeadlockSolution {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void method1() {
        synchronized (lock1) { // Поток 1 захватывает lock1
            System.out.println("Thread 1: Holding lock 1...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println("Thread 1: Waiting for lock 2...");
            synchronized (lock2) { // Поток 1 пытается захватить lock2
                System.out.println("Thread 1: Holding lock 1 & 2...");
            }
        }
    }

    public void method2() {
        synchronized (lock1) { // Поток 2 также захватывает lock1 сначала
            System.out.println("Thread 2: Holding lock 1...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            System.out.println("Thread 2: Waiting for lock 2...");
            synchronized (lock2) { // Поток 2 затем пытается захватить lock2
                System.out.println("Thread 2: Holding lock 1 & 2...");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockSolution example = new DeadlockSolution();
        Thread t1 = new Thread(example::method1);
        Thread t2 = new Thread(example::method2);

        t1.start();
        t2.start();
    }
}
