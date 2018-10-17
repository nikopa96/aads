import ee.ttu.algoritmid.scoreboard.Participant;
import ee.ttu.algoritmid.scoreboard.ScoreBoard;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

//        scoreBoard.add(new Participant(1, "a", 66));
//        scoreBoard.add(new Participant(1, "a", 55));
//        scoreBoard.add(new Participant(1, "a", 78));
//        scoreBoard.add(new Participant(1, "a", 94));

        List<Participant> participants = scoreBoard.get(2);
        participants.forEach(s -> System.out.println(s.getTime()));
    }
}
