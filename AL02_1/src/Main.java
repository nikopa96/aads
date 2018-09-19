import ee.ttu.algoritmid.guessinggame.Fruit;
import ee.ttu.algoritmid.guessinggame.GuessingGame;
import ee.ttu.algoritmid.guessinggame.Oracle;

public class Main {

    public static void main(String[] args) {
        Fruit fruit = new Fruit("Banaan", 2);
        Oracle oracle = new Oracle(fruit);
        GuessingGame guessingGame = new GuessingGame(oracle);

        Fruit[] fruitsArray = new Fruit[8];
        fruitsArray[0] = new Fruit("Apelsin", 5);
        fruitsArray[1] = new Fruit("Banaan", 2);
        fruitsArray[2] = new Fruit("Greip", 1);
        fruitsArray[3] = new Fruit("Mango", 8);
        fruitsArray[4] = new Fruit("Pirn", 3);
        fruitsArray[5] = new Fruit("Ploom", 15);
        fruitsArray[6] = new Fruit("Virsik", 11);
        fruitsArray[7] = new Fruit("Õun", 7);

        System.out.println(guessingGame.play(fruitsArray));
    }
}
