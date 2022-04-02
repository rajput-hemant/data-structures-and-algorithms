package tree.binarytree;

import java.util.Stack;

public class SpiralTraversal {
    public static void spiralTraversal(Node root) {
        if (root == null)
            return;
        Stack<Node> stk1 = new Stack<>(), stk2 = new Stack<>();
        stk1.push(root);
        while (!stk1.isEmpty() || !stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                Node currentNode = stk1.pop();
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null)
                    stk2.push(currentNode.left);
                if (currentNode.right != null)
                    stk2.push(currentNode.right);
            }
            System.out.println();
            while (!stk2.isEmpty()) {
                Node currentNode = stk2.pop();
                System.out.print(currentNode.data + " ");
                if (currentNode.right != null)
                    stk1.push(currentNode.right);
                if (currentNode.left != null)
                    stk1.push(currentNode.left);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = TreeBuilder.buildTree(nodes);
        spiralTraversal(root);
    }
}
