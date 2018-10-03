package ee.ttu.algoritmid.popularity;

public class Main {

    public static void main(String[] args) {
        Popularity popularity = new Popularity(1000);
        popularity.addPoint(1, 2);
        popularity.addPoint(1, 2);
        popularity.addPoint(1, 2);
        popularity.addPoint(1, 3);
        popularity.addPoint(2, 4);
        popularity.addPoint(2, 5);
        popularity.addPoint(2, 5);

        System.out.println(popularity.maxPopularity());
    }
}
