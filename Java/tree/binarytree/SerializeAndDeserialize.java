package tree.binarytree;

import java.util.ArrayList;

import definitions.TreeNode;

public class SerializeAndDeserialize {
    public static void serialize(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            arr.add(-1);
            return;
        }
        arr.add(root.data);
        serialize(root.left, arr);
        serialize(root.right, arr);
    }

    static int index = 0;

    public static TreeNode deSerialize(ArrayList<Integer> arr) {
        if (index == arr.size())
            return null;
        int data = arr.get(index++);
        if (data == -1)
            return null;
        TreeNode root = new TreeNode(data);
        root.left = deSerialize(arr);
        root.right = deSerialize(arr);
        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = TreeBuilder.buildTree(nodes);
        serialize(root, arr);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        TreeNode newRoot = deSerialize(arr);
        TreeTraversals.preOrderTraversal(newRoot);
        System.out.println();
    }
}
