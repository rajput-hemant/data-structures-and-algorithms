package tree.BinaryTree;

import tree.BinaryTree.BinaryTreeBuilder.Node;

public class HeightOfTree {
    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTreeBuilder.buildTree(nodes);
        System.out.println("Height Of Tree -> " + heightOfTree(root));
    }

    public static int heightOfTree(Node root) {
        // base case
        if (root == null)
            return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeitht = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeitht) + 1;
    }
}
