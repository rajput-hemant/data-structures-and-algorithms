package tree.binarytree;

import definitions.TreeNode;

public class MaxNode {
    public static int getMax(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = TreeBuilder.buildTree(nodes);
        System.out.println(getMax(root));
    }
}
