package tree.binarysearchtree;

import java.util.Stack;

public class BSTIterative {
    Node root;

    public void insert(int x) {
        root = insert(root, x);
    }

    public void delete(int x) {
        root = delete(root, x);
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
    private Node delete(Node root, int x) {
        if (root == null)
            return null;
        Node currentNode = root, parentNode = null;
        while (currentNode != null && currentNode.data != x) {
            parentNode = currentNode;
            if (currentNode.data > x)
                currentNode = currentNode.left;
            else
                currentNode = currentNode.right;
        }
        if (currentNode == null)
            return root;
        if (currentNode.left == null || currentNode.right == null) {
            Node newNode;
            if (currentNode.left == null)
                newNode = currentNode.right;
            else
                newNode = currentNode.left;
            if (parentNode == null)
                return newNode;
            if (currentNode == parentNode.left)
                parentNode.left = newNode;
            else
                parentNode.right = newNode;
        } else {
            Node inOrderParent = null, successor = currentNode.right;
            while (successor.left != null) {
                inOrderParent = successor;
                successor = successor.left;
            }
            if (inOrderParent != null)
                inOrderParent.left = successor.right;
            else
                currentNode.right = successor.right;
            currentNode.data = successor.data;
        }
        return root;
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(1)
    private static boolean search(Node root, int x) {
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
        if (root == null)
            return;
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
