package ee.ttu.algoritmid.popularity;

public class Main {

    public static void main(String[] args) {
        Popularity popularity = new Popularity(10000);
        popularity.addPoint(1, 2);
        popularity.addPoint(1, 2);
        popularity.addPoint(1, 2);
        popularity.addPoint(1, 4);

        System.out.println(popularity.pointPopularity(1, 2));
    }
}
