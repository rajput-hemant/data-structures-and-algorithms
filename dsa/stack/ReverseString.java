package stack;

import java.util.Scanner;

public class ReverseString {
    static Scanner sc = new Scanner(System.in);
    static Node top;

    class Node {
        char ch;
        Node next;

        Node(char ch) {
            this.ch = ch;
        }
    }

    public static void main(String[] args) {
        ReverseString stack = new ReverseString();
        String str = sc.nextLine();
        String newStr = "";
        for (char ch : str.toCharArray())
            stack.push(ch);
        while (!stack.isEmpty())
            newStr += stack.pop();
        System.out.println(newStr);
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(char ch) {
        Node newNode = new Node(ch);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    char pop() {
        if (top == null)
            return ' ';
        char ch = top.ch;
        top = top.next;
        return ch;
    }
}
