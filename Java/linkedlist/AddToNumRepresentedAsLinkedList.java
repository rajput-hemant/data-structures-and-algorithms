package linkedlist;

import java.util.Scanner;

import definitions.ListNode;

public class AddToNumRepresentedAsLinkedList {
    static Scanner sc = new Scanner(System.in);
    static ListNode head;

    public static void main(String[] args) {
        AddToNumRepresentedAsLinkedList ob = new AddToNumRepresentedAsLinkedList();
        while (true) {
            int choice;
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete\n" +
                    "4 to Add\n" +
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
                    System.out.print("Enter a Digit -> ");
                    int data = sc.nextInt();
                    if (data / 10 == 0)
                        ob.insert(data);
                    else
                        System.out.println("Wrong Input! Enter a Digit Only!");
                    break;
                case 2:
                    ob.display();
                    break;
                case 3:
                    ob.delete();
                    break;
                case 4:
                    head = ob.addToNum(head);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }

    public ListNode addToNum(ListNode head) {
        System.out.print("Enter the Number to add -> ");
        int sum = 0, carry = sc.nextInt();
        ListNode newHead = reverse(head);
        ListNode currentNode = newHead, prevNode = newHead;
        while (currentNode != null) {
            sum = carry + currentNode.data;
            currentNode.data = sum % 10;
            carry = sum / 10;
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        if (carry > 0)
            prevNode.next = new ListNode(carry);
        head = reverse(newHead);
        return head;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private boolean isEmpty() {
        return head == null;
    }

    private void insert(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
            System.out.println("Digit Inserted!");
            return;
        }
        ListNode currentNode = head;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = newNode;
        System.out.println("Digit Inserted!");
    }

    private void delete() {
        if (isEmpty()) {
            System.out.println("Empty!");
            return;
        }
        System.out.println("Successfully Cleared!");
        head = null;
    }

    private void display() {
        if (isEmpty()) {
            System.out.println("Empty!");
            return;
        }
        System.out.print("Number -> ");
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}