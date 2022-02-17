package queue;

import java.util.Scanner;

public class CircularQueueWithArray {
    static Scanner sc = new Scanner(System.in);
    static int size = 100;
    static int[] arr = new int[size];
    static int front = -1, rear = -1;

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

    // Fn to check if Queue is Empty
    private static boolean isEmpty() {
        return rear == -1;
    }

    // Fn to check if Queue is Full
    private static boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Time Complexity -> O(1)
    // enqueue/add - Fn to add elements in the Queue
    private static void add() {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        // set front on the 0th index when adding the first element
        if (front == -1)
            front = 0;
        System.out.print("Enter the data -> ");
        int data = sc.nextInt();
        rear = (rear + 1) % size;
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
        // If single element
        if (front == rear)
            front = rear = -1;
        front = (front + 1) % size;
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
        // if queue is Empty
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue Elements :\nFront -> [");
        // If rear has not crossed the max size or queue rear is still greater then
        // front.
        if (rear >= front) {
            // Loop to print elements from front to rear.
            for (int i = front; i <= rear; i++)
                System.out.print(arr[i] + ", ");
            System.out.println("\b\b] <- End");
        }
        // If rear crossed the max index and indexing has started in loop
        else {
            // Loop for printing elements from front to max size or last index
            for (int i = front; i < size; i++)
                System.out.print(arr[i] + ", ");
            // Loop for printing elements from 0th index till rear position
            for (int i = 0; i <= rear; i++)
                System.out.print(arr[i] + ", ");
            System.out.println("\b\b] <- End");
        }
    }
}
