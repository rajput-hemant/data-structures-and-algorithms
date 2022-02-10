package stack;

import java.util.Scanner;
import java.util.Stack;

public class PushAtBottomOfTheStack {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Push \n" +
                    "2 to PushAtBottom \n" +
                    "3 to Pop \n" +
                    "4 to Peek \n" +
                    "5 to Exit \n" +
                    "Enter your choice -> ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the Data -> ");
                    int data = sc.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    System.out.print("Enter the data to push at the bottom -> ");
                    data = sc.nextInt();
                    pushAtBottom(data, stack);
                    System.out.println(data + " inserted at the bottom of the Stack.\n");
                    break;
                case 3:
                    if (stack.isEmpty())
                        System.out.println("Stack is Empty!");
                    else
                        System.out.println("Deleted -> " + stack.pop());
                    break;
                case 4:
                    if (stack.isEmpty())
                        System.out.println("Stack is Empty!");
                    else

                        System.out.println(stack.peek());
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

    public static void pushAtBottom(int data, Stack<Integer> stack) {
        // base case
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        // the uppermost element is popped & stored in top
        int top = stack.pop();
        // recursion call, after popping all the elements from the stack,
        // recursion will stop & new data will be pushed
        pushAtBottom(data, stack);
        // after pushing the new data, top elements will be pushed back in the stack
        stack.push(top);
    }
}
