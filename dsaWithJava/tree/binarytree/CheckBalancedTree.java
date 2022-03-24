package tree.binarytree;

public class CheckBalancedTree {
    public static boolean isBalancedTree(Node root) {
        if (root == null)
            return true;
        int leftHeight = HeightOfTree.heightOfTree(root.left);
        int rightHeight = HeightOfTree.heightOfTree(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 9, -1, -1, 8, -1, -1 };
        Node root = TreeBuilder.buildTree(nodes);
        System.out.println("Is Balanced Tree -> " + isBalancedTree(root));
    }
}
