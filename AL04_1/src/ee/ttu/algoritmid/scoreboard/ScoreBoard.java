package ee.ttu.algoritmid.scoreboard;

import java.util.*;

public class ScoreBoard {

    private Map<Integer, TreeMap<Integer, Participant>> participants = new TreeMap<>();

    /**
     * Adds a participant's time to the checkpoint scoreboard
     */
    public void add(Participant participant) {
        if (!participants.containsKey(participant.getTime())) {
            TreeMap<Integer, Participant> participantResult = new TreeMap<>();
            participantResult.put(participant.getId(), participant);

            participants.put(participant.getTime(), participantResult);
        } else {
            participants.get(participant.getTime()).put(participant.getId(), participant);
        }
    }

    /**
     * Returns top n number of participants in the checkpoint to be displayed on the scoreboard
     * This method will be queried by the tests every time a new participant is added
     */
    public List<Participant> get(int n) {
        if (!participants.isEmpty()) {
            List<Participant> bestParticipants = new ArrayList<>();

            for (Map.Entry<Integer, TreeMap<Integer, Participant>> entry : participants.entrySet()) {
                for (Map.Entry<Integer, Participant> innerEntry : entry.getValue().entrySet()) {
                    bestParticipants.add(innerEntry.getValue());

                    if (bestParticipants.size() == n) {
                        return bestParticipants;
                    }
                }
            }
            return bestParticipants;
        } else {
            return null;
        }
    }
}
