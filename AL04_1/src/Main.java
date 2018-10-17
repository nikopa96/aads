import ee.ttu.algoritmid.scoreboard.Participant;
import ee.ttu.algoritmid.scoreboard.ScoreBoard;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();

//        scoreBoard.add(new Participant(1, "a", 55));
//        scoreBoard.add(new Participant(2, "a", 55));
//        scoreBoard.add(new Participant(3, "a", 78));
//        scoreBoard.add(new Participant(4, "a", 94));

        scoreBoard.add(new Participant(5,"aa", 120));
        scoreBoard.add(new Participant(2,"aa", 130));
        scoreBoard.add(new Participant(3,"aa", 160));
        scoreBoard.add(new Participant(4,"aa", 110));
        scoreBoard.add(new Participant(1,"aa", 120));
        scoreBoard.add(new Participant(1,"aa", 120));
        scoreBoard.add(new Participant(2,"aa", 120));

        List<Participant> participants = scoreBoard.get(7);
        participants.forEach(s -> System.out.println(s.getTime()));
    }
}
