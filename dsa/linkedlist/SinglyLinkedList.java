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
        while(true) {
            System.out.print("Press:\n" +
                            "1 for Insert\n" +
                            "2 for Traverse\n" +
                            "3 for Delete\n" +
                            "4 for Delete All\n" +
                            "5 for exit()\n" +
                            "Enter your choice -> ");
            int choice = sc.nextInt();
            switch(choice) {
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!");
			}
		}
    }

    public void insert() {
        while(true) {
            System.out.print("Press:\n" +
                            "1 for Insertion at Beginning\n" +
                            "2 for Insertion Inbetween\n" +
                            "3 for Insertion at Last\n" +
                            "4 Go Back\n" +
                            "Enter your choice -> ");
            int choice = sc.nextInt();
            switch(choice) {
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
        while(true) {
            System.out.print("Press:\n" +
                            "1 for Deletion at Beginning\n" +
                            "2 for Deletion Inbetween\n" +
                            "3 for Deletion at Last\n" +
                            "4 Go Back\n" +
                            "Enter your choice -> ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    delBegin();
                    break;
                case 2:
                    delInBtw();
                    break;
                case 3:
                    delAtLast();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Wrong Input!");
            }
        }
    }

    public void insertBegin() {
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        // If list is Empty
        if(head == null) {
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
        // If list is Empty
        if(i == 0) {
            insertBegin();;
            return;
        }
        if(i == size) {
            insertAtLast();
            return;
        }
        if(i > size) {
            System.out.println("Invalid Input! List Size is: " + size);
            return;
        }
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        Node currentNode = head;
        // traverse till index
        for (int j = 0; j < i; j++)
            currentNode = currentNode.next;
        // lastNode next is set to newNode 
        currentNode.next = newNode;
        newNode.next = currentNode.next.next;
        System.out.println("Data Inserted!");
        size++;
    }

    public void insertAtLast() {
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        Node newNode = new Node(data);
        // If list is Empty
        if(head == null) {
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
        // If list is Empty
        if(head == null) {
            System.out.println("List is Empty!");
            return;
        }
        // head form the firstNode is set to secNode, this removes the firstNode
        head = head.next;
        System.out.println("Successfully Deleted!");
        size--;
    }

    public void delInBtw() {
        System.out.print("Enter the Index -> ");
        int i = sc.nextInt();
        // If list is Empty
        if(head == null) {
            System.out.println("List is Empty!");
            return;
        }
        Node currentNode = head;
        // traverse till index
        for (int j = 0; j < i; j++)
            currentNode = currentNode.next;
        currentNode.next = currentNode.next.next;
        System.out.println("Successfully Deleted!");
        size--;
    }

    public void delAtLast() {
        // If list is Empty
        if(head == null) {
            System.out.println("List is Empty!");
            return;
        }
        // If list have two elements
        if(head.next == null) {
            head = null;
            return;
        }
        Node secLastNode = head;
        Node lastNode = head.next;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            secLastNode = secLastNode.next;
        }
        // secLastNode is set to null, this removes last element
        secLastNode.next = null;
        System.out.println("Successfully Deleted!");
        size--;
    }

    public void deleteAll() {
        if(head == null) {
            System.out.println("List is Empty!");
            return;
        }
            System.out.println("List Cleared Successfully!");
        head = null;
        size = 0;
    }

    public void dislpay() {
        // If list is Empty
        if(head == null) {
            System.out.println("List is Empty!");
            return;
        }
        Node currentNode = head;
        System.out.print("[");
        while(currentNode != null) {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.next;
        }
        System.out.println("\b\b]" + "\nList Size -> " + size);
    }
}
