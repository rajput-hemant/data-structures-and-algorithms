package linkedlist;

import java.util.Scanner;

public class IsLinkedListPallindrome extends ReverseLinkedList {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        IsLinkedListPallindrome ob = new IsLinkedListPallindrome();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Traverse\n" +
                    "3 to Delete\n" +
                    "4 to Delete All\n" +
                    "5 to \n" +
                    "6 to exit()\n" +
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
                    System.out.println("Is LinkedList Pallindrome? -> " + ob.isLinkedListPallindrome());
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }

    public boolean isLinkedListPallindrome() {
        // If list has one or no element
        if (head == null || head.next == null)
            return true;
        // this gives the last element of First Half of the LinkedList
        Node middle = findMiddle(head);
        Node firstHalfHead = head;
        Node secondHalfHead = reverseRecurssive(middle.next);
        // traverse from start to null of Second Half of the LinkedList
        while (secondHalfHead.next != null) {
            if (firstHalfHead.data != secondHalfHead.data)
                return false;
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;
    }
    // here, Tortoise-Hare-Approach (Floyd's Algorithm) is used
    // the hare pointer leaps 2 elements while turtle pointer leaps one 
    public Node findMiddle(Node head) {
        Node hare = head, turtle = head;
        // In case of odd length, e.g. 1 2 1, turtle will 2 as middle as hare.next & hare.next.next are null
        // In case of even length, e.g. 1 2 3 3 2 1, turtle will return the second middle,
        // as the hare will be on null & hare.next & hare.next.next are null
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }
}
