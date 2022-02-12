package linkedlist;

import java.util.Scanner;

public class DoublyLinkedList {
    static Scanner sc = new Scanner(System.in);
    static Node head;
    static Node tail;
    static int size = 0;

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
                    "5 to Print Reverse\n" +
                    "6 to exit()\n" +
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
                    printReverse();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice! ");
            }
        }
    }

    // Fn to check if list is Empty
    static boolean isEmpty() {
        return head == null && tail == null;
    }

    static void insert() {
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Insertion at Beginning\n" +
                    "2 to Insertion Inbetween\n" +
                    "3 to Insertion at Last\n" +
                    "4 Go Back\n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    insertBegin();
                    break;
                case 2:
                    insertInBtw();
                    break;
                case 3:
                    insertAtLast();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong Input!");
            }
        }
    }

    static void insertBegin() {
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        // If list is Empty
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            size++;
            System.out.println("Data Inserted!");
            return;
        }
        // newNode next will point to firstNode
        newNode.next = head;
        // prev of head will point to newNode
        head.prev = newNode;
        // head is set to newNode
        head = newNode;
        System.out.println("Data Inserted!");
        size++;
    }

    static void insertInBtw() {
        System.out.print("Enter the Index -> ");
        int i = sc.nextInt();
        // If index is 0
        if (i == 0) {
            System.out.println("Invalid Input! Index Starts from 1.");
            return;
        }
        // If index is 1
        if (i == 1) {
            insertBegin();
            return;
        }
        // If index is greater than the list size
        if (i > size) {
            System.out.println("Invalid Input! List Size is: " + size);
            return;
        }
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        Node currentNode = head;
        // traverse till index
        for (int j = 0; j < i - 2; j++)
            currentNode = currentNode.next;
        // this assign the next of currentNode i.e. address of next element to the next
        // of newNode
        newNode.next = currentNode.next;
        // this assigns the newNode to prev of next Node to currentNode
        currentNode.next.prev = newNode;
        // this assign the newNode to the next of currentNode
        // i.e. address of newNode is assigned in the next of currentNode
        currentNode.next = newNode;
        // this assign currentNode to the prev of newNode
        newNode.prev = currentNode;
        System.out.println("Data Inserted!");
        size++;
    }

    static void insertAtLast() {
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        // If list is Empty
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            System.out.println("Data Inserted!");
            size++;
            return;
        }
        // newNode is assigned to the next of tail
        tail.next = newNode;
        // tail is assigned to the prev of of newNode
        newNode.prev = tail;
        // tail is set to the newNode
        tail = newNode;
        System.out.println("Data Inserted!");
        size++;
    }

    static void delete() {
        // If list is Empty
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.print("Press:\n" +
                "1 to Deletion at Beginning\n" +
                "2 to Deletion Inbetween\n" +
                "3 to Deletion at Last\n" +
                "Enter your choice -> ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                delBegin();
                return;
            case 2:
                delInBtw();
                return;
            case 3:
                delAtLast();
                return;
            default:
                System.out.println("Wrong Input!");
        }
    }

    static void delBegin() {
        System.out.println("Deleted -> " + head.data);
        // If list has only one element
        if (head.next == null) {
            head = tail = null;
            System.out.println("List Successfully Cleared!");
        } else {
            // head from the firstNode is set to secNode, this removes the firstNode
            head = head.next;
            // prev of head is set to null
            head.prev = null;
            System.out.println("Successfully Deleted!");
        }
        size--;
    }

    static void delInBtw() {
        // If list has only 1 element
        if (head.next == null) {
            head = tail = null;
            System.out.println("List Successfully Cleared!");
            size = 0;
            return;
        }
        System.out.print("Enter the Index -> ");
        int i = sc.nextInt();
        // If index is 0
        if (i == 0) {
            System.out.println("Invalid Input! Index Starts from 1.");
            return;
        }
        if (i == 1) {
            delBegin();
            return;
        }
        // If index is equal to list size
        if (i == size) {
            delAtLast();
            return;
        }
        // If index is greater than the list size
        if (i > size) {
            System.out.println("Invalid Input! List Size is: " + size);
            return;
        }
        Node currentNode = head;
        // traverse till index
        for (int j = 0; j < i - 2; j++)
            currentNode = currentNode.next;
        // this assigns the address of 2nd next element to the currentNode,
        // to the next of currentNode, removing the mid element
        currentNode.next = currentNode.next.next;
        // this assigns the address of currentNode to the prev of 2nd next element to the currentNode,
        // to the prev of currentNode, removing the mid element
        currentNode.prev = currentNode.next.prev;
        System.out.println("Successfully Deleted!");
        size--;
    }

    static void delAtLast() {
        // If list have one element
        if (head.next == null) {
            head = tail = null;
            System.out.println("List Successfully Cleared!");
        } else {
            // tail is set to second last element
            tail = tail.prev;
            // next of tail is set to null
            tail.next = null;
            System.out.println("List Successfully Cleared!");
        }
        size--;
    }

    static void deleteAll() {
        System.out.println("List Successfully Cleared!");
        head = tail = null;
        size = 0;
    }

    static void display() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        Node currentNode;
        System.out.print("[");
        for (currentNode = head; currentNode != null; currentNode = currentNode.next) {
            System.out.print(currentNode.data + ", ");
        }
        System.out.println("\b\b]" + "\nList Size -> " + size);
    }

    static void printReverse() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        Node currentNode;
        System.out.print("[");
        for (currentNode = tail; currentNode != null; currentNode = currentNode.prev)
            System.out.print(currentNode.data + ", ");
        System.out.println("\b\b]" + "\nList Size -> " + size);
    }
}
