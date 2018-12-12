import ee.ttu.algoritmid.stamps.InterestingStamps;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(InterestingStamps.findStamps(100, Arrays.asList(1, 10, 24, 30, 33, 36)));
        System.out.println(InterestingStamps.findStamps(63, Arrays.asList(1, 5, 10, 21, 25)));
        System.out.println(InterestingStamps.findStamps(0, Arrays.asList(1, 5, 10, 21, 25)));
    }
}
