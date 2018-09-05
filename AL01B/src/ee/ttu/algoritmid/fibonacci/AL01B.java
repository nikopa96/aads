package ee.ttu.algoritmid.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AL01B {

    private static final String SECONDS_IN_YEAR = "31536000";

    /**
     * Estimate or find the exact time required to compute the n-th Fibonacci number.
     * @param n The n-th number to compute.
     * @return The time estimate or exact time in YEARS.
     */
    public String timeToComputeRecursiveFibonacci(int n) {
        BigInteger fibonacciNumber = recursiveF(n);

        BigInteger rows = fibonacciNumber.multiply(new BigInteger("3")).subtract(new BigInteger("2"));
        BigDecimal time = (new BigDecimal(String.valueOf(rows))).multiply(new BigDecimal("0.002"))
                .divide(new BigDecimal(SECONDS_IN_YEAR), 6);

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
}