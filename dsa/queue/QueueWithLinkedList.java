package queue;

import java.util.Scanner;

public class QueueWithLinkedList {
    static Scanner sc = new Scanner(System.in);
    static Node head, tail;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Add \n" +
                    "2 to Remove \n" +
                    "3 to Peek \n" +
                    "4 to Display \n" +
                    "5 to Exit \n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    System.out.println("Exited!");
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice!");
                    break;
            }
        }
    }

    // Fn to check if Queue is empty
    private static boolean isEmpty() {
        return head == null && tail == null;
    }

    // Time Complexity -> O(1)
    // enqueue/add - Fn to add elements in the Queue
    private static void add() {
        System.out.print("Enter the Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        // If queue is Empty
        if (tail == null) {
            tail = head = newNode;
            System.out.println("Data Inserted!");
            return;
        }
        // next of tail will point to newNode
        tail.next = newNode;
        // tail is set to newNode
        tail = newNode;
        System.out.println("Data inserted!");
    }

    // Time Complexity -> O(1)
    // dequeue/remove - Fn to print & remove element from the Queue
    private static void remove() {
        // If queue is Empty
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("SucessFully Removed -> " + head.data);
        // If Queue has single element
        if (head == tail)
            tail = null;
        // to remoeve first element, head is set to next element
        head = head.next;
    }

    // Time Complexity -> O(1)
    // Fn to print the Front element in the Queue
    private static void peek() {
        // If queue is Empty
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Element at the head of the Queue is -> " + head.data);
    }

    // Time Complexity -> O(n)
    // Fn to print all the element in the Queue
    public static void display() {
        // If Queue is Empty
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        Node newNode = head;
        System.out.print("Queue Elements :\nFront -> [");
        while (newNode != null) {
            System.out.print(newNode.data + ", ");
            newNode = newNode.next;
        }
        System.out.println("\b\b] <- End");
    }
}
