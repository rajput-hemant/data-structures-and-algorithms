package linkedlist;

import java.util.Scanner;

public class SinglyLinkedList {
    static Scanner sc = new Scanner(System.in);
    int size = 0;
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
        SinglyLinkedList ob = new SinglyLinkedList();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Delete\n" +
                    "4 to Delete All\n" +
                    "5 to exit()\n" +
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }

    public void insert() {
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

    public void delete() {
        // If list is Empty
        if (head == null) {
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

    public void insertBegin() {
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        // If list is Empty
        if (head == null) {
            head = newNode;
            System.out.println("Data Inserted!");
            size++;
            return;
        }
        // newNode next will point to firstNode
        newNode.next = head;
        // head is set to newNode
        head = newNode;
        System.out.println("Data Inserted!");
        size++;
    }

    public void insertInBtw() {
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
        // this assign the next of currentNode i.e. address of next element to the next of newNode
        newNode.next = currentNode.next;
        // this assign the newNode to the next of currentNode
        // i.e. address of newNode is assigned in the next of currentNode
        currentNode.next = newNode;
        System.out.println("Data Inserted!");
        size++;
    }

    public void insertAtLast() {
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        // If list is Empty
        if (head == null) {
            head = newNode;
            System.out.println("Data Inserted!");
            size++;
            return;
        }
        Node currentNode = head;
        // traverse till last element
        while (currentNode.next != null)
            currentNode = currentNode.next;
        // lastNode next is set to newNode
        currentNode.next = newNode;
        System.out.println("Data Inserted!");
        size++;
    }

    public void delBegin() {
        // head from the firstNode is set to secNode, this removes the firstNode
        head = head.next;
        System.out.println("Successfully Deleted!");
        size--;
    }

    public void delInBtw() {
        // If list has only 1 element
        if (head.next == null) {
            head = null;
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
        System.out.println("Successfully Deleted!");
        size--;
    }

    public void delAtLast() {
        // If list have one element
        if (head.next == null) {
            head = null;
            System.out.println("List Successfully Cleared!");
            size = 0;
            return;
        }
        Node secLastNode = head;
        Node lastNode = head.next;
        // traverse till last element
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secLastNode = secLastNode.next;
        }
        // secLastNode is set to null, this removes the address, removing the last element
        secLastNode.next = null;
        System.out.println("Successfully Deleted!");
        size--;
    }

    public void deleteAll() {
        System.out.println("List Successfully Cleared!");
        head = null;
        size = 0;
    }

    public void display() {
        // If list is Empty
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        Node currentNode = head;
        System.out.print("[");
        while (currentNode != null) {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.next;
        }
        System.out.println("\b\b]" + "\nList Size -> " + size);
    }
}
