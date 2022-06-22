package linkedlist;

public class FloydsAlgorithm extends SinglyLinkedList {

    public static void main(String[] args) {
        FloydsAlgorithm ob = new FloydsAlgorithm();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Insert\n" +
                    "2 to Display\n" +
                    "3 to Creat Loop in List\n" +
                    "4 to Remove Loop from the List\n" +
                    "5 to exit()\n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ob.insert();
                    break;
                case 2:
                    ob.printList();
                    break;
                case 3:
                    ob.createCycle();
                    break;
                case 4:
                    ob.removeCycle();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice!");
            }
        }
    }
    // This Fn is to create loop in the LinkedList
    public void createCycle() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        Node newNode = head;
        Node lastNode = head;
        // to create a random integer btw 0 & size of the LinkedList, this will be the index where the loop is formed
        int randomNode = (int) (Math.random() * size);
        // traversing newNode from 0 to index, loop will form at the newNode
        for (int i = 0; i < randomNode; i++)
            newNode = newNode.next;
        // traverse till the last element
        while (lastNode.next != null)
            lastNode = lastNode.next;
        // next of lastNode will point to the newNode instead of pointing to null, creating a loop at the newNode
        lastNode.next = newNode;
        System.out.println("Loop created at -> " + newNode.data);
    }

    // Fn to print the elements int the LinkedList
    public void printList() {
        // If list is Empty
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }
        Node currentNode = head;
        // taking a flag variable to avoid infinte loop if cycle is present in the list
        int flag = 0;
        System.out.print("[");
        while (currentNode != null) {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.next;
            // if cycle is present is the list, then loop will stop after printing 100 elements
            if (flag == 100)
                break;
            flag++;
        }
        System.out.println("\b\b]\nList size -> " + size);
        if (flag > size)
            System.out.println("Stopped Printing after 100 iteration, due to loop present in the List");
    }

    // Tortoise-Hare-Approach (Floyd's Algorithm) to Find the Middle Node in the LinkedList
    // The Hare pointer leaps 2 elements while turtle pointer leaps one
    public Node findMiddle() {
        Node hare = head, turtle = head;
        // In case of odd length, e.g. 1 2 1, turtle will 2 as middle as hare.next & hare.next.next are null
        // In case of even length, e.g. 1 2 3 3 2 1, turtle will return the second middle,
        // as the hare will be on null & hare.next & hare.next.next are null
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    // Fn to check if List has loop/cycle
    public boolean hasCycle() {
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
    public void removeCycle() {
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
            System.out.println("Loop Successfully Removed!");
        }
    }
}
