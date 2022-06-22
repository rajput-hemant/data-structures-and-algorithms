package queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueWithTwoStacks {
    static Scanner sc = new Scanner(System.in);
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

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
                    pop();
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
        return s1.isEmpty();
    }

    // Time Complexity -> O(n)
    // enqueue/add - Fn to add elements in the Queue
    private static void add() {
        System.out.print("Enter your Data -> ");
        int data = sc.nextInt();
        // remove top element from Stack s1 and add it to Statck s2 until s1 becomes empty
        while (!s1.isEmpty())
            s2.push(s1.pop());
        // add element to Stack s1
        s1.push(data);
        // remove top element from Stack s2 and add it to Statck s2 until s1 becomes empty
        while (!s2.isEmpty())
            s1.push(s2.pop());
        System.out.println("Data Inserted!");
    }

    // Time Complexity -> O(1)
    // dequeue/remove - Fn to print & remove element from the Queue
    private static void pop() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Successfully Removed -> " + s1.pop());
    }

    // Time Complexity -> O(1)
    // Fn to print the Front element in the Queue
    private static void peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Element at the Front of the Queue is  -> " + s1.peek());
    }

    // Time Complexity -> O(n)
    // Fn to print all the element in the Queue
    private static void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.print("Queue Elements :\nFront -> [");
        // remove & print top element from Stack s1 and add it to Statck s2 until s1 becomes empty
        while (!s1.isEmpty())
            System.out.print(s2.push(s1.pop()) + ", ");
        // remove top element from Stack s3 and add it to Statck s2 until s3 becomes empty
        while (!s2.isEmpty())
            s1.push(s2.pop());
        System.out.println("\b\b] <- End");
    }
}
