package ee.ttu.algoritmid.fibonacci;

import java.math.BigInteger;

public class AL01B {

    private static final String SECONDS_IN_YEAR = "31536000";

    /**
     * Estimate or find the exact time required to compute the n-th Fibonacci number.
     * @param n The n-th number to compute.
     * @return The time estimate or exact time in YEARS.
     */
    public String timeToComputeRecursiveFibonacci(int n) {
        BigInteger fibonacciNumber = iterativeF(n);
        BigInteger rows = fibonacciNumber.multiply(new BigInteger("3")).subtract(new BigInteger("2"));
        double time = Integer.parseInt(rows.toString()) * 0.002 / Integer.parseInt(SECONDS_IN_YEAR);

        return String.valueOf(time);
    }

    /**
     * Compute the Fibonacci sequence number recursively.
     * (You need this in the timeToComputeRecursiveFibonacci(int n) function!)
     * @param n The n-th number to compute.
     * @return The n-th Fibonacci number as a string.
     */
    public BigInteger recursiveF(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);
        return recursiveF(n - 1).add(recursiveF(n - 2));
    }

    /**
     * Compute the Fibonacci sequence number.
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */
    public BigInteger iterativeF(int n) {
        BigInteger fib1;
        if (n > 0) {
            fib1 = new BigInteger("1");
        } else {
            fib1 = new BigInteger("0");
        }

        BigInteger fib2 = new BigInteger("1");
        BigInteger fib3;

        for (int i = 2; i <= n; i++) {
            fib3 = fib1.add(fib2);
            fib1 = fib2;
            fib2 = fib3;
        }

        return fib1;
    }
}