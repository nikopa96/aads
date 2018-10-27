package ee.ttu.algoritmid.dancers.binarytree;

import ee.ttu.algoritmid.dancers.dancer.Dancer;

public class Node {

    private int value;

    private Node parent;
    private Node leftChild;
    private Node rightChild;

    private Dancer dancer;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Dancer getDancer() {
        return dancer;
    }

    public void setDancer(Dancer dancer) {
        this.dancer = dancer;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", parent=" + parent +
                '}';
    }
}
