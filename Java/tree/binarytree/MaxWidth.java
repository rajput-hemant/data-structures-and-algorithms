package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import definitions.TreeNode;

public class MaxWidth {
    public static int maxWidth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int width = 0;
        while (!q.isEmpty()) {
            int flag = q.size();
            width = Math.max(width, flag);
            for (int i = 0; i < flag; i++) {
                TreeNode currentNode = q.remove();
                if (currentNode.left != null)
                    q.add(currentNode.left);
                if (currentNode.right != null)
                    q.add(currentNode.right);
            }
        }
        return width;
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 9, -1, -1, 8, -1, -1 };
        TreeNode root = TreeBuilder.buildTree(nodes);
        System.out.println("Max Width of Binary Tree is -> " + maxWidth(root));
    }
}
