package tree.avltree;

public class Node {
    int data, height;
    Node left, right;

    Node() {

    }

    Node(int data) {
        this.data = data;
        this.height = 1;
        this.left = this.right = null;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.height = 1;
        this.left = left;
        this.right = right;
    }
}
