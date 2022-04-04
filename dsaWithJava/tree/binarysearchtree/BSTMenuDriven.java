package tree.binarysearchtree;

import java.util.Scanner;

public class BSTMenuDriven {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BSTRecursive bst = new BSTRecursive();
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
                case 1:
                    System.out.print("Enter the Data to Insert -> ");
                    data = sc.nextInt();
                    bst.insert(data);
                    break;
                case 2:
                    System.out.print("Enter the Data to Delete -> ");
                    data = sc.nextInt();
                    bst.delete(data);
                    break;
                case 3:
                    System.out.print("Enter the Data to Search -> ");
                    data = sc.nextInt();
                    System.out.println((bst.search(data) ? "Element Exists!" : "Element Doesn't Exists!"));
                    break;
                case 4:
                    bst.display();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }
}
