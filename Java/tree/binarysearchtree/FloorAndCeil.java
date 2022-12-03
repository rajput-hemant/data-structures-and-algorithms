package tree.binarysearchtree;

import java.util.Scanner;

public class FloorAndCeil extends BSTRecursive {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        FloorAndCeil ob = new FloorAndCeil();
        while (true) {
            int choice, data;
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete\n" +
                    "4 to Search\n" +
                    "5 to Get Floor\n" +
                    "6 to Get Ceil\n" +
                    "7 to exit()\n" +
                    "Enter your choice -> ");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong Input! Only Integer value is allowed.");
                sc.next();
                continue;
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the Data to Insert -> ");
                    data = sc.nextInt();
                    ob.insert(data);
                }
                case 2 ->
                    ob.display();
                case 3 -> {
                    System.out.print("Enter the Data to Delete -> ");
                    data = sc.nextInt();
                    ob.delete(data);
                }
                case 4 -> {
                    System.out.print("Enter the Data to Search -> ");
                    data = sc.nextInt();
                    System.out.println((ob.search(data) ? "Element Exists!" : "Element Doesn't Exists!"));
                }
                case 5 -> {
                    System.out.print("Enter the Number -> ");
                    int floor = sc.nextInt();
                    try {
                        System.out.println(ob.getFloorIterative(ob.root, floor).data);
                    } catch (Exception e) {
                        System.out.println("null");
                    }
                }
                case 6 -> {
                    System.out.print("Enter the Number -> ");
                    int ceil = sc.nextInt();
                    try {
                        System.out.println(ob.getCeilIterative(ob.root, ceil).data);
                    } catch (Exception e) {
                        System.out.println("null");
                    }
                }
                case 7 ->
                    System.exit(0);
                default ->
                    System.out.println("Wrong Choice!");
            }
        }
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(1)
    public Node getFloorIterative(Node root, int num) {
        Node floor = null;
        while (root != null) {
            if (root.data == num)
                return root;
            if (root.data > num)
                root = root.left;
            else {
                floor = root;
                root = root.right;
            }
        }
        return floor;
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(h)
    public Node getFloorRecursive(Node root, int num) {
        return getFloorRecursive(root, num, null);
    }

    private Node getFloorRecursive(Node root, int num, Node floor) {
        if (root == null)
            return floor;
        if (root.data == num)
            return root;
        if (root.data > num)
            return getFloorRecursive(root.left, num, floor);
        else
            return getFloorRecursive(root.right, num, root);
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(1)
    public Node getCeilIterative(Node root, int num) {
        Node ceil = null;
        while (root != null) {
            if (root.data == num)
                return root;
            if (root.data < num)
                root = root.right;
            else {
                ceil = root;
                root = root.left;
            }
        }
        return ceil;
    }

    // Time Complexity -> O(h)
    // Auxiliary Space -> O(h)
    public Node getCeilRecursive(Node root, int num) {
        return getCeilRecursive(root, num, null);
    }

    private Node getCeilRecursive(Node root, int num, Node ceil) {
        if (root == null)
            return ceil;
        if (root.data == num)
            return root;
        if (root.data < num)
            return getCeilRecursive(root.right, num, ceil);
        else
            return getCeilRecursive(root.left, num, root);
    }
}
