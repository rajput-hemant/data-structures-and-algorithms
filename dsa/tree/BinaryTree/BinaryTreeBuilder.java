package tree.BinaryTree;

import java.util.*;

public class BinaryTreeBuilder {
    static Scanner sc = new Scanner(System.in);
    static int index = -1;

    static class Node {
        int data;
        Node right, left;

        Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    public static void main(String[] args) {
        // int[] nodes = getInput();
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);
        System.out.println("Data at Root -> " + root.data);
    }

    public static int[] getInput() {
        System.out.print("Enter the numbers of levels in Binary Tree, Levels starts from 0 -> ");
        double n = sc.nextInt();
        System.out.println(Math.pow(2, n) - 1);
        int size = (int) Math.pow(2, n) - 1;
        int[] nodes = new int[size];
        System.out.print("Enter the nodes, -1 if node is null -> ");
        for (int i = 0; i < size; i++)
            nodes[i] = sc.nextInt();
        return nodes;
    }

    public static Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1)
            return null;
        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }
}
