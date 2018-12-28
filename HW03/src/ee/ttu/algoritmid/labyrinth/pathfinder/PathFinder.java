package ee.ttu.algoritmid.labyrinth.pathfinder;

import ee.ttu.algoritmid.labyrinth.explorer.Cell;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class PathFinder {

    private String[][] maze;
    private int startX;
    private int startY;

    public PathFinder(String[][] maze, int startX, int startY) {
        this.maze = maze;
        this.startX = startX;
        this.startY = startY;
    }

    private String getDirection(SimpleEntry<Integer, Integer> previous, SimpleEntry<Integer, Integer> current) {
        if (previous.getKey().equals(current.getKey()) && previous.getValue().equals(current.getValue() - 1)) {
            return "N";
        } else if (previous.getKey().equals(current.getKey() + 1) && previous.getValue().equals(current.getValue())) {
            return "E";
        } else if (previous.getKey().equals(current.getKey()) && previous.getValue().equals(current.getValue() + 1)) {
            return "S";
        } else {
            return "W";
        }
    }

//    private void findPath(int x, int y, List<Cell> visited, List<String> visitedDirections) {
//        Cell current = new Cell(x, y, maze[y][x]);
//
//        if (maze[y][x].equals("T")) {
//            visitedDirections.add("END");
//        } else {
//            if (!visited.contains(current) && maze[y][x] != null) {
//                visited.add(current);
//
//                if (y - 1 <= maze.length && maze[y - 1][x] != null) {
//                    System.out.println(x + " " + y);
//                    visitedDirections.add("N");
//                    findPath(x, y - 1, visited, visitedDirections);
//                }
//
//                if (x + 1 <= maze.length && maze[y][x + 1] != null) {
//                    System.out.println(x + " " + y);
//                    visitedDirections.add("E");
//                    findPath(x + 1, y, visited, visitedDirections);
//                }
//
//                if (y + 1 <= maze.length && maze[y + 1][x] != null) {
//                    System.out.println(x + " " + y);
//                    visitedDirections.add("S");
//                    findPath(x, y + 1, visited, visitedDirections);
//                }
//
//                if (x - 1 <= maze.length && maze[y][x - 1] != null) {
//                    System.out.println(x + " " + y);
//                    visitedDirections.add("W");
//                    findPath(x - 1, y, visited, visitedDirections);
//                }
//            }
//        }
//    }

    private boolean findPath(int x, int y, List<Cell> visited, List<String> visitedDirections) {
        if (maze[y][x] != null) {
            visited.add(new Cell(x, y, maze[y][x]));

            if (maze[y][x].equals("T")) {
                visitedDirections.add("END");
                return true;
            }

            if (findPath(x, y - 1, visited, visitedDirections)) {
                visitedDirections.add("N");
                return true;
            }

            if (findPath(x + 1, y, visited, visitedDirections)) {
                visitedDirections.add("E");
                return true;
            }

            if (findPath(x, y + 1, visited, visitedDirections)) {
                visitedDirections.add("S");
                return true;
            }

            if (findPath(x - 1, y, visited, visitedDirections)) {
                visitedDirections.add("W");
                return true;
            }
        }

        return false;

    }

    public List<String> getPath() {
        List<Cell> visited = new ArrayList<>();
        List<String> visitedDirections = new ArrayList<>();

        findPath(startX, startY, visited, visitedDirections);

        return visitedDirections;
    }
}
