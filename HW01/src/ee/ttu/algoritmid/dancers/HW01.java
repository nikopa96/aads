package ee.ttu.algoritmid.dancers;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class HW01 implements Dancers {

    private BinaryTree menDancersTree = new BinaryTree();
    private BinaryTree womenDancersTree = new BinaryTree();

    public void addDancer(Dancer dancer) {
        if (dancer.getGender().equals(Dancer.Gender.FEMALE)) {
            womenDancersTree.insert(dancer);
        } else {
            menDancersTree.insert(dancer);
        }
    }

    @Override
    public SimpleEntry<Dancer, Dancer> findPartnerFor(Dancer candidate) {
        if (candidate.getGender().equals(Dancer.Gender.FEMALE)) {
            int minValue = candidate.getHeight() + 5;
            int maxValue = candidate.getHeight() + 9;

            List<Dancer> suitablePartners = new ArrayList<>();
            menDancersTree.getDancersInRange(minValue, maxValue, menDancersTree.getHighestNode(), suitablePartners);

            if (suitablePartners.size() == 0) {
                addDancer(candidate);
                return null;
            } else {
                Dancer partner = suitablePartners.get(0);
                menDancersTree.remove(suitablePartners.get(0));
                return new SimpleEntry<>(partner, candidate);
            }
        } else {
            int minValue = candidate.getHeight() - 9;
            int maxValue = candidate.getHeight() - 5;

            List<Dancer> suitablePartners = new ArrayList<>();
            womenDancersTree.getDancersInRange(minValue, maxValue, womenDancersTree.getHighestNode(), suitablePartners);

            if (suitablePartners.size() == 0) {
                addDancer(candidate);
                return null;
            } else {
                Dancer partner = suitablePartners.get(0);
                womenDancersTree.remove(suitablePartners.get(0));
                return new SimpleEntry<>(candidate, partner);
            }
        }
    }

    @Override
    public List<Dancer> returnWaitingList() {
        List<Dancer> waitingMenDancers = new ArrayList<>();
        List<Dancer> waitingWomenDancers = new ArrayList<>();

        menDancersTree.getAllDancers(menDancersTree.getHighestNode(), waitingMenDancers);
        womenDancersTree.getAllDancers(womenDancersTree.getHighestNode(), waitingWomenDancers);

        List<Dancer> waitingDancers = new ArrayList<>();
        waitingDancers.addAll(waitingMenDancers);
        waitingDancers.addAll(waitingWomenDancers);

        return waitingDancers;
    }

    public BinaryTree getWomenDancersTree() {
        return womenDancersTree;
    }

    public BinaryTree getMenDancersTree() {
        return menDancersTree;
    }
}
