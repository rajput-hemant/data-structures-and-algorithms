package tree.binarysearchtree;

public class Node {
    int data;
    Node left;
    Node right;

    Node() {

    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
