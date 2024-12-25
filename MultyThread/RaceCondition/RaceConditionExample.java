package MultyThread.RaceCondition;

public class RaceConditionExample {
    private int counter = 0;

    public void increment() {
        counter++; // Неатомарная операция
    }

    public static void main(String[] args) {
        RaceConditionExample example = new RaceConditionExample();
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
