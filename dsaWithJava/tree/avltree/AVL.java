package tree.avltree;

/**
 * -> It is a BST (For every node, left subtree is smaller & right subtree is
 * greater)
 * <p>
 * -> It is Balanced (For every node, differerce b/w left & right heights <= 1)
 * <p>
 * Balance Factor: |leftHeight - rightHeight| <= 1
 */
public class AVL {
    public Node root;

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

    private Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (root.data > data)
            root.left = insert(root.left, data);
        else if (root.data < data)
            root.right = insert(root.right, data);
        else
            return root;
        root.height = height(root);
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1 && data < root.left.data)
            return rightRotate(root);
        if (balanceFactor < -1 && data > root.right.data)
            return leftRotate(root);
        if (balanceFactor > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balanceFactor < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private Node delete(Node root, int data) {
        if (root == null)
            return root;
        if (root.data > data)
            root.left = delete(root.left, data);
        else if (root.data < data)
            root.right = delete(root.right, data);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = getSuccessor(root);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        if (root == null)
            return root;
        root.height = height(root);
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1 && getBalanceFactor(root.left) >= 0)
            return rightRotate(root);
        if (balanceFactor < -1 && getBalanceFactor(root.right) <= 0)
            return leftRotate(root);
        if (balanceFactor > 1 && getBalanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balanceFactor < -1 && getBalanceFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private Node getSuccessor(Node root) {
        Node currentNode = root.right;
        while (currentNode.left != null)
            currentNode = currentNode.left;
        return currentNode;
    }

    private int height(Node root) {
        if (root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }

    private int getBalanceFactor(Node root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }

    private Node leftRotate(Node root) {
        Node rightNode = root.right;
        Node temp = rightNode.left;
        rightNode.left = root;
        root.right = temp;
        root.height = height(root);
        rightNode.height = height(rightNode);
        return rightNode;
    }

    private Node rightRotate(Node root) {
        Node leftNode = root.left;
        Node temp = leftNode.right;
        leftNode.right = root;
        root.left = temp;
        root.height = height(root);
        leftNode.height = height(leftNode);
        return leftNode;
    }

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

    private void display(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }
}
