package tree.binarytree;

public class MaxNode {
    public static int getMax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = TreeBuilder.buildTree(nodes);
        System.out.println(getMax(root));
    }
}
