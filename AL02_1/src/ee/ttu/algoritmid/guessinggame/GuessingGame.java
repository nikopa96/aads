package ee.ttu.algoritmid.guessinggame;

public class GuessingGame {

    Oracle oracle;

    public GuessingGame(Oracle oracle) {
        this.oracle = oracle;
    }

    private Fruit[] sortByWeight(Fruit[] fruitArray) {
        for (int i = 0; i < fruitArray.length; i++) {
            for (int j = 0; j < fruitArray.length - 1 - i; j++) {
                if (fruitArray[j + 1].getWeight() < fruitArray[j].getWeight()) {
                    Fruit temp = fruitArray[j];
                    fruitArray[j] = fruitArray[j + 1];
                    fruitArray[j + 1] = temp;
                }
            }
        }

        return fruitArray;
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
