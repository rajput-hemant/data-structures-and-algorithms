package queue;

import java.util.Scanner;

public class QueueWithArray {
    static Scanner sc = new Scanner(System.in);
    static int[] arr;
    static int rear;

    QueueWithArray() {
        arr = new int[100];
        rear = -1;
    }

    public static void main(String[] args) {
        QueueWithArray ob = new QueueWithArray();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Push \n" +
                    "2 to Pop \n" +
                    "3 to Peek \n" +
                    "4 to Display\n" +
                    "5 to Exit \n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ob.add();
                    break;
                case 2:
                    ob.remove();
                    break;
                case 3:
                    ob.peek();
                    break;
                case 4:
                    ob.display();
                    break;
                case 5:
                    System.out.println("Exited!");
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice!");
                    break;
            }
        }
    }

    // Time Complexity -> O(1)
    // enqueue/add - Fn to add elements in the Queue
    private void add() {
        if (rear == arr.length - 1) {
            System.out.println("Queue is Full!");
            return;
        }
        System.out.print("Enter the data -> ");
        int data = sc.nextInt();
        rear++;
        arr[rear] = data;
        System.out.println("Data inserted!");
    }

    // Time Complexity -> O(n)
    // dequeue/remove - Fn to print & remove element from the Queue
    private void remove() {
        if (rear == -1) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Successfully Removed -> " + arr[0]);
        // Shifting all the elements to the left
        for (int i = 0; i < rear; i++)
            arr[i] = arr[i + 1];
        rear--;
    }

    // Time Complexity -> O(1)
    // Fn to print the Front element in the Queue
    private void peek() {
        if (rear == -1) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Element at the Front of the Queue is  -> " + arr[0]);
    }

    // Time Complexity -> O(n)
    // Fn to print all the element in the Queue
    private void display() {
        if (rear == -1) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue Elements :\nFront -> [");
        for (int i = 0; i <= rear; i++)
            System.out.print(arr[i] + ", ");
        System.out.println("\b\b] <- End");
    }
}
