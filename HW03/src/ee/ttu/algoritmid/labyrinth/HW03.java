package ee.ttu.algoritmid.labyrinth;

import ee.ttu.algoritmid.labyrinth.explorer.MazeExplorer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HW03 {
    private MazeRunner mazeRunner;

    public HW03(String fileName) throws IOException, URISyntaxException {
        mazeRunner = new MazeRunner(fileName);

//        MazeExplorer mazeExplorer = new MazeExplorer(mazeRunner);
//        System.out.println(mazeExplorer.getPath());
    }

    public MazeRunner getMazeRunner() {
        return mazeRunner;
    }

    /**
     * Returns the list of steps to take to get from beginning ("B") to
     * the treasure ("T").
     * @return  return the steps taken as a list of strings (e.g., ["E", "E", "E"])
     *          return null if there is no path (there is no way to get to the treasure).
     */
    public List<String> solve() {
        MazeExplorer mazeExplorer = new MazeExplorer(mazeRunner);

        List<String> path = mazeExplorer.getPath();

        if (path.isEmpty()) {
            return null;
        } else {
            return path;
        }
    }
}
