package tree.binarytree;

public class PrintLeftView {
    public static void printLeftView(Node root) {
        printLeftView(root, 1);
    }

    static int maxLevel = 0;

    static private void printLeftView(Node root, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            System.out.println(root.data + " ");
            maxLevel = level;
        }
        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = TreeBuilder.buildTree(nodes);
        printLeftView(root);
    }
}