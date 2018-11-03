package ee.ttu.algoritmid.dancers;

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

        Node y = null;
        Node x = highestNode;

        while (x != null) {
            y = x;
            if (newNode.getValue() >= x.getValue()) {
                x = x.getRightChild();
            } else {
                x = x.getLeftChild();
            }
        }

        newNode.setParent(y);

        if (y == null) {
            highestNode = newNode;
        } else {
            if (newNode.getValue() < y.getValue()) {
                y.setLeftChild(newNode);
            } else {
                y.setRightChild(newNode);
            }
        }
    }

    public Node getMin(Node requestedNode) {
        Node minNode;

        while (requestedNode.getLeftChild() != null) {
            requestedNode = requestedNode.getLeftChild();
        }

        minNode = requestedNode;
        return minNode;
    }

    public Node getSuccessor(Node requestedNode) {
        Node y;

        if (requestedNode.getRightChild() != null) {
            return getMin(requestedNode.getRightChild());
        }

        y = requestedNode.getParent();

        while (y != null && requestedNode == y.getRightChild()) {
            requestedNode = y;
            y = y.getParent();
        }

        return y;
    }

    public void remove(Dancer dancer) {
        Node requestedNode = findNode(dancer);
        Node y;
        Node x;

        if (requestedNode.getLeftChild() == null || requestedNode.getRightChild() == null) {
            y = requestedNode;
        } else {
            y = getSuccessor(requestedNode);
        }

        if (y.getLeftChild() != null) {
            x = y.getLeftChild();
        } else {
            x = y.getRightChild();
        }

        if (x != null) {
            x.setParent(y.getParent());
        }

        if (y.getParent() == null) {
            highestNode = x;
        } else {
            if (y == y.getParent().getLeftChild()) {
                y.getParent().setLeftChild(x);
            } else {
                y.getParent().setRightChild(x);
            }
        }

        if (!y.getDancer().equals(requestedNode.getDancer())) {
            requestedNode.setValue(y.getValue());
            requestedNode.setDancer(y.getDancer());
        }
    }

    public Node findNode(Dancer dancer) {
        Node newNode = new Node();
        newNode.setDancer(dancer);
        newNode.setValue(dancer.getHeight());

        Node x = highestNode;

        if (highestNode != null) {
            while (x != null && newNode.getValue() != x.getValue()) {
                if (newNode.getValue() >= x.getValue()) {
                    x = x.getRightChild();
                } else {
                    x = x.getLeftChild();
                }
            }
        }

        return x;
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
}
