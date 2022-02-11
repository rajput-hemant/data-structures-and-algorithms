package linkedlist;

import java.util.Scanner;

public class DoublyLinkedList {
    static Scanner sc = new Scanner(System.in);
    static Node head;
    static Node tail;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete\n" +
                    "4 to Delete All\n" +
                    "5 to exit()\n" +
                    "Enter your Choice -> ");
            int Choice = sc.nextInt();
            switch (Choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    deleteAll();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice! ");
            }
        }
    }

    static void insert() {
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            System.out.println("Data Inserted!");
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null)
            currentNode = currentNode.next;
        currentNode.next = newNode;
        newNode.prev = currentNode;
        tail = newNode;
        System.out.println("Data Inserted!");
    }

    static void delete() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.println("Deleted -> " + head.data);
        if (head.next == null)
            head = null;
        else {
            head = head.next;
            head.prev = null;
        }
    }

    static void display() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        // forward
        Node currentNode;
        for (currentNode = head; currentNode != null; currentNode = currentNode.next) {
            System.out.print(currentNode.data + " ");
        }
        System.out.println();
        // reverse
        for (currentNode = tail; currentNode != null; currentNode = currentNode.prev)
            System.out.print(currentNode.data + " ");
        System.out.println();
    }

    static void deleteAll() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.println("List Successfully Cleared!");
        head = null;
    }
}
