import ee.ttu.algoritmid.scoreboard.Participant;
import ee.ttu.algoritmid.scoreboard.ScoreBoard;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.add(new Participant(1, "a", 55));
        scoreBoard.add(new Participant(2, "a", 55));
        scoreBoard.add(new Participant(3, "a", 78));
        scoreBoard.add(new Participant(4, "a", 94));

        List<Participant> participants = scoreBoard.get(4);
        participants.forEach(s -> System.out.println(s.getTime()));
    }
}
