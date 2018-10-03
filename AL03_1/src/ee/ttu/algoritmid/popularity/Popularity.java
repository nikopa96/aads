package ee.ttu.algoritmid.popularity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Popularity {

    private int maxCoordinates;
    private int maxPopularity = 0;

    private Map<HashMap<Integer, Integer>, Integer> points = new HashMap<>();

    public Popularity(int maxCoordinates) {
        this.maxCoordinates = maxCoordinates;
    }

    /**
     * @param x, y - coordinates
     */
    void addPoint(Integer x, Integer y) {
        HashMap<Integer, Integer> point = new HashMap<>();
        point.put(x, y);

        Optional<Integer> occurrences = Optional.ofNullable(points.get(point));

        if (occurrences.isPresent()) {
            Integer occurrence = occurrences.get() + 1;
            points.put(point, occurrence);

            if (maxPopularity < occurrence) {
                this.maxPopularity = occurrence;
            }
        } else {
            points.put(point, 1);
        }
    }

    /**
     * @param x, y - coordinates
     * @return the number of occurrennces of the point
     */
    int pointPopularity(Integer x, Integer y) {
        HashMap<Integer, Integer> point = new HashMap<>();
        point.put(x, y);

        Optional<Integer> occurrences = Optional.ofNullable(points.get(point));

        if (occurrences.isPresent()) {
            return occurrences.get();
        } else {
            return 0;
        }
    }


    /**
     * @return the number of occurrennces of the most popular point
     */
    int maxPopularity() {
        if (points.size() != 0) {
            return maxPopularity;
        } else {
            return 0;
        }
    }
}