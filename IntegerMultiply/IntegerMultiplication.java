package IntegerMultiply;

public class IntegerMultiplication {

    public static void main(String[] args) {
        try {
            System.out.println(10 << 1);
            System.out.println(multiply(10, 20)); // 200
            System.out.println(multiply(-10, 20)); // -200
            System.out.println(multiply(-10, -20)); // 200
            System.out.println(multiply(Integer.MAX_VALUE, 1)); // 2147483647
            System.out.println(multiply(Integer.MAX_VALUE, -1)); // 2147483647
            System.out.println(multiply(Integer.MIN_VALUE, -1)); // -2147483647
            System.out.println(multiply(Integer.MIN_VALUE, 1)); // -2147483647
            System.out.println(multiply(Integer.MAX_VALUE, 2)); // Exception: Overflow
        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }

    public static long multiply(int a, int b) {
        // Handle special cases
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1 ) {
            return b;
        }
        if (b == 1) {
            return a;
        }
        if (a == -1 && b > 0) {
            return -b;
        }

        if (a > 0 && b == -1) {
            return -a;
        }

        // Determine the sign of the result
        boolean isNegative = (a < 0) ^ (b < 0);

        // Convert to positive values
        long absA = Math.abs((long) a);
        long absB = Math.abs((long) b);

        // Perform multiplication using addition
        long result = 0;
        while (absB > 0) {
            if ((absB & 1) == 1) {
                result += absA;
            }
            absA <<= 1;
            absB >>= 1;
        }

        // Apply the sign to the result
        result = isNegative ? -result : result;

        return result;
    }
}
