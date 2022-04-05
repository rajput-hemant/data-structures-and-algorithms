package tree.binarysearchtree;

import java.util.Stack;

public class BSTIterative {
    Node root;

    public void insert(int x) {
        root = insert(root, x);
    }

    public boolean search(int x) {
        return search(root, x);
    }

    public void display() {
        display(root);
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(1)
    private Node insert(Node root, int x) {
        Node newNode = new Node(x);
        Node parentNode = null, currentNode = root;
        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.data > x)
                currentNode = currentNode.left;
            else if (currentNode.data < x)
                currentNode = currentNode.right;
            else
                return root;
        }
        if (parentNode == null)
            return newNode;
        if (parentNode.data > x)
            parentNode.left = newNode;
        else
            parentNode.right = newNode;
        return root;
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(1)
    private boolean search(Node root, int x) {
        while (root != null) {
            if (root.data == x)
                return true;
            else if (root.data > x)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }

    private void display(Node root) {
        Stack<Node> stk = new Stack<>();
        Node currentNode = root;
        System.out.print("[");
        while (currentNode != null || stk.isEmpty() == false) {
            while (currentNode != null) {
                stk.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stk.pop();
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.right;
        }
        System.out.println("\b\b]");
    }
}
