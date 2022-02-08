package linkedlist;

import java.util.Scanner;

public class FindNthNodeFromLast extends ReverseLinkedList {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        FindNthNodeFromLast ob = new FindNthNodeFromLast();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Traverse\n" +
                    "3 to Delete\n" +
                    "4 to Delete All\n" +
                    "5 to Reverse the List\n" +
                    "6 to Nth Element from Last\n" +
                    "7 to exit()\n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ob.insert();
                    break;
                case 2:
                    ob.dislpay();
                    break;
                case 3:
                    ob.delete();
                    break;
                case 4:
                    ob.deleteAll();
                    break;
                case 5:
                    ob.reverseLinkedList();
                    break;
                case 6:
                    ob.getNthNodeFromLast();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }

    public void getNthNodeFromLast() {
        System.out.print("Press:\n" +
                "1 to Print the Nth Element from the Last\n" +
                "2 to Delete the Nth Element from the Last\n" +
                "Enter your Choice -> ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                printNthNodeFromLast();
                break;
            case 2:
                delNthNodeFromLast();
                break;
            default:
                System.out.println("Wrong Choice!");
        }
    }

    public void printNthNodeFromLast() {
        // If list is Empty
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        // If list has only 1 element
        else if (head.next == null) {
            System.out.println(head.data);
            return;
        }
        System.out.print("Enter the Index -> ");
        int i = sc.nextInt();
        // To a void head.next is null error, as the next of last node will always be
        // null.
        if (i == 0) {
            System.out.println("Invalid Input! Index Starts from 1.");
            return;
        }
        // If index is greater than the size of the list
        else if (i > size) {
            System.out.println("Invalid Input! List Size is: " + size);
            return;
        }
        Node currentNode = head;
        // Traverse till the index, index from last = size - index from the front
        for (int j = 0; j < size - i; j++)
            currentNode = currentNode.next;
        System.out.println(currentNode.data);
    }

    public void delNthNodeFromLast() {
        // If list is Empty
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        // If list has only 1 element
        else if (head.next == null) {
            head = null;
            System.out.println("List Successfully Cleared!");
            size = 0;
            return;
        }
        System.out.print("Enter the Index -> ");
        int i = sc.nextInt();
        // To a void head.next is null error, as the next of last node will always be null.
        if (i == 0) {
            System.out.println("Invalid Input! Index Starts from 1.");
            return;
        }
        // If index is greater than the size of the list
        else if (i > size) {
            System.out.println("Invalid Input! List Size is: " + size);
            return;
        }
        Node curreNode = head;
        for (int j = 0; j < size - i - 1; j++)
            curreNode = curreNode.next;
        curreNode.next = curreNode.next.next;
        System.out.println("Successfully Deleted!");
    }
}
