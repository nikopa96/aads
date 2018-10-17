package ee.ttu.algoritmid.scoreboard;

import java.util.*;
import java.util.stream.Collectors;

public class ScoreBoard {

    private Map<Integer, Participant> participants = new TreeMap<>();

    /**
     * Adds a participant's time to the checkpoint scoreboard
     */
    public void add(Participant participant) {
        participants.put(participant.getTime(), participant);
    }

    /**
     * Returns top n number of participants in the checkpoint to be displayed on the scoreboard
     * This method will be queried by the tests every time a new participant is added
     */
    public List<Participant> get(int n) {
        if (!participants.isEmpty()) {
            return participants.values().stream().limit(n).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
}
