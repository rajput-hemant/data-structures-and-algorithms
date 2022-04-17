package tree.binarysearchtree;

public class BSTRecursive {
    Node root;

    public void insert(int data) {
        root = insert(root, data);
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    public boolean search(int data) {
        return search(root, data);
    }

    public void display() {
        display(root);
        System.out.println();
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(h)
    private Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (root.data > data)
            root.left = insert(root.left, data);
        else if (root.data < data)
            root.right = insert(root.right, data);
        return root;
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(h)
    private Node delete(Node root, int data) {
        if (root == null)
            return null;
        if (root.data > data)
            root.left = delete(root.left, data);
        else if (root.data < data)
            root.right = delete(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            Node successor = getSuccessor(root);
            root.data = successor.data;
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    private Node getSuccessor(Node root) {
        Node currentNode = root.right;
        while (currentNode != null && currentNode.left != null)
            currentNode = currentNode.left;
        return currentNode;
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(h)
    private boolean search(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        if (root.data > data)
            return search(root.left, data);
        else
            return search(root.right, data);
    }

    // Time Complexity -> O(n)
    // Auxiliary Space -> O(h)
    private void display(Node root) {
        if (root == null)
            return;
        display(root.left);
        System.out.print(root.data + " ");
        display(root.right);
    }
}
