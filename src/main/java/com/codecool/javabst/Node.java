package com.codecool.javabst;


public class Node {

    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value, Node leftNode, Node rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Node(int value) {
        this.value = value;
    }

    public void setLeft(Node leftChild) {this.leftNode= leftChild;
    }

    public void setRight(Node rightChild) {
        rightNode = rightChild;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftNode() {
        return this.leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
}
