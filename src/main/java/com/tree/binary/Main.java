package com.tree.binary;

/**
 * Created by hackus on 12/26/16.
 */
public class Main {
    public static void main(String[] args){
        Node tree = new Node(1);

        tree.setLeft(new Node(2));
        tree.setRight(new Node(3));

        tree.getLeft().setLeft(new Node("2.1"));
        tree.getLeft().setRight(new Node("2.2"));

        tree.getLeft().getRight().setLeft(new Node("2.2.2"));
        tree.getLeft().getRight().getLeft().setRight(new Node("2.2.2.4"));

        tree.getRight().setLeft(new Node("3.1"));
        tree.getRight().setRight(new Node("3.2"));

        tree.getRight().getRight().setLeft(new Node("4.1"));
        tree.getRight().getRight().setRight(new Node("4.2"));

        TreeUtils utils = new TreeUtils();

        utils.print2(tree, 0, 1, false);
        utils.showTree();
    }
}
