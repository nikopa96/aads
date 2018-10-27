package ee.ttu.algoritmid.dancers.binarytree;

import ee.ttu.algoritmid.dancers.Dancer;

import java.util.List;

public class BinaryTree {

    private Node highestNode;

    public Node getHighestNode() {
        return highestNode;
    }

    public void insert(Dancer dancer) {
        Node newNode = new Node();
        newNode.setDancer(dancer);
        newNode.setValue(dancer.getHeight());

        Node highNode = null;
        Node lowNode = highestNode;

        while (lowNode != null) {
            highNode = lowNode;
            if (newNode.getValue() >= lowNode.getValue()) {
                lowNode = lowNode.getRightChild();
            } else {
                lowNode = lowNode.getLeftChild();
            }
        }

        newNode.setParent(highNode);

        if (highNode == null) {
            highestNode = newNode;
        } else {
            if (newNode.getValue() < highNode.getValue()) {
                highNode.setLeftChild(newNode);
            } else {
                highNode.setRightChild(newNode);
            }
        }
    }

    public Node getMin(Node requestedNode) {
        Node newNode;

        while (requestedNode.getLeftChild() != null) {
            requestedNode = requestedNode.getLeftChild();
        }

        newNode = requestedNode;
        return newNode;
    }

    public Node getSuccessor(Node requestedNode) {
        Node highNode;

        if (requestedNode.getRightChild() != null) {
            return getMin(requestedNode.getRightChild());
        }

        highNode = requestedNode.getParent();

        while (highNode != null && requestedNode == highNode.getRightChild()) {
            requestedNode = highNode;
            highNode = highNode.getParent();
        }

        return highNode;
    }

    public void remove(Dancer dancer) {
        Node requestedNode = findNode(dancer);
        Node highNode;
        Node lowNode;

        if (requestedNode.getLeftChild() == null || requestedNode.getRightChild() == null) {
            highNode = requestedNode;
        } else {
            highNode = getSuccessor(requestedNode);
        }

        if (highNode.getLeftChild() != null) {
            lowNode = highNode.getLeftChild();
        } else {
            lowNode = highNode.getRightChild();
        }

        if (lowNode != null) {
            lowNode.setParent(highNode.getParent());
        }

        if (highNode.getParent() == null) {
            highestNode = lowNode;
        } else {
            if (highNode == highNode.getParent().getLeftChild()) {
                highNode.getParent().setLeftChild(lowNode);
            } else {
                highNode.getParent().setRightChild(lowNode);
            }
        }

        if (highNode.getValue() != requestedNode.getValue()) {
            requestedNode.setValue(highNode.getValue());
            requestedNode.setDancer(highNode.getDancer());
        }
    }

    public Node findNode(Dancer dancer) {
        Node newNode = new Node();
        newNode.setDancer(dancer);
        newNode.setValue(dancer.getHeight());

        Node lowNode = highestNode;

        if (highestNode != null) {
            while (lowNode != null && newNode.getValue() != lowNode.getValue()) {
                if (newNode.getValue() >= lowNode.getValue()) {
                    lowNode = lowNode.getRightChild();
                } else {
                    lowNode = lowNode.getLeftChild();
                }
            }
        }

        return lowNode;
    }

    public List<Dancer> getDancersInRange(int minValue, int maxValue, Node supportedNode, List<Dancer> dancers) {
        if (supportedNode != null) {
            getDancersInRange(minValue, maxValue, supportedNode.getLeftChild(), dancers);

            if (supportedNode.getValue() >= minValue && supportedNode.getValue() <= maxValue) {
                dancers.add(supportedNode.getDancer());
            }

            return getDancersInRange(minValue, maxValue, supportedNode.getRightChild(), dancers);
        } else {
            return dancers;
        }
    }

    public List<Dancer> getAllDancers(Node supportedNode, List<Dancer> dancers) {
        if (supportedNode != null) {
            dancers.add(supportedNode.getDancer());
            return getAllDancers(supportedNode.getRightChild(), dancers);
        } else {
            return dancers;
        }
    }
}
