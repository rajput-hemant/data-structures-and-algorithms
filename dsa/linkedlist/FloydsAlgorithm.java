package linkedlist;

public class FloydsAlgorithm {
    static Node head;

    static class Node {
        int data;
        Node next = null;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        FloydsAlgorithm list = new FloydsAlgorithm();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        // list.printList(head);
        list.removeCycle(head);
        System.out.print("LinkedList after removing loop -> [");
        list.printList(head);
        System.out.println("\b\b]");
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + ", ");
            head = head.next;
        }
    }

    // Tortoise-Hare-Approach (Floyd's Algorithm) to Find the Middle Node in the
    // LinkedList
    // The Hare pointer leaps 2 elements while turtle pointer leaps one
    public static Node findMiddle(Node head) {
        Node hare = head, turtle = head;
        // In case of odd length, e.g. 1 2 1, turtle will 2 as middle as hare.next &
        // hare.next.next are null
        // In case of even length, e.g. 1 2 3 3 2 1, turtle will return the second
        // middle,
        // as the hare will be on null & hare.next & hare.next.next are null
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    // Fn to check if List has loop/cycle
    public boolean hasCycle(Node head) {
        // If list is empty
        if (head == null)
            return false;
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    // Fn to remove loop/cycle from the List if any
    public void removeCycle(Node head) {
        Node slow = head, fast = head;
        boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        // If there is loop/cycle
        if (isCycle) {
            // slow pointer is set to head of the list, while fast is still on the node where fast & slow pointer met
            slow = head;
            // both pointers are traversed with one leap, the meeting node will be the starting node of the loop
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            // fast pointer is traversed with on leap from meeting node to the end of the list
            while (fast.next != slow)
                fast = fast.next;
            // when the last node is found, the next of last node is set to null to remove the loop/cycle
            fast.next = null;
        }
    }
}
