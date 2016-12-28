package com.tree.binary;

/**
 * Created by hackus on 12/26/16.
 */
public class Node {
    private Node left;
    private Node right;
    private String value;

    public Node(String value){
        this.value = value;
    }

    public Node(int value){
        this.value = Integer.toString(value);
    }

    public int getLength(){
        return value.length();
    }

    public boolean isLeftNull(){
        return left == null;
    }

    public boolean isRightNull(){
        return right == null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
