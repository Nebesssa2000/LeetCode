package FactorialExecutorServiceExample;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class FactorialExecutor implements Callable<Factorial> {
    private final int n;

    public FactorialExecutor(int n) {
        this.n = n;
    }

    private BigInteger factorialCalculator() {
        BigInteger result = BigInteger.ONE;
        if (this.n < 2) {
            return result;
        }
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(n));
        }
        return result;
    }

    public int getN() {
        return n;
    }

    @Override
    public Factorial call() throws Exception {
        return new Factorial(factorialCalculator());
    }
}
