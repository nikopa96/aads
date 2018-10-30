package ee.ttu.algoritmid.dancers;

import java.util.Comparator;

public class DancersComparator implements Comparator<Dancer> {

    @Override
    public int compare(Dancer dancer1, Dancer dancer2) {
        if (dancer1.getHeight() == dancer2.getHeight()) {
            if (dancer1.getGender().equals(Dancer.Gender.FEMALE) && dancer2.getGender().equals(Dancer.Gender.MALE)) {
                return -1;
            } else {
                return 1;
            }
        } else if (dancer1.getHeight() < dancer2.getHeight()) {
            return -1;
        } else {
            return 1;
        }
    }
}
