package tree.binarysearchtree;

import java.util.Scanner;

public class BSTMenuDriven {
    static Scanner sc = new Scanner(System.in);
    static BSTIterative bst = new BSTIterative();
    // static BSTRecursive bst = new BSTRecursive();

    static private boolean isEmpty() {
        return bst.root == null;
    }

    public static void main(String[] args) {
        while (true) {
            int choice;
            int data;
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Delete\n" +
                    "3 to Search\n" +
                    "4 to Display\n" +
                    "5 to exit()\n" +
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
                    bst.insert(data);
                }
                case 2 -> {
                    if (isEmpty())
                        System.out.println("BST is Empty!");
                    else {
                        System.out.print("Enter the Data to Delete -> ");
                        data = sc.nextInt();
                        bst.delete(data);
                    }
                }
                case 3 -> {
                    if (isEmpty())
                        System.out.println("BST is Empty!");
                    else {
                        System.out.print("Enter the Data to Search -> ");
                        data = sc.nextInt();
                        System.out.println((bst.search(data) ? "Element Exists!" : "Element Doesn't Exists!"));
                    }
                }
                case 4 -> {
                    if (isEmpty())
                        System.out.println("BST is Empty!");
                    else
                        bst.display();
                }
                case 5 ->
                    System.exit(0);
                default ->
                    System.out.println("Wrong Choice!");
            }
        }
    }
}
