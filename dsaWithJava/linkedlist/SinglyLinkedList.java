package linkedlist;

public class SinglyLinkedList {
    int size = 0;
    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBegin(int data) {
        Node newNode = new Node(data);
        // If list is Empty
        if (isEmpty()) {
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

    public void insertAtPos(int data, int pos) {
        // If index is 0
        if (pos == 0)
            System.out.println("Invalid Input! Index Starts from 1.");
        // If index is 1
        else if (pos == 1)
            insertAtBegin(data);
        // If index is greater than the list size
        else if (pos > size)
            System.out.println("Invalid Input! List Size is: " + size);
        else {
            Node newNode = new Node(data);
            Node currentNode = head;
            // traverse till index
            for (int i = 0; i < pos - 2; i++)
                currentNode = currentNode.next;
            // this assign the next of currentNode i.e.
            // address of next element to the next of newNode
            newNode.next = currentNode.next;
            // this assign the newNode to the next of currentNode
            // i.e. address of newNode is assigned in the next of currentNode
            currentNode.next = newNode;
            System.out.println("Data Inserted!");
            size++;
        }
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        // If list is Empty
        if (isEmpty()) {
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

    public void delAtBegin() {
        // If List is Empty
        if (isEmpty())
            System.out.println("List is Empty!");
        // If list have one element
        else if (head.next == null) {
            head = null;
            System.out.println("List Successfully Cleared!");
            size = 0;
        } else {
            // head from the firstNode is set to secNode, this removes the firstNode
            head = head.next;
            System.out.println("Successfully Deleted!");
            size--;
        }
    }

    public void delAtPos(int pos) {
        // If List is Empty
        if (isEmpty())
            System.out.println("List is Empty!");
        // If list has only 1 element
        else if (head.next == null) {
            head = null;
            System.out.println("List Successfully Cleared!");
            size = 0;
        }
        // If index is 0
        else if (pos == 0)
            System.out.println("Invalid Input! Index Starts from 1.");
        else if (pos == 1)
            delAtBegin();
        // If index is equal to list size
        else if (pos == size)
            delAtLast();
        // If index is greater than the list size
        else if (pos > size)
            System.out.println("Invalid Input! List Size is: " + size);
        else {
            Node currentNode = head;
            // traverse till index
            for (int j = 0; j < pos - 2; j++)
                currentNode = currentNode.next;
            // this assigns the address of 2nd next element to the currentNode,
            // to the next of currentNode, removing the mid element
            currentNode.next = currentNode.next.next;
            System.out.println("Successfully Deleted!");
            size--;
        }
    }

    public void delAtLast() {
        // If List is Empty
        if (isEmpty())
            System.out.println("List is Empty!");
        // If list have one element
        else if (head.next == null) {
            head = null;
            System.out.println("List Successfully Cleared!");
            size = 0;
        } else {
            Node lastNode = head;
            // traverse till second last element
            while (lastNode.next.next != null)
                lastNode = lastNode.next;
            // second Last Node is set to null, this removes the address,
            // removing the last element
            lastNode.next = null;
            System.out.println("Successfully Deleted!");
            size--;
        }
    }

    public void deleteAll() {
        // If List is Empty
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.println("List Successfully Cleared!");
        head = null;
        size = 0;
    }

    public void display() {
        // If list is Empty
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        Node currentNode = head;
        System.out.print("[");
        while (currentNode != null) {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.next;
        }
        System.out.println("\b\b]\nList Size -> " + size);
    }
}
