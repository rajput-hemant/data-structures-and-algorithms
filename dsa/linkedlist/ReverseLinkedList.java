package linkedlist;

import java.util.Scanner;

public class ReverseLinkedList extends SinglyLinkedList {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ReverseLinkedList ob = new ReverseLinkedList();
        while (true) {
            System.out.print("Press:\n" +
                    "1 for Insert\n" +
                    "2 for Traverse\n" +
                    "3 for Delete\n" +
                    "4 for Delete All\n" +
                    "5 for Reverse the List\n" +
                    "6 for exit()\n" +
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
                    "1 for Reverse LinkedList by Iterative Method\n" +
                    "2 for Reverse LinkedList by Recursive Method\n" +
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
        Node prevNode = head;
        Node currentNode = head.next;
        // Traverse from 2nd element to last element
        while (currentNode != null) {
            // next of currentNode i.e. the address/link of next element is stored in nextNode
            Node nextNode = currentNode.next;
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

    public Node reverseRecurssive(Node head) {
        // base case
        if (head == null || head.next == null)
            return head;
        Node newHead = reverseRecurssive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void printReverseLinkedList(Node head) {
        // base case
        if (head == null)
            return;
        printReverseLinkedList(head.next);
        System.out.print(head.data + ", ");
    }
}
