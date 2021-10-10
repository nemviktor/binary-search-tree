package com.codecool.javabst;

import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTree {

    private List<Integer> sortedElements;
    private Node root;

    public BinarySearchTree(List<Integer> elements) {
        this.sortedElements = elements.stream().sorted().collect(Collectors.toList());
        buildWithMinimalHeight();
    }

    private void buildWithMinimalHeight() {
        // TODO construct a binary search tree here
        // Define root node
        int valueIndex = sortedElements.size() / 2;
        int nodeValue = sortedElements.get(valueIndex);
        this.root = new Node(nodeValue);
        sortedElements.remove(valueIndex);

        // Insert subsequent nodes
        if (sortedElements.size() > 0) {
            for (int i=0;i < sortedElements.size();i++) {
                Node newNode = new Node(sortedElements.get(i));
                insertNode(newNode);
            }
        }

    }

    public void insertNode(Node node) {
        Node compareNode = root;

        while (true) {
            if (node.getValue() <= compareNode.getValue()) {
                if (compareNode.getLeftNode() == null) {
                    compareNode.setLeft(node);
                    return;
                } else {
                    compareNode = compareNode.getLeftNode();
                }
            } else {
                if (compareNode.getRightNode() == null) {
                    compareNode.setRight(node);
                    return;
                } else {
                    compareNode = compareNode.getRightNode();
                }
            }
        }
    }

    public boolean search(Integer toFind) {
        // TODO return true if the element has been found, false if its not in the tree.
        return false;
    }

    public void add(Integer toAdd) {
        // TODO adds an element. Throws an error if it exist.
    }

    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
    }

    public Node getRoot() {
        return root;
    }
}
