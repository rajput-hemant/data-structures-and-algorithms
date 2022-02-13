package tree.BinaryTree;

import tree.BinaryTree.BinaryTreeBuilder.Node;

public class SumOfNodes {
    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTreeBuilder.buildTree(nodes);
        System.out.println("Sum Of Nodes -> " + sumOfNodes(root));
    }

    // Fn to print the sum of the nodes
    public static int sumOfNodes(Node root) {
        // base case
        // if node is null
        if (root == null)
            return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        // through recursive call, the sum of leftChild, rightChild & parentNode is returned to the upperNode, till rootNode
        return leftSum + rightSum + root.data;
    }
}
