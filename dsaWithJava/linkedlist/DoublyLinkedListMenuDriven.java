package linkedlist;

import java.util.Scanner;

public class DoublyLinkedListMenuDriven {
    static Scanner sc = new Scanner(System.in);
    static DoublyLinkedList dll = new DoublyLinkedList();
    static DoublyLinkedListMenuDriven ob = new DoublyLinkedListMenuDriven();

    public static void main(String[] args) {
        while (true) {
            int choice;
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete\n" +
                    "4 to Delete All\n" +
                    "5 to Print Reverse\n" +
                    "6 to exit()\n" +
                    "Enter your Choice -> ");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong Input! Only Integer value is allowed.");
                sc.next();
                continue;
            }
            switch (choice) {
                case 1:
                    ob.insert();
                    break;
                case 2:
                    dll.display();
                    break;
                case 3:
                    ob.delete();
                    break;
                case 4:
                    dll.deleteAll();
                    break;
                case 5:
                    dll.printReverse();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice! ");
            }
        }
    }

    public void insert() {
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Insertion at Beginning\n" +
                    "2 to Insertion Inbetween\n" +
                    "3 to Insertion at Last\n" +
                    "4 Go Back\n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            int data = 0;
            switch (choice) {
                case 1:
                    System.out.print("Enter your Data -> ");
                    data = sc.nextInt();
                    dll.insertAtBegin(data);
                    break;
                case 2:
                    System.out.print("Enter your Data -> ");
                    data = sc.nextInt();
                    System.out.print("Enter the Index -> ");
                    int pos = sc.nextInt();
                    dll.insertAtPos(data, pos);
                    break;
                case 3:
                    System.out.print("Enter your Data -> ");
                    data = sc.nextInt();
                    dll.insertAtLast(data);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong Input!");
            }
        }
    }

    public void delete() {
        if (dll.isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.print("Press:\n" +
                "1 to Deletion at Beginning\n" +
                "2 to Deletion Inbetween\n" +
                "3 to Deletion at Last\n" +
                "Enter your choice -> ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                dll.delAtBegin();
                return;
            case 2:
                System.out.print("Enter the Index -> ");
                int pos = sc.nextInt();
                dll.delAtPos(pos);
                return;
            case 3:
                dll.delAtLast();
                return;
            default:
                System.out.println("Wrong Input!");
        }
    }
}
