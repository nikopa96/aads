package ee.ttu.algoritmid.fibonacci;

public class AL01A {

    /**
     * Compute the Fibonacci sequence number.
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */
    public String iterativeF(int n) {
        int fib1 = 1;
        int fib2 = 1;
        int fib3;

        for (int i = 2; i <= n; i++) {
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
        }

        return String.valueOf(fib1);
    }
}
