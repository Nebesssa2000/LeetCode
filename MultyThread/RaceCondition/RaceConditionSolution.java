package MultyThread.RaceCondition;

public class RaceConditionSolution {
    private int counter = 0;

    public synchronized void increment() {
        counter++; // Атомарная операция внутри синхронизированного блока
    }

    public static void main(String[] args) {
        RaceConditionSolution example = new RaceConditionSolution();
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
