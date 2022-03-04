package recursion;

import java.util.Scanner;

public class FindOccurance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String -> ");
        String str = sc.next();
        System.out.print("Ente the Character you want to track -> ");
        char c = sc.next().charAt(0);
        findOccurance(str, 0, c);
        sc.close();
    }

    static int first = -1;
    static int last = -1;
    // Time Complexity -> O(n)
    static void findOccurance(String str, int i, char c) {
        // base case
        if(i == str.length()) {
            System.out.print("First & Last Occurance of character " + c + " is at Index -> " + first + " & " + last + " respectively");
            return;
        }
        if(c == str.charAt(i)) {
            if(first == -1)
                first = i;
            else
                last = i;
        }
        findOccurance(str, i+1, c);
    }
}
