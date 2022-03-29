package linkedlist;

public class DoublyLinkedList {
    Node head, tail;
    int size = 0;

    // Fn to check if list is Empty
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void insertAtBegin(int data) {
        Node newNode = new Node(data);
        // If list is Empty
        if (isEmpty())
            head = tail = newNode;
        else {
            // newNode next will point to firstNode
            newNode.next = head;
            // prev of head will point to newNode
            head.prev = newNode;
            // head is set to newNode
            head = newNode;
        }
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
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        // If list is Empty
        if (isEmpty())
            head = tail = newNode;
        else {
            // newNode is assigned to the next of tail
            tail.next = newNode;
            // tail is assigned to the prev of of newNode
            newNode.prev = tail;
            // tail is set to the newNode
            tail = newNode;
        }
        System.out.println("Data Inserted!");
        size++;
    }

    public void delAtBegin() {
        // If list is Empty
        if (isEmpty())
            System.out.println("List is Empty!");
        // If list has only one element
        else if (head.next == null) {
            head = tail = null;
            System.out.println("List Successfully Cleared!");
            size = 0;
        } else {
            System.out.println("Sucessfully Deleted -> '" + head.data + "' from beginning.");
            // head from the firstNode is set to secNode, this removes the firstNode
            head = head.next;
            // prev of head is set to null
            head.prev = null;
            size--;
        }
    }

    public void delAtPos(int pos) {
        // If list is Empty
        if (isEmpty())
            System.out.println("List is Empty!");
        // If index is 0
        else if (pos == 0)
            System.out.println("Invalid Input! Index Starts from 1.");
        else if (pos == 1)
            delAtBegin();
        // If index is greater than the list size
        else if (pos > size)
            System.out.println("Invalid Input! List Size is: " + size);
        else {
            Node currentNode = head;
            // traverse till index
            for (int i = 0; i < pos - 2; i++)
                currentNode = currentNode.next;
            System.out.println("Sucessfully Deleted -> '" + currentNode.next.data + "' from position '" + pos + "'.");
            // this assigns the address of 2nd next element to the currentNode,
            // to the next of currentNode, removing the mid element
            currentNode.next = currentNode.next.next;
            // this assigns the address of currentNode to the prev of 2nd next element to
            // the currentNode,
            // to the prev of currentNode, removing the mid element
            currentNode.next.prev = currentNode;
            size--;
        }
    }

    public void delAtLast() {
        // If list is Empty
        if (isEmpty())
            System.out.println("List is Empty!");
        // If list have one element
        else if (head.next == null) {
            head = tail = null;
            System.out.println("List Successfully Cleared!");
            size = 0;
        } else {
            System.out.println("Sucessfully Deleted -> '" + tail.data + "' from Last.");
            // tail is set to second last element
            tail = tail.prev;
            // next of tail is set to null
            tail.next = null;
            size--;
        }
    }

    public void deleteAll() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        head = tail = null;
        System.out.println("List Successfully Cleared!");
        size = 0;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.print("[");
        for (Node currentNode = head; currentNode != null; currentNode = currentNode.next)
            System.out.print(currentNode.data + ", ");
        System.out.println("\b\b]\nList Size -> " + size);
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        System.out.print("[");
        for (Node currentNode = tail; currentNode != null; currentNode = currentNode.prev)
            System.out.print(currentNode.data + ", ");
        System.out.println("\b\b]" + "\nList Size -> " + size);
    }
}
