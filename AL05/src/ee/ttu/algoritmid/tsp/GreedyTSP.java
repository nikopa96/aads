package ee.ttu.algoritmid.tsp;

import java.util.Arrays;

public class GreedyTSP {

    private static int findNearTown(int[] routes) {
        int minDistanceFromCurrentCity = routes[0];
        int min = 0;

        for (int i = 1; i < routes.length; i++) {
            if (routes[i] < minDistanceFromCurrentCity) {
                minDistanceFromCurrentCity = routes[i];
                min = i;
            }
        }

        return min;
    }

    /* Greedy search */
    public static int[] greedySolution(int[][] adjacencyMatrix) {
        int[] visitedTowns = new int[adjacencyMatrix.length + 1];

        int j = 0;
        for (int i = 0; i < visitedTowns.length; i++) {
            adjacencyMatrix[j][j] = Integer.MAX_VALUE;
            int min = findNearTown(adjacencyMatrix[j]);

            visitedTowns[i] = j;
            adjacencyMatrix[min][j] = Integer.MAX_VALUE;
            j = min;
        }

        visitedTowns[adjacencyMatrix.length] = 0;

        return visitedTowns;
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 5},
                {2, 0, 3},
                {3, 8, 0}
        };

        System.out.println(Arrays.toString(greedySolution(adjacencyMatrix)));
    }
}
