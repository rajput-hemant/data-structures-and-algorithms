package tree.BinaryTree;

import tree.BinaryTree.BinaryTreeBuilder.Node;

public class SumOfNodes {
    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTreeBuilder.buildTree(nodes);
        System.out.println("Sum Of Nodes -> " + sumOfNodes(root));
    }

    public static int sumOfNodes(Node root) {
        // base case
        if (root == null)
            return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }
}
