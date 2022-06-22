package linkedlist;

import java.util.Scanner;

public class CountOddEvenNodes {
    static Scanner sc = new Scanner(System.in);
    int oddNodes, evenNodes;

    CountOddEvenNodes(int oddNodes, int evenNodes) {
        this.oddNodes = oddNodes;
        this.evenNodes = evenNodes;
    }

    static boolean isEmpty(Node head) {
        return head == null;
    }

    static CountOddEvenNodes countOddEveNodes(Node head) {
        return countOddEveNodes(head, 0, 0);
    }

    private static CountOddEvenNodes countOddEveNodes(Node head, int oddNodes, int evenNodes) {
        if (isEmpty(head))
            return new CountOddEvenNodes(0, 0);
        while (head != null) {
            if (head.data % 2 == 0)
                evenNodes++;
            else
                oddNodes++;
            head = head.next;
        }
        return new CountOddEvenNodes(oddNodes, evenNodes);
    }

    public static void main(String[] args) {
        SinglyLinkedList ob = new SinglyLinkedList();
        while (true) {
            int choice, data;
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete All\n" +
                    "4 to Count Odd Even Nodes\n" +
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
                    CountOddEvenNodes res = countOddEveNodes(ob.head);
                    System.out.println("Even Nodes -> " + res.evenNodes);
                    System.out.println("Odd Nodes -> " + res.oddNodes);
                }
                case 5 ->
                    System.exit(0);
                default ->
                    System.out.println("Wrong Choice!");
            }
        }
    }
}