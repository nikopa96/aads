package ee.ttu.algoritmid.labyrinth.explorer;

import ee.ttu.algoritmid.labyrinth.MazeRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MazeExplorer {

    private MazeRunner mazeRunner;

    private HashMap<String, String> opposites;

    public MazeExplorer(MazeRunner mazeRunner) {
        this.mazeRunner = mazeRunner;

        this.opposites = new HashMap<>();
        this.opposites.put("N", "S");
        this.opposites.put("S", "N");
        this.opposites.put("W", "E");
        this.opposites.put("E", "W");
    }

    private void visit(String[][] maze, List<Cell> visited, List<String> visitedDirections, List<String> path) {
        int x = mazeRunner.getPosition().getKey();
        int y = mazeRunner.getPosition().getValue();
        String cost = mazeRunner.scanAsString().get(1).get(1);

        Cell current = new Cell(x, y, cost);

        if (!visited.contains(current) && maze[y][x] == null) {
            maze[y][x] = cost;
            visited.add(current);

            if (maze[y][x].equals("T")) {
                path.addAll(visitedDirections);
            }

            if (!mazeRunner.scanAsString().get(1).get(0).equals("#") && maze[y - 1][x] == null) {
                mazeRunner.move("N");
                visitedDirections.add("N");
                visit(maze, visited, visitedDirections, path);
            }

            if (!mazeRunner.scanAsString().get(2).get(1).equals("#") && maze[y][x + 1] == null) {
                mazeRunner.move("E");
                visitedDirections.add("E");
                visit(maze, visited, visitedDirections, path);
            }

            if (!mazeRunner.scanAsString().get(1).get(2).equals("#") && maze[y + 1][x] == null) {
                mazeRunner.move("S");
                visitedDirections.add("S");
                visit(maze, visited, visitedDirections, path);
            }

            if (!mazeRunner.scanAsString().get(0).get(1).equals("#") && maze[y][x - 1] == null) {
                mazeRunner.move("W");
                visitedDirections.add("W");
                visit(maze, visited, visitedDirections, path);
            }

            if (visitedDirections.size() > 0) {
                String lastDirection = visitedDirections.remove(visitedDirections.size() - 1);
                mazeRunner.move(opposites.get(lastDirection));
            }
        }
    }

    public List<String> getPath() {
        String[][] maze = new String[mazeRunner.getSize().getKey()][mazeRunner.getSize().getValue()];

        List<Cell> visited = new ArrayList<>();
        List<String> visitedDirections = new ArrayList<>();
        List<String> path = new ArrayList<>();

        visit(maze, visited, visitedDirections, path);

        return path;
    }

}
