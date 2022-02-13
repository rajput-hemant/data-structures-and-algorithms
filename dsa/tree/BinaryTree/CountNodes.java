package tree.BinaryTree;

import tree.BinaryTree.BinaryTreeBuilder.Node;

public class CountNodes {
    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTreeBuilder.buildTree(nodes);
        System.out.println("Number Of Nodes -> " + countNodes(root));
    }

    public static int countNodes(Node root) {
        // base case
        if (root == null)
            return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }
}
