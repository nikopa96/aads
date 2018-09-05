package ee.ttu.algoritmid.fibonacci;

import java.math.BigInteger;

public class AL01A {

    /**
     * Compute the Fibonacci sequence number.
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */
    public String iterativeF(int n) {
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

        return String.valueOf(fib1);
    }
}
