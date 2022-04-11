package tree.avltree;

import java.util.Scanner;

public class AVLMenuDriven {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AVL avl = new AVL();
        while (true) {
            int choice;
            int data;
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete\n" +
                    "4 to Search\n" +
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
                    avl.insert(data);
                    break;
                case 2:
                    avl.display();
                    break;
                case 3:
                    System.out.print("Enter the Data to Delete -> ");
                    data = sc.nextInt();
                    avl.delete(data);
                    break;
                case 4:
                    System.out.print("Enter the Data to Search -> ");
                    data = sc.nextInt();
                    System.out.println((avl.search(data) ? "Element Exists!" : "Element Doesn't Exists!"));
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
