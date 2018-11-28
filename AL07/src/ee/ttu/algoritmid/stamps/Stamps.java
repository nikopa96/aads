package ee.ttu.algoritmid.stamps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stamps {

    private static int bestCount;
    private static int[] counts;
    private static int[] bestCounts;

    private static int total() {
        int countNew = 0;

        for (int count : counts) {
            countNew = countNew + count;
        }

        return countNew;
    }

    private static void findStamps2(int i, int[] stampOptions, int sum) {
        if (sum == 0) {
            if (total() < bestCount) {
                bestCount = total();
                System.arraycopy(counts, 0, bestCounts, 0, counts.length);
            }
        } else if (i < stampOptions.length) {
            for (int j = 0; j <= sum / stampOptions[i]; j++) {
                counts[i] = j;
                findStamps2(i + 1, stampOptions, sum - j * stampOptions[i]);
            }
        }
    }

    public static List<Integer> findStamps(int sum, List<Integer> stampOptions) throws IllegalArgumentException {
        if (stampOptions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!stampOptions.contains(1)) {
            stampOptions.add(1);
        }

        bestCount = Integer.MAX_VALUE;
        counts = new int[stampOptions.size()];
        bestCounts = new int[stampOptions.size()];

        int[] stampsArray = new int[stampOptions.size()];

        for (int i = 0; i < stampOptions.size(); i++) {
            stampsArray[i] = stampOptions.get(i);
        }

        findStamps2(0, stampsArray, sum);

        List<Integer> stamps = new ArrayList<>();
        for (int i = 0; i < bestCounts.length; i++) {
            for (int j = 0; j < bestCounts[i]; j++) {
                stamps.add(stampsArray[i]);
            }
        }

        return stamps;
    }

    public static void main(String[] args) {
        List<Integer> stampOptions = Arrays.asList(1, 10, 24, 30, 33, 36);
        System.out.println(Stamps.findStamps(100, stampOptions));
    }
}