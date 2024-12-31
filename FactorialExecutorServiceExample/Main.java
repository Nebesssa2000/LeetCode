package FactorialExecutorServiceExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 8, 11};

        ExecutorService executor = newFixedThreadPool(4);

        List<Future<Factorial>> futures = new ArrayList<>();

        for (int num : nums) {
            FactorialExecutor factorialExecutor = new FactorialExecutor(num);
            Future<Factorial> future = executor.submit(factorialExecutor);
            futures.add(future);
        }

        for(Future<Factorial> future : futures) {
            try {
                Factorial factorial = future.get();
                System.out.println("Факториал числа " + factorial.getResult());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
