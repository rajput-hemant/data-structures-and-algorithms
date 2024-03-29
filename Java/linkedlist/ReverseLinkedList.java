package linkedlist;

import java.util.Scanner;

import definitions.ListNode;

public class ReverseLinkedList extends SinglyLinkedListMenuDriven {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ReverseLinkedList ob = new ReverseLinkedList();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete\n" +
                    "4 to Delete All\n" +
                    "5 to Reverse the List\n" +
                    "6 to exit()\n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ob.insert();
                    break;
                case 2:
                    ob.display();
                    break;
                case 3:
                    ob.delete();
                    break;
                case 4:
                    ob.deleteAll();
                    break;
                case 5:
                    ob.reverseLinkedList();
                    // ob.head = ob.reverseRecurssive(ob.head);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }

    public void reverseLinkedList() {
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Reverse LinkedList by Iterative Method\n" +
                    "2 to Reverse LinkedList by Recursive Method\n" +
                    "3 Print the Reverse without changing/updating the List\n" +
                    "Enter your Choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (head == null)
                        System.out.println("List is Empty!");
                    reverseIterate();
                    return;
                case 2:
                    head = reverseRecurssive(head);
                    if (head == null)
                        System.out.println("List is Empty!");
                    if (head != null)
                        System.out.println("List Successfully Reversed!");
                    return;
                case 3:
                    System.out.print("[");
                    printReverseLinkedList(head);
                    System.out.println("\b\b]\nList Size -> " + size);
                    if (head == null)
                        System.out.println("List is Empty!");
                    return;
                default:
                    System.out.println("Wrong Choice!");
                    return;
            }
        }
    }

    public void reverseIterate() {
        // If there one or no element 
        if (head == null || head.next == null)
            return;
        ListNode prevNode = head;
        ListNode currentNode = head.next;
        // Traverse from 2nd element to last element
        while (currentNode != null) {
            // next of currentNode i.e. the address/link of next element is stored in nextNode
            ListNode nextNode = currentNode.next;
            // next of currentNode points to prevNode
            currentNode.next = prevNode;
            // update all nodes
            prevNode = currentNode;
            currentNode = nextNode;
        }
        // the remaining next i.e the next of the first element which is holding the address/link of second element is set to null
        head.next = null;
        // last element is set to head
        head = prevNode;
        System.out.println("List Successfully Reversed!");
    }

    public ListNode reverseRecurssive(ListNode head) {
        // base case
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseRecurssive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void printReverseLinkedList(ListNode head) {
        // base case
        if (head == null)
            return;
        printReverseLinkedList(head.next);
        System.out.print(head.data + ", ");
    }
}
