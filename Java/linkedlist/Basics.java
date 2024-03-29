package linkedlist;

import definitions.ListNode;

public class Basics {
    ListNode head;

    public static void main(String[] args) {
        Basics ob = new Basics();
        ob.addBegin(2);
        ob.addBegin(1);
        ob.addLast(3);
        ob.addLast(4);
        ob.addLast(5);
        ob.dislpay();
        ob.delBegin();
        ob.delLast();
        ob.dislpay();
    }

    // Add in the Beginning
    public void addBegin(int data) {
        ListNode newNode = new ListNode(data);
        // If list is Empty
        if (head == null) {
            head = newNode;
            return;
        }
        // newNode next will point to firstNode
        newNode.next = head;
        // head is set to newNode
        head = newNode;
    }

    // Add at last
    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
        // If list is Empty
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode currentNode = head;
        // traverse till last element
        while (currentNode.next != null)
            currentNode = currentNode.next;
        // lastNode next is set to newNode
        currentNode.next = newNode;
    }

    // To Dislpay
    public void dislpay() {
        // If list is Empty
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }

    // To delete from the beginning
    public void delBegin() {
        // If list is Empty
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        // head form the firstNode is set to secNode, this removes the firstNode
        head = head.next;
    }

    // To delete from the Last
    public void delLast() {
        // If list is Empty
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        // If list have one elements
        if (head.next == null) {
            head = null;
            return;
        }
        ListNode secLastNode = head;
        ListNode lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secLastNode = secLastNode.next;
        }
        // secLastNode is set to null, this removes last element
        secLastNode.next = null;
    }
}