package ee.ttu.algoritmid.dancers;

import java.util.Comparator;

public class DancersComparator implements Comparator<Dancer> {

    @Override
    public int compare(Dancer dancer1, Dancer dancer2) {
        //        int value1 = o1.campus.compareTo(o2.campus);
//        if (value1 == 0) {
//            int value2 = o1.faculty.compareTo(o2.faculty);
//            if (value2 == 0) {
//                return o1.building.compareTo(o2.building);
//            } else {
//                return value2;
//            }
//        }
//        return value1;

        if (dancer1.getHeight() == dancer2.getHeight()) {
            if (dancer1.getGender().equals(Dancer.Gender.FEMALE)) {
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
