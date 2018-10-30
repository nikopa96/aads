import ee.ttu.algoritmid.dancers.HW01;
import ee.ttu.algoritmid.dancers.Dancer;
import ee.ttu.algoritmid.dancers.DancerImpl;

import static ee.ttu.algoritmid.dancers.Dancer.Gender.FEMALE;
import static ee.ttu.algoritmid.dancers.Dancer.Gender.MALE;

public class Main {

    public static void main(String[] args) {
        HW01 hw01 = new HW01();

        hw01.findPartnerFor(new DancerImpl(1, FEMALE, 80));
        hw01.findPartnerFor(new DancerImpl(2, FEMALE, 120));
        hw01.findPartnerFor(new DancerImpl(3, FEMALE, 40));
        hw01.findPartnerFor(new DancerImpl(4, FEMALE, 100));
        hw01.findPartnerFor(new DancerImpl(5, FEMALE, 20));
        hw01.findPartnerFor(new DancerImpl(6, FEMALE, 140));
        hw01.findPartnerFor(new DancerImpl(7, FEMALE, 110));
        hw01.findPartnerFor(new DancerImpl(8, FEMALE, 60));
        hw01.findPartnerFor(new DancerImpl(9, FEMALE, 130));
        hw01.findPartnerFor(new DancerImpl(10, FEMALE, 30));
        hw01.findPartnerFor(new DancerImpl(11, FEMALE, 50));
        hw01.findPartnerFor(new DancerImpl(12, FEMALE, 10));

        //System.out.println(hw01.returnWaitingList());

        hw01.findPartnerFor(new DancerImpl(13, MALE, 150));
        hw01.findPartnerFor(new DancerImpl(14, MALE, 12));
        hw01.findPartnerFor(new DancerImpl(15, MALE, 86));
        hw01.findPartnerFor(new DancerImpl(16, MALE, 57));
        hw01.findPartnerFor(new DancerImpl(17, MALE, 116));

        //System.out.println(hw01.returnWaitingList());

        hw01.findPartnerFor(new DancerImpl(15, MALE, 86));
        hw01.findPartnerFor(new DancerImpl(15, MALE, 57));
        hw01.findPartnerFor(new DancerImpl(15, MALE, 116));

       // System.out.println(hw01.returnWaitingList());

        hw01.findPartnerFor(new DancerImpl(18, FEMALE, 49));
        hw01.findPartnerFor(new DancerImpl(19, FEMALE, 109));
        hw01.findPartnerFor(new DancerImpl(20, FEMALE, 51));
        hw01.findPartnerFor(new DancerImpl(21, FEMALE, 111));
        hw01.findPartnerFor(new DancerImpl(22, FEMALE, 141));

        //System.out.println(hw01.returnWaitingList());

        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.FEMALE, 141));

        //System.out.println(hw01.returnWaitingList());

        hw01.findPartnerFor(new DancerImpl(23, MALE, 146));
        hw01.findPartnerFor(new DancerImpl(24, MALE, 126));
        hw01.findPartnerFor(new DancerImpl(25, MALE, 136));
        hw01.findPartnerFor(new DancerImpl(26, MALE, 106));
        hw01.findPartnerFor(new DancerImpl(27, MALE, 116));
        hw01.findPartnerFor(new DancerImpl(27, MALE, 116));

        //System.out.println(hw01.returnWaitingList());

        hw01.findPartnerFor(new DancerImpl(15, MALE, 146));
        hw01.findPartnerFor(new DancerImpl(15, MALE, 126));
        hw01.findPartnerFor(new DancerImpl(15, MALE, 136));
        hw01.findPartnerFor(new DancerImpl(15, MALE, 106));

        //System.out.println(hw01.returnWaitingList());

        hw01.findPartnerFor(new DancerImpl(15, MALE, 116));
        hw01.findPartnerFor(new DancerImpl(15, MALE, 116));

        System.out.println(hw01.returnWaitingList());

//        HW01 impl = new HW01();
//        impl.findPartnerFor(new DancerImpl(1, MALE, 1));
//        impl.findPartnerFor(new DancerImpl(2, MALE, 8));
//        impl.findPartnerFor(new DancerImpl(3, MALE, 3));
//        impl.findPartnerFor(new DancerImpl(4, MALE, 5));
//        impl.findPartnerFor(new DancerImpl(5, MALE, 8));
//
//        System.out.println(impl.findPartnerFor(new DancerImpl(6, FEMALE, 3)));
    }
}
