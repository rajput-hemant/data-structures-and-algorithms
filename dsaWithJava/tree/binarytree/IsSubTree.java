package tree.binarytree;

import tree.binarytree.BinaryTreeBuilder.Node;

public class IsSubTree {
    public static void main(String[] args) {
        // int[] nodes = BinaryTreeHelper.getInput();
        int[] nodes1 = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int[] nodes2 = { 1, 2, 4 };
        Node root = BinaryTreeBuilder.buildTree(nodes1);
        Node subRoot = BinaryTreeBuilder.buildTree(nodes2);
        System.out.println("Is SubTree? -> " + isSubTree(root, subRoot));
    }
// Fn to check if a tree is subTree of another tree
    public static boolean isSubTree(Node root, Node subRoot) {
        // base cases
        if (subRoot == null)
            return true;
        if (root == null)
            return false;
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot))
                return true;
        }
        if (root.data == subRoot.data)
            return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
        return false;
    }

    static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        return isIdentical(root.left, subRoot) && isIdentical(root.right, subRoot);
    }
}
