package ee.ttu.algoritmid.guessinggame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GuessingGame {

    Oracle oracle;

    public GuessingGame(Oracle oracle) {
        this.oracle = oracle;
    }

    private Fruit[] sortByWeight(Fruit[] fruitArray) {
        List<Fruit> unsortedFruits = Arrays.asList(fruitArray);
        unsortedFruits.sort(Comparator.comparingInt(Fruit::getWeight));

        Fruit[] sortedFruitArray = new Fruit[unsortedFruits.size()];
        unsortedFruits.toArray(sortedFruitArray);

        return sortedFruitArray;
    }

    /**
     * @param fruitArray - All the possible fruits.
     * @return the name of the fruit.
     */
    public String play(Fruit[] fruitArray) {
        Fruit[] sortedFruitArray = sortByWeight(fruitArray);

        int lowestIndex = 1;
        int highestIndex = sortedFruitArray.length;
        int mediumIndex = (lowestIndex + highestIndex) / 2;

        while (!oracle.isIt(sortedFruitArray[mediumIndex]).equals("correct!")) {
            if (oracle.isIt(sortedFruitArray[mediumIndex]).equals("lighter")) {
                highestIndex = mediumIndex - 1;
            } else {
                lowestIndex = mediumIndex + 1;
            }
            mediumIndex = (lowestIndex + highestIndex) / 2;
        }

        return sortedFruitArray[mediumIndex].getName();
    }
}
