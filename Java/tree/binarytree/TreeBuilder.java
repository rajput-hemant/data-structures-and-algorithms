package tree.binarytree;

import java.util.*;

import definitions.TreeNode;

public class TreeBuilder {
    static Scanner sc = new Scanner(System.in);
    static int index = -1;

    public static void main(String[] args) {
        // int[] nodes = getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        TreeNode root = buildTree(nodes);
        System.out.println("Data at Root -> " + root.data);
    }

    // a utiliy fn to take input in Binary Tree
    public static int[] getInput() {
        System.out.print("Enter the numbers of levels in Binary Tree, Levels starts from 0 -> ");
        double n = sc.nextInt();
        int size = (int) Math.pow(2, n) - 1;
        int[] nodes = new int[size];
        System.out.print("Enter the nodes, -1 if node is null -> ");
        for (int i = 0; i < size; i++)
            nodes[i] = sc.nextInt();
        return nodes;
    }

    public static TreeNode buildTree(int[] nodes) {
        // increament ot set the index to 0
        index++;
        if (nodes[index] == -1)
            return null;
        TreeNode newNode = new TreeNode(nodes[index]);
        // recursive call to build the left part of the tree,
        // branching will stop when node is null or -1
        newNode.left = buildTree(nodes);
        // recursive call to build the right part of the tree,
        // branching will stop when node is null or -1
        newNode.right = buildTree(nodes);
        return newNode;
    }
}
