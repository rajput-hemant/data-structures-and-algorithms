package tree.binarytree;

import definitions.TreeNode;

public class ChildrenSumProperty {
    public static boolean isChildSum(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return true;
        int sum = root.left.data + root.right.data;
        return sum == root.data && isChildSum(root.left) && isChildSum(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = TreeBuilder.buildTree(nodes);
        System.out.println("Follows Children Sum Property -> " + isChildSum(root));
    }
}
