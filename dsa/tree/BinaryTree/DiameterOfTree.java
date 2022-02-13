package tree.BinaryTree;

import tree.BinaryTree.BinaryTreeBuilder.Node;

public class DiameterOfTree {
    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTreeBuilder.buildTree(nodes);
        System.out.println("Height Of Tree -> " + diameterOfTree(root));
    }

    // Time Complexity -> O(n^2)
    public static int diameterOfTree(Node root) {
        // base case
        if (root == null)
            return 0;
        int dia1 = diameterOfTree(root.left);
        int dia2 = diameterOfTree(root.right);
        int dia3 = HeightOfTree.heightOfTree(root.left) + HeightOfTree.heightOfTree(root.right) + 1;
        return Math.max(dia1, Math.max(dia2, dia3));
    }
//
}
