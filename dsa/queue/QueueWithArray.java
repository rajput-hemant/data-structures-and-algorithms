package queue;

import java.util.Scanner;

public class QueueWithArray {
    static Scanner sc = new Scanner(System.in);
    static int[] arr = new int[100];
    static int rear = -1, front = -1;

    public static void main(String[] args) {
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Add \n" +
                    "2 to Remove \n" +
                    "3 to Peek \n" +
                    "4 to Display \n" +
                    "5 to Exit \n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    peek();
                    break;
                case 4:
                    display();
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

    // A utility fn to check is Queue is Empty
    private static boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    // Time Complexity -> O(1)
    // enqueue/add - Fn to add elements in the Queue
    private static void add() {
        if (rear == arr.length - 1) {
            System.out.println("Queue is Full!");
            return;
        }
        if (front == -1)
            front = 0;
        System.out.print("Enter the data -> ");
        int data = sc.nextInt();
        rear++;
        arr[rear] = data;
        System.out.println("Data inserted!");
    }

    // Time Complexity -> O(1)
    // dequeue/remove - Fn to print & remove element from the Queue
    private static void remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Successfully Removed -> " + arr[front]);
        if (front == rear) {
            front = rear = -1;
            System.out.println("Queue Cleared Sucessfully!");
            return;
        }
        front++;
    }

    // Time Complexity -> O(1)
    // Fn to print the Front element in the Queue
    private static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Element at the Front of the Queue is  -> " + arr[front]);
    }

    // Time Complexity -> O(n)
    // Fn to print all the element in the Queue
    private static void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue Elements :\nFront -> [");
        for (int i = 0; i <= rear; i++)
            System.out.print(arr[i] + ", ");
        System.out.println("\b\b] <- End");
    }
}
