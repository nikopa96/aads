package ee.ttu.algoritmid.popularity;

import java.util.ArrayList;
import java.util.List;

public class Popularity {

    private int maxCoordinates;

    private List<Point> points = new ArrayList<>();

    public Popularity(int maxCoordinates) {
        this.maxCoordinates = maxCoordinates;
    }

    /**
     * @param x, y - coordinates
     */
    void addPoint(Integer x, Integer y) {
        points.add(new Point(x, y));
    }

    /**
     * @param x, y - coordinates
     * @return the number of occurrennces of the point
     */
    int pointPopularity(Integer x, Integer y) {
        int counter = 0;

        for (Point point : points) {
            if (point.getX().equals(x) && point.getY().equals(y)) {
                counter++;
            }
        }
        return counter;
    }

    private Point findMostPopularPoint() {
        return null;
    }


    /**
     * @return the number of occurrennces of the most popular point
     */
    int maxPopularity() {
        return 0;
    }
}