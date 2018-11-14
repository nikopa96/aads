import ee.ttu.algoritmid.friends.AL06;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AL06 al06 = new AL06();

        List<SimpleEntry<Integer, Integer>> entries = Arrays.asList(
                new SimpleEntry<>(0, 1),
                new SimpleEntry<>(1, 2),
                new SimpleEntry<>(1, 3),
                new SimpleEntry<>(1, 4),
                new SimpleEntry<>(3, 4),
                new SimpleEntry<>(4, 2),
                new SimpleEntry<>(0, 2)
        );

        System.out.println(al06.buildGraphAndFindLink(entries, new SimpleEntry<>(0, 3)));
    }
}
