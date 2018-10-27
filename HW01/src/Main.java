import ee.ttu.algoritmid.dancers.Dancers;
import ee.ttu.algoritmid.dancers.HW01;
import ee.ttu.algoritmid.dancers.binarytree.BinaryTree;
import ee.ttu.algoritmid.dancers.binarytree.Node;
import ee.ttu.algoritmid.dancers.dancer.Dancer;
import ee.ttu.algoritmid.dancers.dancer.DancerImpl;

import java.util.ArrayList;
import java.util.List;

import static ee.ttu.algoritmid.dancers.dancer.Dancer.Gender.FEMALE;

public class Main {

    public static void main(String[] args) {
        HW01 hw01 = new HW01();

        hw01.addDancer(new DancerImpl(1, Dancer.Gender.FEMALE, 80));
        hw01.addDancer(new DancerImpl(2, Dancer.Gender.FEMALE, 120));
        hw01.addDancer(new DancerImpl(3, Dancer.Gender.FEMALE, 40));
        hw01.addDancer(new DancerImpl(4, Dancer.Gender.FEMALE, 100));
        hw01.addDancer(new DancerImpl(5, Dancer.Gender.FEMALE, 20));
        hw01.addDancer(new DancerImpl(6, Dancer.Gender.FEMALE, 140));
        hw01.addDancer(new DancerImpl(7, Dancer.Gender.FEMALE, 110));
        hw01.addDancer(new DancerImpl(8, Dancer.Gender.FEMALE, 60));
        hw01.addDancer(new DancerImpl(9, Dancer.Gender.FEMALE, 130));
        hw01.addDancer(new DancerImpl(10, Dancer.Gender.FEMALE, 30));
        hw01.addDancer(new DancerImpl(11, Dancer.Gender.FEMALE, 50));
        hw01.addDancer(new DancerImpl(12, Dancer.Gender.FEMALE, 10));

        hw01.addDancer(new DancerImpl(13, Dancer.Gender.MALE, 150));
        hw01.addDancer(new DancerImpl(14, Dancer.Gender.MALE, 12));
        hw01.addDancer(new DancerImpl(15, Dancer.Gender.MALE, 86));
        hw01.addDancer(new DancerImpl(16, Dancer.Gender.MALE, 57));
        hw01.addDancer(new DancerImpl(17, Dancer.Gender.MALE, 116));

        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 86));
        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 57));
        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 116));

        hw01.addDancer(new DancerImpl(18, Dancer.Gender.FEMALE, 49));
        hw01.addDancer(new DancerImpl(19, Dancer.Gender.FEMALE, 109));
        hw01.addDancer(new DancerImpl(20, Dancer.Gender.FEMALE, 51));
        hw01.addDancer(new DancerImpl(21, Dancer.Gender.FEMALE, 111));
        hw01.addDancer(new DancerImpl(22, Dancer.Gender.FEMALE, 141));

        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.FEMALE, 141));

        hw01.addDancer(new DancerImpl(23, Dancer.Gender.MALE, 146));
        hw01.addDancer(new DancerImpl(24, Dancer.Gender.MALE, 126));
        hw01.addDancer(new DancerImpl(25, Dancer.Gender.MALE, 136));
        hw01.addDancer(new DancerImpl(26, Dancer.Gender.MALE, 106));
        hw01.addDancer(new DancerImpl(27, Dancer.Gender.MALE, 116));
        hw01.addDancer(new DancerImpl(27, Dancer.Gender.MALE, 116));

        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 146));
        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 126));
        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 136));
        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 106));


        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 116));
        hw01.findPartnerFor(new DancerImpl(15, Dancer.Gender.MALE, 116));

//        System.out.println(hw01.getWomenDancersTree().getSuccessor(testNode));

//        hw01.getWomenDancersTree().remove(new DancerImpl(0, Dancer.Gender.FEMALE, 110));
//        System.out.println(hw01.getWomenDancersTree().getMin(testNode));

//        System.out.println(hw01.getWomenDancersTree().findNode(new DancerImpl(0, Dancer.Gender.FEMALE, 111)));
    }
}
