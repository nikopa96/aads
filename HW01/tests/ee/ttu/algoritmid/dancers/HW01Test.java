package ee.ttu.algoritmid.dancers;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static ee.ttu.algoritmid.dancers.Dancer.Gender.FEMALE;
import static ee.ttu.algoritmid.dancers.Dancer.Gender.MALE;
import static org.junit.Assert.fail;

public class HW01Test {

    @Test
    public void testFemaleTreeImplementation() {
        HW01 impl = new HW01();

        addDancerAndTest(impl,  80, FEMALE, null);
        addDancerAndTest(impl, 120, FEMALE, null);
        addDancerAndTest(impl,  40, FEMALE, null);
        addDancerAndTest(impl, 100, FEMALE, null);
        addDancerAndTest(impl,  20, FEMALE, null);
        addDancerAndTest(impl, 140, FEMALE, null);
        addDancerAndTest(impl, 110, FEMALE, null);
        addDancerAndTest(impl,  60, FEMALE, null);
        addDancerAndTest(impl, 130, FEMALE, null);
        addDancerAndTest(impl,  30, FEMALE, null);
        addDancerAndTest(impl,  50, FEMALE, null);
        addDancerAndTest(impl,  10, FEMALE, null);

        addDancerAndTest(impl,  150, MALE,  null);

        addDancerAndTest(impl,  12, MALE,  null);
        addDancerAndTest(impl,  86, MALE,  80);
        addDancerAndTest(impl,  57, MALE,  50);
        addDancerAndTest(impl, 116, MALE, 110);


        addDancerAndTest(impl,  49, FEMALE, null);
        addDancerAndTest(impl, 109, FEMALE, null);
        addDancerAndTest(impl,  51, FEMALE, null);
        addDancerAndTest(impl, 111, FEMALE, null);
        addDancerAndTest(impl, 141, FEMALE, 150);

        addDancerAndTest(impl, 146, MALE, 140);
        addDancerAndTest(impl, 126, MALE, 120);
        addDancerAndTest(impl, 136, MALE, 130);
        addDancerAndTest(impl, 106, MALE, 100);
        addDancerAndTest(impl, 116, MALE, 111);
        addDancerAndTest(impl, 116, MALE, 109);

        List<Integer> correctIds = Arrays.asList(10, 12, 20, 30, 40, 49, 51, 60);
        List<Dancer> waitingList = impl.returnWaitingList();

        final boolean result1 = waitingList.size() == correctIds.size();
        if (!result1) fail("Number of remaining dancer is not correct.");

        boolean result2 = checkDancerIds(waitingList, correctIds);
        if (!result2) fail("Remaining dancer IDs are not correct.");
    }

    @Test
    public void testMaleTreeImplementation() {
        HW01 impl = new HW01();
        List<Integer> correctIds = Arrays.asList(115, 120, 127, 132, 140, 145, 170, 175, 180, 185, 189, 190);
        AbstractMap.SimpleEntry<Dancer, Dancer> se;

        addDancerAndTest(impl, 130, MALE, null);
        addDancerAndTest(impl, 180, MALE, null);
        addDancerAndTest(impl, 120, MALE, null);
        addDancerAndTest(impl, 150, MALE, null);
        addDancerAndTest(impl, 140, MALE, null);
        addDancerAndTest(impl, 170, MALE, null);
        addDancerAndTest(impl, 190, MALE, null);
        addDancerAndTest(impl, 115, MALE, null);
        addDancerAndTest(impl, 125, MALE, null);
        addDancerAndTest(impl, 135, MALE, null);
        addDancerAndTest(impl, 145, MALE, null);
        addDancerAndTest(impl, 175, MALE, null);
        addDancerAndTest(impl, 185, MALE, null);
        addDancerAndTest(impl, 127, MALE, null);
        addDancerAndTest(impl, 132, MALE, null);

        addDancerAndTest(impl, 125, FEMALE, 130);
        addDancerAndTest(impl, 100, FEMALE, null);
        addDancerAndTest(impl, 120, FEMALE, 125);
        addDancerAndTest(impl, 130, FEMALE, 135);


        addDancerAndTest(impl, 126, MALE, null);
        addDancerAndTest(impl, 133, MALE, null);
        addDancerAndTest(impl, 109, MALE, 100);

        addDancerAndTest(impl, 144, FEMALE, 150);

        addDancerAndTest(impl, 189, FEMALE, null);
        addDancerAndTest(impl, 119, FEMALE, 126);
        addDancerAndTest(impl, 128, FEMALE, 133);


        List<Dancer> waitingList = impl.returnWaitingList();
        final boolean result1 = waitingList.size() == correctIds.size();
        if (!result1) fail("Number of remaining dancer is not correct.");

        boolean result2 = checkDancerIds(waitingList, correctIds);
        if (!result2) fail("Remaining dancer IDs are not correct.");
    }

    private static void addDancerAndTest(HW01 impl, int height, Dancer.Gender gender, Integer takeoutHeight) {
        final Dancer dancer = new DancerImpl(height, gender, height);
        AbstractMap.SimpleEntry<Dancer, Dancer> se = impl.findPartnerFor(dancer);

        if (takeoutHeight != null) {
            final boolean result;
            if (gender == FEMALE) {
                result = se != null && se.getKey().getHeight() == takeoutHeight && se.getValue().getHeight() == height;
            } else {
                result = se != null && se.getKey().getHeight() == height && se.getValue().getHeight() == takeoutHeight;
            }


            if (!result) fail("Your implementation found an incorrect pair.");
        } else {
            if (se != null) {
                fail("Your implementation found a pair when it should not have.");
            }
        }
    }

    private static boolean checkDancerIds(List<Dancer> dancer, List<Integer> correctIds) {
        for (int i = 0; i < correctIds.size(); i++) {
            final int dancerId = dancer.get(i).getID();
            final int correctId = correctIds.get(i);
            if (correctId != dancerId) {
                return false;
            }
        }
        return true;
    }
}