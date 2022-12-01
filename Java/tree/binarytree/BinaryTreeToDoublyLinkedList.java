package tree.binarytree;

import definitions.TreeNode;

public class BinaryTreeToDoublyLinkedList {
    static TreeNode prevNode = null;

    public static TreeNode convertBinaryTreeToDoublyLinkedList(TreeNode root) {
        if (root == null)
            return root;
        TreeNode head = convertBinaryTreeToDoublyLinkedList(root.left);
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

    private static void display(TreeNode root) {
        if (root == null) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.print("[");
        for (TreeNode currentNode = root; currentNode != null; currentNode = currentNode.right)
            System.out.print(currentNode.data + ", ");
        System.out.println("\b\b]");
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = TreeBuilder.buildTree(nodes);
        TreeNode newNode = convertBinaryTreeToDoublyLinkedList(root);
        display(newNode);
    }
}
