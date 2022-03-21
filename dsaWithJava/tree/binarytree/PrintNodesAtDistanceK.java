package tree.binarytree;

public class PrintNodesAtDistanceK {
    public static void printAtK(Node root, int k) {
        if (root == null)
            return;
        if (k == 0) {
            System.out.print(root.data + " ");
            return;
        }
        printAtK(root.left, k - 1);
        printAtK(root.right, k - 1);
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = TreeBuilder.buildTree(nodes);
        printAtK(root, 2);
    }
}
