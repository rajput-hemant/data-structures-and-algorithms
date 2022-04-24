package tree.binarysearchtree;

public class IsBST {
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
}
