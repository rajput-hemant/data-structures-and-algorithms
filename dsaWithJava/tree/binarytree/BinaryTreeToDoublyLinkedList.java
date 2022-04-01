package tree.binarytree;

public class BinaryTreeToDoublyLinkedList {
    static Node prevNode = null;

    public static Node convertBinaryTreeToDoublyLinkedList(Node root) {
        if (root == null)
            return root;
        Node head = convertBinaryTreeToDoublyLinkedList(root.left);
        if (prevNode == null)
            head = root;
        else {
            root.left = prevNode;
            prevNode.right = root;
        }
        prevNode = root;
        convertBinaryTreeToDoublyLinkedList(root.right);
        return head;
    }

    private static void display(Node root) {
        if (root == null) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.print("[");
        for (Node currentNode = root; currentNode != null; currentNode = currentNode.right)
            System.out.print(currentNode.data + ", ");
        System.out.println("\b\b]");
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = TreeBuilder.buildTree(nodes);
        Node newNode = convertBinaryTreeToDoublyLinkedList(root);
        display(newNode);
    }
}
