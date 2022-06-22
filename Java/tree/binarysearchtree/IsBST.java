package tree.binarysearchtree;

public class IsBST {
    // Time Complexity = O(n)
    public boolean isBST(Node root) {
    return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(Node root, long min, long max) {
        if (root == null)
            return true;
        if (root.data <= min || root.data >= max)
            return false;
        return (isBST(root.left, min, root.data) &&
                isBST(root.right, root.data, max));
    }
    /*
    int prev = Integer.MIN_VALUE;

    public boolean isBST(Node root) {
        if (root == null)
            return true;
        if (isBST(root.left) == false)
            return false;
        if (root.data <= prev)
            return false;
        prev = root.data;
        return isBST(root.right);
    }
    */
}
