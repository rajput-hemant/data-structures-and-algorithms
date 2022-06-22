package tree.binarytree;

public class CheckBalancedTree {

    // Naive Approach
    // Time Complexity -> O(n^2)
    // public static boolean isBalancedTree(Node root) {
    // if (root == null)
    // return true;
    // int leftHeight = HeightOfTree.heightOfTree(root.left);
    // int rightHeight = HeightOfTree.heightOfTree(root.right);
    // return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedTree(root.left)
    // && isBalancedTree(root.right);
    // }

    // Time Complexity -> O(n)
    public static boolean isBalancedTree(Node root) {
        return !(isBalTree(root) == -1);
    }

    private static int isBalTree(Node root) {
        if (root == null)
            return 0;
        int leftHeight = isBalTree(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = isBalTree(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 9, -1, -1, 8, -1, -1 };
        Node root = TreeBuilder.buildTree(nodes);
        System.out.println("Is Balanced Tree -> " + isBalancedTree(root));
    }
}
