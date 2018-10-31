package ee.ttu.algoritmid.tsp;

import java.util.Arrays;

public class GreedyTSP {

    private static int findNearTown(int[] towns) {
        int minDistanceFromCurrentCity = towns[0];
        int min = 0;

        for (int i = 0; i < towns.length; i++) {
            if (towns[i] < minDistanceFromCurrentCity) {
                minDistanceFromCurrentCity = towns[i];
                min = i;
            }
        }

        return min;
    }

    /* Greedy search */
    public static int[] greedySolution(int[][] adjacencyMatrix) {
        if (adjacencyMatrix.length == 1) {
            return new int[]{0};
        } else if (adjacencyMatrix.length == 2) {
            if (adjacencyMatrix[0][1] != adjacencyMatrix[1][0]) {
                return new int[] {0, 1, 0};
            } else {
                return new int[] {0};
            }
        } else {
            int[] visitedTowns = new int[adjacencyMatrix.length + 1];
            int j = 1;
            int nextTown = 0;

            for (int i = 0; i < adjacencyMatrix.length; i++) {
                int[] tempTown = adjacencyMatrix[nextTown];
                tempTown[nextTown] = Integer.MAX_VALUE;

                nextTown = findNearTown(tempTown);
                visitedTowns[j] = nextTown;
                j++;

                adjacencyMatrix[nextTown][0] = Integer.MAX_VALUE;
                adjacencyMatrix[nextTown][i] = Integer.MAX_VALUE;
            }

            visitedTowns[visitedTowns.length - 1] = 0;

            return visitedTowns;
        }
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 0},
                {0, 0}
        };

        System.out.println(Arrays.toString(greedySolution(adjacencyMatrix)));
    }
}
