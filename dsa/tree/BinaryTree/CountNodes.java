package tree.BinaryTree;

import tree.BinaryTree.BinaryTreeBuilder.Node;

public class CountNodes {
    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTreeBuilder.buildTree(nodes);
        System.out.println("Number Of Nodes -> " + countNodes(root));
    }

    // Fn to count nodes in the BinaryTree
    public static int countNodes(Node root) {
        // base case
        // if node is null
        if (root == null)
            return 0;
        // recursive call to count left nodes
        int leftNodes = countNodes(root.left);
        // recursive call to count right nodes
        int rightNodes = countNodes(root.right);
        // sum of leftNodes, rightNodes & rootNode
        return leftNodes + rightNodes + 1;
    }
}
