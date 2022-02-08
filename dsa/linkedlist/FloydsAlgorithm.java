package linkedlist;

public class FloydsAlgorithm {
    // Node head;

    class Node {
        Node next = null;

        Node(int next) {
            this.next = null;
        }
    }

    // Tortoise-Hare-Approach (Floyd's Algorithm)
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

    public boolean hasCycle(Node head) {
        if (head == null)
            return false;
        Node fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return false;
        }
        return true;
    }
}
