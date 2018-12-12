package ee.ttu.algoritmid.stamps;

import java.util.ArrayList;
import java.util.List;

public class InterestingStamps {

    private static long[] buildArray(int sum, List<Integer> stampOptions) {
        long[] M = new long[sum + 1];
        long[] V = new long[sum + 1];

        for (int i = 1; i <= sum; i++) {
            M[i] = Integer.MAX_VALUE;

            for (int stampOption : stampOptions) {
                if ((i >= stampOption) && (M[i] > M[i - stampOption] + 1)) {
                    M[i] = M[i - stampOption] + 1;
                    V[i] = stampOption;
                }
            }
        }

        return V;
    }

    private static List<Integer> chooseStamps(long[] stampsArray) {
        List<Integer> chosenStamps = new ArrayList<>();

        int sum = stampsArray.length - 1;
        int previous = (int) stampsArray[sum];
        chosenStamps.add(previous);

        while (sum != 0) {
            int next = (int) (sum - stampsArray[sum]);

            if (stampsArray[next] != 0) {
                chosenStamps.add((int) stampsArray[next]);
            }

            sum -= stampsArray[sum];
        }

        return chosenStamps;
    }

    public static List<Integer> findStamps(int sum, List<Integer> stampOptions) throws IllegalArgumentException {
        long[] stampsArray = buildArray(sum, stampOptions);

        return chooseStamps(stampsArray);
    }
}
