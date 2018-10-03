package ee.ttu.algoritmid.popularity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Popularity {

    private int maxCoordinates;

    private Map<HashMap<Integer, Integer>, Integer> points = new HashMap<>();

    public Popularity(int maxCoordinates) {
        this.maxCoordinates = maxCoordinates;
    }

    /**
     * @param x, y - coordinates
     */
    void addPoint(Integer x, Integer y) {
        if (points.size() < maxCoordinates) {
            double min = - Math.pow(10, 10);
            double max = Math.pow(10, 10);

            HashMap<Integer, Integer> point = new HashMap<>();
            point.put(x, y);

            Optional<Integer> occurrences = Optional.ofNullable(points.get(point));

            if (occurrences.isPresent()) {
                points.put(point, occurrences.get() + 1);
            } else {
                points.put(point, 1);
            }
        }
    }

    /**
     * @param x, y - coordinates
     * @return the number of occurrennces of the point
     */
    int pointPopularity(Integer x, Integer y) {
        if (points.size() < maxCoordinates) {
            HashMap<Integer, Integer> point = new HashMap<>();
            point.put(x, y);

            Optional<Integer> occurrences = Optional.ofNullable(points.get(point));

            if (occurrences.isPresent()) {
                return occurrences.get();
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }


    /**
     * @return the number of occurrennces of the most popular point
     */
    int maxPopularity() {
        if (points.size() != 0) {
            return Collections.max(points.values());
        } else {
            return 0;
        }
    }
}