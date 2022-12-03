package linkedlist;

import java.util.Scanner;

import definitions.ListNode;

public class MoveZeroesToFront extends SinglyLinkedList {
    static Scanner sc = new Scanner(System.in);

    public ListNode moveZeroes(ListNode head) {
        ListNode prevNode = head;
        ListNode currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.data == 0) {
                prevNode.next = currentNode.next;
                currentNode.next = head;
                head = currentNode;
                currentNode = prevNode.next;
                continue;
            }
            prevNode = prevNode.next;
            currentNode = currentNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MoveZeroesToFront ob = new MoveZeroesToFront();
        while (true) {
            int choice, data;
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete All\n" +
                    "4 to Move Zeroes to Front\n" +
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
                    System.out.print("Enter your Data -> ");
                    data = sc.nextInt();
                    ob.insertAtLast(data);
                }
                case 2 ->
                    ob.display();
                case 3 ->
                    ob.deleteAll();
                case 4 -> {
                    if (!ob.isEmpty())
                        ob.head = ob.moveZeroes(ob.head);
                    else
                        System.out.println("List is Empty!");
                }
                case 5 ->
                    System.exit(0);
                default ->
                    System.out.println("Wrong Choice!");
            }
        }
    }
}
