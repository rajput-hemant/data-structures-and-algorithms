package tree.BinaryTree;

import java.util.*;
import tree.BinaryTree.BinaryTreeBuilder.Node;

public class BinaryTreeTraversals {
    public static void main(String[] args) {
        // int[] nodes = getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTreeBuilder.buildTree(nodes);
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        levelOrderTraversal(root);
    }

    /*
     * Time Complexity -> O(n)
     * Left SubTree
     * Right SubTree
     * Root
     */
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /*
     * Time Complexity -> O(n)
     * Left SubTree
     * Root
     * Right SubTree
     */
    public static void inOrderTraversal(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        preOrderTraversal(root.left);
        System.out.print(root.data + " ");
        preOrderTraversal(root.right);
    }

    /*
     * Time Complexity -> O(n)
     * Left SubTree
     * Root
     * Right SubTree
     */
    public static void postOrderTraversal(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    /*
     * Print same level Nodes
     * NextLine
     */
    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else
                    q.add(null);
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null)
                    q.add(currentNode.left);
                if (currentNode.right != null)
                    q.add(currentNode.right);
            }
        }
    }
}
