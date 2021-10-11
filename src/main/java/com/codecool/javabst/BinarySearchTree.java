package com.codecool.javabst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTree {

    private List<Integer> sortedElements;
    List<Integer> insertedNodeIndeces = new ArrayList<>();
    private Node root;

    public BinarySearchTree(List<Integer> elements) {
        this.sortedElements = elements.stream().sorted().collect(Collectors.toList());
        buildWithMinimalHeight();
    }

    private void buildWithMinimalHeight() {
        // TODO construct a binary search tree here
        // Insert major parent nodes
        insertMajorNodes(sortedElements);

        // List remnant nodes
        for (int i=0;i<insertedNodeIndeces.size();i++) {
            sortedElements.remove(insertedNodeIndeces.get(i));
        }

        // Insert all remnant nodes
        if (sortedElements.size() > 0) {
            for (int i=0;i < sortedElements.size();i++) {
                Node newNode = new Node(sortedElements.get(i));
                insertNode(newNode);
            }
        }

    }

    // Helper function which inserts the major nodes
    private void insertMajorNodes(List<Integer> elements) {
        int currentMiddleIndex = elements.size() / 2;
        if (currentMiddleIndex > 0) {
            // Define root node
            if (root == null) {
                int nodeValue = elements.get(currentMiddleIndex);
                this.root = new Node(nodeValue);
                insertedNodeIndeces.add(nodeValue);
            }
            // Act if node is not the root
            else {
                int nodeValue = elements.get(currentMiddleIndex);
                Node node = new Node(nodeValue);
                insertNode(node);
                insertedNodeIndeces.add(nodeValue);
            }

            List<Integer> lowerElements = elements.subList(0, currentMiddleIndex);
            List<Integer> upperElements = elements.subList(currentMiddleIndex+1, elements.size());
            insertMajorNodes(lowerElements);
            insertMajorNodes(upperElements);
        }
    }

    // Function which inserts a node into the proper position
    public void insertNode(Node node) {
        // TODO adds an element. Throws an error if it exist.
        Node compareNode = root;

        while (true) {
            if (node.getValue() < compareNode.getValue()) {
                if (compareNode.getLeftNode() == null) {
                    compareNode.setLeft(node);
                    return;
                } else {
                    compareNode = compareNode.getLeftNode();
                }
            } else if (node.getValue() > compareNode.getValue()) {
                if (compareNode.getRightNode() == null) {
                    compareNode.setRight(node);
                    return;
                } else {
                    compareNode = compareNode.getRightNode();
                }
            } else if (node.getValue() == compareNode.getValue()) {
                throw new IllegalArgumentException("Node already exists in the binary search tree.");
            }
        }
    }

    public boolean search(Integer toFind) {
        // TODO return true if the element has been found, false if its not in the tree.
        Node compareNode = root;
        while (compareNode != null) {
            if (compareNode.getValue() == toFind) {
                return true;
            }
            if (toFind < compareNode.getValue()) {
                compareNode = compareNode.getLeftNode();
            } else if ((toFind > compareNode.getValue())) {
                compareNode = compareNode.getRightNode();
            }
        }
        return false;
    }


    public void remove(Integer toRemove) {
        // TODO removes an element. Throws an error if its not on the tree.
    }

}
