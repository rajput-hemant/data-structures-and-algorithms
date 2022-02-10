package stack;

import java.util.ArrayList;
import java.util.Scanner;

public class StackWithArrayList {
    static Scanner sc = new Scanner(System.in);
    ArrayList<Integer> arrList = new ArrayList<>();

    public static void main(String[] args) {
        StackWithArrayList ob = new StackWithArrayList();
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

    // Fn to check is Stack is Empty
    private boolean isEmpty() {
        return arrList.size() == 0;
    }

    // Fn to push elements in the Stack
    private void push() {
        System.out.print("Enter the data -> ");
        int data = sc.nextInt();
        arrList.add(data);
        System.out.println("Data inserted!");
    }

    // Fn to print & pop elements from the Stack
    private void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty / Underflow");
            return;
        }
        System.out.println("Deleted -> " + arrList.get(arrList.size() - 1));
        arrList.remove(arrList.size() - 1);
    }

    // Fn to print the top element in the Stack
    private void peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty / Underflow");
            return;
        }
        System.out.println("Element at the top of the Stack -> " + arrList.get(arrList.size() - 1));
    }

    // Fn to print all the element in the Stack,
    // Top of the stack is at right & bottom is at left
    private void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty / Underflow");
            return;
        }
        System.out.print("Stack Elements -> [");
        for (int i = 0; i <= arrList.size() - 1; i++)
            System.out.print(arrList.get(i) + ", ");
        System.out.println("\b\b] <- Top");
    }

    // Fn to print all the element in the Stack,
    // Top of the stack is at left & bottom is at right
    /*
     * private void display() {
     * if (isEmpty()) {
     * System.out.println("Stack is Empty / Underflow");
     * return;
     * }
     * System.out.print("Stack Elements -> [");
     * for (int i = arrList.size()-1; i >= 0; i--)
     * System.out.print(arrList.get(i) + ", ");
     * System.out.println("\b\b] <- Bottom");
     * }
     */
}
