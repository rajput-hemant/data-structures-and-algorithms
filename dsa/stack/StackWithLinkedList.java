package stack;

import java.util.Scanner;

public class StackWithLinkedList {
    static Scanner sc = new Scanner(System.in);
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        StackWithLinkedList ob = new StackWithLinkedList();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Push \n" +
                    "2 to Pop \n" +
                    "3 to Peek \n" +
                    "4 to Display\n" +
                    "5 to Exit \n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ob.push();
                    break;
                case 2:
                    ob.pop();
                    break;
                case 3:
                    ob.peek();
                    break;
                case 4:
                    ob.display();
                    break;
                case 5:
                    System.out.println("Exited!");
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }

    // Fn to check is Stack is Empty
    private boolean isEmpty() {
        return head == null;
    }

    // Fn to push elements in the Stack
    private void push() {
        System.out.print("Enter the Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        System.out.println("Data Inserted!");
    }

    // Fn to print & pop elements from the Stack
    private void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty / Underflow!");
            return;
        }
        System.out.println("Deleted -> " + head.data);
        head = head.next;
    }

    // Fn to print the top element in the Stack
    private void peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty / UNderflow!");
            return;
        }
        System.out.println("Element at the top of the Stack -> " + head.data);
    }

    // Fn to print all the element in the Stack,
    // Top of the stack is at right & bottom is at left
    // Printing the Reverse Of the LinkedList
    public void display() {
        System.out.print("Stack Elements -> [");
        display(head);
        System.out.println("\b\b] <- Top");
    }

    public void display(Node head) {
        // base case
        if (head == null)
            return;
        display(head.next);
        System.out.print(head.data + ", ");
    }

    // Fn to print all the element in the Stack,
    // Top of the stack is at left & bottom is at right
    /*
     * private void display() {
     * if (isEmpty()) {
     * System.out.println("Stack is Empty / UNderflow!");
     * return;
     * }
     * Node temp = head;
     * System.out.print("Stack Elements -> [");
     * while (temp != null) {
     * System.out.print(temp.data + ", ");
     * temp = temp.next;
     * }
     * System.out.println("\b\b] <- Bottom");
     * }
     */
}
