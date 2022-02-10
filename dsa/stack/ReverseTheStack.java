package stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseTheStack {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while (true) {
            System.out.print("Press:\n" +
                    "1 to Push \n" +
                    "2 to Pop \n" +
                    "3 to Reverse \n" +
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
                    if (stack.isEmpty())
                        System.out.println("Stack is Empty!");
                    else
                        System.out.println("Deleted -> " + stack.pop());
                    break;
                case 3:
                    reverseStack(stack);
                    System.out.println("Stack is Reversed!");
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

    private static void reverseStack(Stack<Integer> stack) {
        // base case
        if (stack.isEmpty())
            return;
        // uppermost element of the stack is popped & stored in top
        int top = stack.pop();
        // recursion call
        reverseStack(stack);
        // top elements are pushed at the bottom of the stack
        PushAtBottomOfTheStack.pushAtBottom(top, stack);
    }
}
