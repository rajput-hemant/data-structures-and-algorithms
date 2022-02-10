package stack;

import java.util.Scanner;

public class StackWithArray {
    static Scanner sc = new Scanner(System.in);
    int[] arr;
    int top;

    StackWithArray() {
        arr = new int[100];
        top = -1;
    }

    public static void main(String[] args) {
        StackWithArray ob = new StackWithArray();
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
                    ob.push();
                    break;
                case 2:
                    ob.pop();
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

    // Fn to push elements in the Stack
    private void push() {
        // when top is pointing at the last index of the array
        if (top == arr.length - 1) {
            System.out.println("Stack is full / Overflow!");
            return;
        }
        System.out.print("Enter the data -> ");
        int data = sc.nextInt();
        top++;
        arr[top] = data;
        System.out.println("Data inserted!");
    }

    // Fn to print & pop elements from the Stack
    private void pop() {
        if (top == -1) {
            System.out.println("Stack is Empty / Underflow");
            return;
        }
        System.out.println("Deleted -> " + arr[top]);
        top--;
    }

    // Fn to print the top element in the Stack
    private void peek() {
        if (top == -1) {
            System.out.println("Stack is Empty / Underflow");
            return;
        }
        System.out.println("Element at the top of the Stack -> " + arr[top]);
    }

    // Fn to print all the element in the Stack,
    // Top of the stack is at right & bottom is at left
    private void display() {
        if (top == -1) {
            System.out.println("Stack is Empty / Underflow");
            return;
        }
        System.out.print("Stack Elements -> [");
        for (int i = 0; i <= top; i++)
            System.out.print(arr[i] + ", ");
        System.out.println("\b\b] <- Top");
    }
    
    // Fn to print all the element in the Stack,
    // Top of the stack is at left & bottom is at right
    /*
     * private void display() {
     * if (top == -1) {
     * System.out.println("Stack is Empty / Underflow");
     * return;
     * }
     * System.out.print("Stack Elements -> [");
     * for (int i = top; i >= 0; i--)
     * System.out.print(arr[i] + ", ");
     * System.out.println("\b\b] <- Bottom");
     * }
     */
}
