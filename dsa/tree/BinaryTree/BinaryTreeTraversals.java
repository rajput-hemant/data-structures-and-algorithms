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
     * Print order:
     * Root -> Left SubTree -> Right SubTree
     */
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        // recursive call to build the right part of the tree, branching will stop when node is null or -1
        preOrderTraversal(root.left);
        // recursive call to build the right part of the tree, branching will stop when node is null or -1
        preOrderTraversal(root.right);
    }

    /*
     * Time Complexity -> O(n)
     * Print order:
     * Left SubTree -> Root -> Right SubTree
     */
    public static void inOrderTraversal(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        // recursive call to build the left part of the tree, branching will stop when node is null or -1
        preOrderTraversal(root.left);
        System.out.print(root.data + " ");
        // recursive call to build the right part of the tree, branching will stop when node is null or -1
        preOrderTraversal(root.right);
    }

    /*
     * Time Complexity -> O(n)
     * Print order:
     * Left SubTree -> Right SubTree -> Root
     */
    public static void postOrderTraversal(Node root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        // recursive call to build the left part of the tree, branching will stop when node is null or -1
        postOrderTraversal(root.left);
        // recursive call to build the right part of the tree, branching will stop when node is null or -1
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    /*
     * Time Complexity -> O(1)
     * Print same level Nodes (Using Queue FIFO)
     * NextLine
     */
    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        // this adds the root node in the Queue as the First element
        q.add(root);
        // this add null in the Queue as the Second Element
        q.add(null);
        // traverse until Queue becomes Empty
        while (!q.isEmpty()) {
            // remove element from the Queue and stores it in currentNode
            Node currentNode = q.remove();
            // if currentNode is null, prints the nextline
            if (currentNode == null) {
                System.out.println();
                // if Queue is Empty i.e. if tree is fully traversed, break the loop
                if (q.isEmpty())
                    break;
                // if Queue is not empty, add null at the last of the Queue
                else
                    q.add(null);
            }
            // if currentNode isn't null
            else {
                // prints the data
                System.out.print(currentNode.data + " ");
                // adds left node to the Queue
                if (currentNode.left != null)
                    q.add(currentNode.left);
                // adds right node to the Queue
                if (currentNode.right != null)
                    q.add(currentNode.right);
            }
        }
    }
}
