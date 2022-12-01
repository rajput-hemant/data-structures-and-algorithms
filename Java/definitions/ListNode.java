package definitions;

public class ListNode {
    public int data;
    public ListNode next, prev;

    public ListNode() {

    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next, ListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
