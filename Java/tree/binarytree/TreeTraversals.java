package tree.binarytree;

import java.util.*;

import definitions.TreeNode;

public class TreeTraversals {
    public static void main(String[] args) {
        // int[] nodes = getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = TreeBuilder.buildTree(nodes);
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        levelOrderTraversal(root);
    }

    /*
     * Breadth First Traversal (BFT) -> levelOrderTraversal
     * Depth First Traversal (DFT) -> preOrderTraversal, inOrderTraversal, and
     * postOrderTraversal
     */

    /*
     * Time Complexity -> O(n)
     * Print order:
     * Root -> Left SubTree -> Right SubTree
     */
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        // recursive call to build the right part of the tree,
        // branching will stop when node is null or -1
        preOrderTraversal(root.left);
        // recursive call to build the right part of the tree,
        // branching will stop when node is null or -1
        preOrderTraversal(root.right);
    }

    /*
     * Time Complexity -> O(n)
     * Print order:
     * Left SubTree -> Root -> Right SubTree
     */
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        // recursive call to build the left part of the tree,
        // branching will stop when node is null or -1
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        // recursive call to build the right part of the tree,
        // branching will stop when node is null or -1
        inOrderTraversal(root.right);
    }

    /*
     * Time Complexity -> O(n)
     * Print order:
     * Left SubTree -> Right SubTree -> Root
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            System.out.print(-1 + " ");
            return;
        }
        // recursive call to build the left part of the tree,
        // branching will stop when node is null or -1
        postOrderTraversal(root.left);
        // recursive call to build the right part of the tree,
        // branching will stop when node is null or -1
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    /*
     * Time Complexity -> O(1)
     * Print same level Nodes (Using Queue FIFO)
     * NextLine
     * Approach 1
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        // this adds the root node in the Queue as the First element
        q.add(root);
        // this add null in the Queue as the Second Element
        q.add(null);
        // traverse until Queue becomes Empty
        while (!q.isEmpty()) {
            // remove element from the Queue and stores it in currentNode
            TreeNode currentNode = q.remove();
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

    /* Approach 2 */
    public static void levelOrderTraversal2(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        // this adds the root node in the Queue as the First element
        q.add(root);
        // traverse until Queue becomes Empty
        while (!q.isEmpty()) {
            int flag = q.size();
            // traverse till size of the queue to print the nodes at the same level
            for (int i = 0; i < flag; i++) {
                // remove element from the Queue and stores it in currentNode
                TreeNode currentNode = q.remove();
                // prints the data
                System.out.print(currentNode.data + " ");
                // adds left node to the Queue
                if (currentNode.left != null)
                    q.add(currentNode.left);
                // adds right node to the Queue
                if (currentNode.right != null)
                    q.add(currentNode.right);
            }
            System.out.println();
        }
    }
}
