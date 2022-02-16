package tree.binarytree;

import tree.binarytree.BinaryTreeBuilder.Node;

public class HeightOfTree {
    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTreeBuilder.buildTree(nodes);
        System.out.println("Height Of Tree -> " + heightOfTree(root));
    }

    // Fn to get the height/deapth of BinaryTree
    public static int heightOfTree(Node root) {
        // base case
        // If node is null
        if (root == null)
            return 0;
        // this counts the left nodes of the BinaryTree
        int leftHeight = heightOfTree(root.left);
        // this counts the right nodes of the BinaryTree
        int rightHeight = heightOfTree(root.right);
        // through recursive call, the sum of the max of leftHeight & rightHeight and rootNode is returned to the upperNode
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
